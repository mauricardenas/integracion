package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.AuthenticationInfoDTO;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.ErrorResponseConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.business.AddParticipantJsdHandler;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.AddParticipantJsdRequest;
import com.grupogtd.integration.sicret.jsd.ws.request.AgregarParticipanteRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.AddParticipantJsdResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.AgregarParticipanteResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.CrearTicketJsdErrorResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.ESTADO_APLICACION;

/**
 * Created by Softtek on 03-03-2019.
 */
@Component
public class AddParticipantJsdHandlerImpl implements AddParticipantJsdHandler
{
    private static final Log LOGGER = LogFactory.getLog(AddParticipantJsdHandlerImpl.class);

    @Autowired
    @Qualifier("InteSicretJsdWSImpl")
    private InteSicretJsdWSDAO inteSicretJsdWSDAO;

    @Autowired
    @Qualifier("GetPropertiesClientHandlerImpl")
    private GetPropertiesClientHandlerImpl getPropertiesClientHandler;

    private static final String PROPERTY_KEY_JSD_ENDPOINT_USER = "com.grupogtd.intesicretjsd.jsd.ws.endpoint.user";
    private static final String PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.endpoint.pass";
    private static final String PROPERTY_KEY_JSD_AGREGAR_PARTICIPANTE_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.agregarParticipante.endpoint";


    @Override
    public AddParticipantJsdResponse handle(AddParticipantJsdRequest request) throws InteSicretJsdWSBusinessException
    {

        AgregarParticipanteRequest agregarParticipanteRequest = new AgregarParticipanteRequest();
        AddParticipantJsdResponse response = new AddParticipantJsdResponse();

        try
        {//Configuracion del bus
            if (!ESTADO_APLICACION.equals(inteSicretJsdWSDAO.getEstadoValidacion(request.getIdAplicacion())))
            {
                return new AddParticipantJsdResponse();
            }
            //Se crea request que sera enviado al bus
            List<String> userList = new ArrayList<String>();
            userList.add(request.getUsuario());
            agregarParticipanteRequest.setUsernames(userList);
            ConfigDTO configDTO = buildNewConfigDTO(request);

            LOGGER.info("Se envia info al WS");

            AgregarParticipanteResponse agregarParticipanteResponse = callAddParticipant(configDTO, agregarParticipanteRequest);
            LOGGER.info("agregarParticipanteResponse" + agregarParticipanteResponse);

            if (agregarParticipanteResponse != null)
            {
                response = new AddParticipantJsdResponse();
                response.setParticipantAdded(true);
            }
        }
        catch (RestClientException e)
        {
            response.setParticipantAdded(false);

        }
        return response;
    }

    private AgregarParticipanteResponse callAddParticipant(ConfigDTO configDTO, AgregarParticipanteRequest agregarParticipanteRequest) throws RestClientException
    {
        RestServiceCaller<AgregarParticipanteRequest, AgregarParticipanteResponse> caller = new RestServiceCallerAsJson<AgregarParticipanteRequest, AgregarParticipanteResponse>();
        AgregarParticipanteResponse agregarParticipanteResponse;
        try
        {
            LOGGER.info("Calling Service Create Ticket JSD with username");
            agregarParticipanteResponse = caller.call(agregarParticipanteRequest, AgregarParticipanteResponse.class, configDTO);
        }
        catch (RestClientException e)
        {
            boolean isErrorCorreoInvalido = false;
            if (e.getErrorResponse() != null && e.getErrorResponse() instanceof CrearTicketJsdErrorResponse)
            {
                LOGGER.info("ErrorResponse = " + e.getErrorResponse());
                CrearTicketJsdErrorResponse errorResponse = (CrearTicketJsdErrorResponse) e.getErrorResponse();
                if (errorResponse.getErrorMessage().contains("Sorry, but the following usernames could not be added as participant to this request: " + agregarParticipanteRequest.getUsernames().get(0).toLowerCase()))
                {
                    isErrorCorreoInvalido = true;
                }
            }
            LOGGER.info("isErrorCorreoInvalido=" + isErrorCorreoInvalido);

            if (isErrorCorreoInvalido)
            {
                List<String> users = new ArrayList<String>();
                users.add(agregarParticipanteRequest.getUsernames().get(0) + "@grupogtd.com");
                agregarParticipanteRequest.setUsernames(users);

                LOGGER.info("Calling Service Create Ticket JSD with email");
                RestServiceCaller<AgregarParticipanteRequest, AgregarParticipanteResponse> retryCaller = new RestServiceCallerAsJson<AgregarParticipanteRequest, AgregarParticipanteResponse>();
                agregarParticipanteResponse = retryCaller.call(agregarParticipanteRequest, AgregarParticipanteResponse.class, configDTO);

            }
            else
            {
                throw e;
            }
        }
        return agregarParticipanteResponse;
    }

    private ConfigDTO buildNewConfigDTO(AddParticipantJsdRequest request)
            throws RestClientException
    {
        LOGGER.info("issueKey--> " + request.getIssueKey());

        AuthenticationInfoDTO authInfo = new AuthenticationInfoDTO();
        authInfo.setUserService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_ENDPOINT_USER));
        authInfo.setPassService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT));

        String urlService = getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_AGREGAR_PARTICIPANTE_ENDPOINT);
        urlService = urlService.replace("issueKey", request.getIssueKey());
        LOGGER.info("URL JSD" + urlService);

        ConfigDTO configDTO = new ConfigDTO(urlService, HttpSuccessStatus.OK);
        configDTO.setSSL(true);
        configDTO.setAuthInfo(authInfo);

        List<ErrorResponseConfigDTO> errorResponseConfig = new ArrayList<ErrorResponseConfigDTO>();
        errorResponseConfig.add(new ErrorResponseConfigDTO(CrearTicketJsdErrorResponse.class, new Response.Status[]{Response.Status.INTERNAL_SERVER_ERROR}));
        configDTO.setErrorResponseConfig(errorResponseConfig);
        configDTO.setTimeOut(60000);

        return configDTO;
    }


}
