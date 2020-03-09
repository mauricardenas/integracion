package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.AuthenticationInfoDTO;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.ErrorResponseConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.business.AddCommentTicketHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.AddCommentDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.AddCommentTicketRequest;
import com.grupogtd.integration.sicret.jsd.ws.request.AgregarComentarioRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.AddCommentTicketResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.AgregarComentarioResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.CrearTicketJsdErrorResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

/**
 * Created by Softtek on 15-03-2019.
 */
@Component
public class AddCommentTicketHandlerImpl implements AddCommentTicketHandler
{
    private static final Log LOGGER = LogFactory.getLog(AddCommentTicketHandlerImpl.class);

    private static final String PROPERTY_KEY_JSD_AGREGAR_COMENTARIO_TICKET_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.agregarComentario.endpoint";
    private static final String PROPERTY_KEY_JSD_ENDPOINT_USER = "com.grupogtd.intesicretjsd.jsd.ws.endpoint.user";
    private static final String PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.endpoint.pass";

    @Autowired
    @Qualifier("InteSicretJsdWSImpl")
    private InteSicretJsdWSDAO inteSicretJsdWSDAO;

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Autowired
    @Qualifier("GetPropertiesClientHandlerImpl")
    private GetPropertiesClientHandlerImpl getPropertiesClientHandler;

    @Override
    public AddCommentTicketResponse handle(AddCommentTicketRequest request) throws InteSicretJsdWSBusinessException
    {
        try
        {//Configuracion del bus
            if(!ESTADO_APLICACION.equals(inteSicretJsdWSDAO.getEstadoValidacion(request.getIdAplicacion())))
            {
                throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET);
            }
            //Se crea request que sera enviado al bus
            AddCommentTicketResponse response = new AddCommentTicketResponse();
            LOGGER.info("idBitacorA->" + request.getIdBitacora());
            List<AddCommentDTO> valores;
            valores = COMENTARIO_ACTIVIDAD.equals(request.getTipoEvento())
                    ? inteSicretJsdWSDAO.getComentarioActividad(request.getIdBitacora())
                    : inteSicretJsdWSDAO.getComentarioReclamo(request.getIdBitacora())
            ;
            LOGGER.info("valores->" + valores);
            if(USUARIO_CREACION.equals(valores.get(0).getUsuarioCreacion()))
            {
                LOGGER.info("COMENTARIO CON ORIGEN EN JSD");
                response.setCommentAdded(true);
                return response;
            }

            AgregarComentarioRequest agregarComentarioRequest = new AgregarComentarioRequest();
            agregarComentarioRequest.setBody(valores.get(0).getComentario());
            agregarComentarioRequest.set_public(true);
            ConfigDTO configDTO = buildNewConfigDTO(valores.get(0).getIssueKey());

            LOGGER.info("Se envia info al WS");

            AgregarComentarioResponse agregarComentarioResponse = callAddComment(configDTO, agregarComentarioRequest);
            LOGGER.info("agregarComentarioResponse-->" + agregarComentarioResponse);

            if (agregarComentarioResponse != null)
            {
                response.setCommentAdded(true);
                return response;
            }
            return new AddCommentTicketResponse();

        }catch(Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);
            EventosDTO eventosDTO = new EventosDTO();
            eventosDTO.setIdExterno(request.getIdBitacora());
            eventosDTO.setTipo("Enviar comentario a  ticket JSD");
            envioCorreoError(eventosDTO, e.getMessage(), e);
            //crear clase nueva mail notifier
            throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_ENVIAR_COMENTARIO, e);
        }
    }

    private AgregarComentarioResponse callAddComment(ConfigDTO configDTO, AgregarComentarioRequest  agregarComentarioRequest) throws RestClientException
    {
        RestServiceCaller<AgregarComentarioRequest, AgregarComentarioResponse> caller = new RestServiceCallerAsJson<AgregarComentarioRequest, AgregarComentarioResponse>();
        AgregarComentarioResponse agregarComentarioResponse;
        LOGGER.info("Calling Service Add Comment Ticket JSD with Issue Key");
        agregarComentarioResponse = caller.call(agregarComentarioRequest, AgregarComentarioResponse.class, configDTO);
        return agregarComentarioResponse;
    }

    private ConfigDTO buildNewConfigDTO(String  issueKey) throws RestClientException
    {
        LOGGER.info("issueKey--> " + issueKey);

        AuthenticationInfoDTO authInfo = new AuthenticationInfoDTO();
        authInfo.setUserService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_ENDPOINT_USER));
        authInfo.setPassService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT));

        String urlService = getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_AGREGAR_COMENTARIO_TICKET_ENDPOINT);//URL_JSD_CREAR_TICKET;
        urlService = urlService.replace("issueKey",issueKey);
        LOGGER.info("URL JSD" + urlService);

        ConfigDTO configDTO = new ConfigDTO(urlService, HttpSuccessStatus.CREATED);
        configDTO.setSSL(true);
        configDTO.setAuthInfo(authInfo);

        List<ErrorResponseConfigDTO> errorResponseConfig = new ArrayList<ErrorResponseConfigDTO>();
        errorResponseConfig.add(new ErrorResponseConfigDTO(CrearTicketJsdErrorResponse.class, new Response.Status[]{Response.Status.INTERNAL_SERVER_ERROR}));
        configDTO.setErrorResponseConfig(errorResponseConfig);
        configDTO.setTimeOut(60000);

        return configDTO;
    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_COMENTARIO, Constants.NOMBRE_PROCESO_INTE_SICRET_JSD_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }
}
