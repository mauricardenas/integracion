package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.constant.HttpMethodType;
import com.grupogtd.component.rest.model.AuthenticationInfoDTO;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.ModifyTicketOriginHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.ListaValoresDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.*;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.ModificarOrigenRequest;
import com.grupogtd.integration.sicret.jsd.ws.request.ModifyTicketOriginRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.ModificarOrigenResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.ModifyTicketOriginResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

/**
 * Created by Softtek on 19-02-2019.
 */
@Component
public class ModifyTicketOriginHandlerImpl implements ModifyTicketOriginHandler
{
    private static final Log LOGGER = LogFactory.getLog(ModifyTicketOriginHandlerImpl.class);

    private static final String PROPERTY_KEY_JSD_MODIFICAR_TICKET_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.modificarTicket.endpoint";
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

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("listaValoresDAOImpl")
    private ListaValoresDAO listaValoresDAO;

    @Override
    public ModifyTicketOriginResponse handle(ModifyTicketOriginRequest request) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Paso por ModifyTicketOriginHandlerImpl - handle()");
        try
        {
            ModifyTicketOriginResponse modifyTicketOriginResponse = new ModifyTicketOriginResponse();

            if (ESTADO_APLICACION.equals(inteSicretJsdWSDAO.getEstadoValidacion(request.getIdAplicacion())))
            {
                String origen = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ORIGEN, ESTADO_LISTA_ACTIVO);
                String issueKey = inteSicretJsdWSDAO.getIssueKey(request.getIdEvento());

                String tipoEvento = jsdSeguimientoDAO.obtenerTipoEvento(issueKey);

                ModificarOrigenRequest modificarOrigenRequest = new ModificarOrigenRequest();


                FieldsDTO fieldsDTO = new FieldsDTO();
                OrigenDTO origenDTO = new OrigenDTO();
                origenDTO.setId(origen);
                fieldsDTO.setCustomfield_10325(origenDTO);
                PriorityDTO priorityDTO = new PriorityDTO();
                if (EVENTO_RECLAMO_PADRE.equalsIgnoreCase(tipoEvento))
                {
                    ListaValorItemDTO listaValorItemDTO = new ListaValorItemDTO(TIPO_LISTA,SUBTIPO_LISTA_SEVERIDAD_RECLAMO,VALOR_VISIBLE_SEVERIDAD_RECLAMO,null,ESTADO_LISTA_ACTIVO);
                    String severidadReclamoPadre = listaValoresDAO.obtenerValor(listaValorItemDTO);
                    priorityDTO.setId(severidadReclamoPadre);
                    fieldsDTO.setPriority(priorityDTO);
                }else
                {
                    ListaValorItemDTO listaValorItemDTO = new ListaValorItemDTO(TIPO_LISTA,SUBTIPO_LISTA_SEVERIDAD_ACTIVIDAD,VALOR_VISIBLE_SEVERIDAD_ACTIVIDAD,null,ESTADO_LISTA_ACTIVO);
                    String severidadReclamoPadre = listaValoresDAO.obtenerValor(listaValorItemDTO);
                    priorityDTO.setId(severidadReclamoPadre);
                    fieldsDTO.setPriority(priorityDTO);
                }

                modificarOrigenRequest.setFields(fieldsDTO);

                //Configuracion del bus
                AuthenticationInfoDTO authInfo = new AuthenticationInfoDTO();
                authInfo.setUserService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_ENDPOINT_USER));
                authInfo.setPassService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT));

                String urlService = getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_MODIFICAR_TICKET_ENDPOINT) + issueKey;
                LOGGER.info("URL JSD-->" + urlService);

                ConfigDTO configDTO = new ConfigDTO(urlService, HttpSuccessStatus.NO_CONTENT);
                configDTO.setAuthInfo(authInfo);
                configDTO.setHttpMethod(HttpMethodType.PUT);
                configDTO.setTimeOut(60000);
                configDTO.setSSL(true);

                LOGGER.info("Se envia info al WS ");

                RestServiceCaller<ModificarOrigenRequest, ModificarOrigenResponse> caller = new RestServiceCallerAsJson<ModificarOrigenRequest, ModificarOrigenResponse>();
                caller.call(modificarOrigenRequest, ModificarOrigenResponse.class, configDTO);
                modifyTicketOriginResponse.setModify(true);
            }
            LOGGER.info("estado modificacion" + modifyTicketOriginResponse);
            return modifyTicketOriginResponse;
        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);
            EventosDTO eventosDTO = new EventosDTO();
            eventosDTO.setIdEvento(Long.valueOf(request.getIdEvento()));
            eventosDTO.setIdExterno(request.getIdEvento());
            eventosDTO.setTipo("Modificar Origen ticket JSD");
            envioCorreoError(eventosDTO, e.getMessage(), e);
            //crear clase nueva mail notifier
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            LOGGER.info("ENTRANDO A ENVIO CORREO POR ERROR--> " + com.grupogtd.integration.sicret.jsd.ws.constant.Constants.VALOR_VISIBLE_CORREO_ASUNTO_MOD_T);
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_MOD_T, Constants.NOMBRE_PROCESO_INTE_SICRET_JSD_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }


}
