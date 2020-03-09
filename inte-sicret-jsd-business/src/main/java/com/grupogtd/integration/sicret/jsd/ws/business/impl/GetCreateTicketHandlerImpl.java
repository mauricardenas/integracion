package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.AuthenticationInfoDTO;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.ErrorResponseConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.GetCreateTicketHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.ReclamoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.*;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.CrearTicketRequest;
import com.grupogtd.integration.sicret.jsd.ws.request.GetCreateTicketRequest;
import com.grupogtd.integration.sicret.jsd.ws.request.RequestFieldValuesDTO;
import com.grupogtd.integration.sicret.jsd.ws.response.CrearTicketJsdErrorResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.CrearTicketResponse;
import com.grupogtd.integration.sicret.jsd.ws.response.GetCreateTicketResponse;
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
 * Created by Softtek on 14-02-2019.
 */
@Component
public class GetCreateTicketHandlerImpl implements GetCreateTicketHandler
{

    private static final Log LOGGER = LogFactory.getLog(GetCreateTicketHandlerImpl.class);

    private static final String PROPERTY_KEY_JSD_CREAR_TICKET_ENDPOINT = "com.grupogtd.intesicretjsd.jsd.ws.crearTicket.endpoint";
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
    @Qualifier("reclamoDAOImpl")
    private ReclamoDAO reclamoDAO;


    @Override
    public GetCreateTicketResponse handle(GetCreateTicketRequest request) throws InteSicretJsdWSBusinessException
    {

        LOGGER.info("INFO!!! Paso por GetCreateTicketHandlerImpl - handle()");
        try
        {
            GetCreateTicketResponse response = new GetCreateTicketResponse();
            if (!ESTADO_APLICACION.equals(inteSicretJsdWSDAO.getEstadoValidacion(request.getIdAplicacion())))
            {
                throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_LISTA_VALIDACION);
            }
            /*if (reclamoDAO.isReclamoPadre(request.getIdEvento()) && EVENTO_RECLAMO_PADRE.equals(request.getEvento()) )
            {
                response.setRegistroProcesado(true);
                response.setReclamoPadre(false);
                return response;
            }*/

            String usuarioCreacion = inteSicretJsdWSDAO.getUsuarioCreacion(request.getIdEvento(), request.getEvento());
            CrearTicketRequest crearTicketRequest = buildNewCrearTicketRequest(request, usuarioCreacion);
            ConfigDTO configDTO = buildNewConfigDTO();

            CrearTicketResponse crearTicketResponse = callCrearTicket(configDTO, crearTicketRequest);

            LOGGER.info("crearTicketResponse" + crearTicketResponse);

            RespuestaBusDTO respuesta = new RespuestaBusDTO();
            respuesta.setIssueKey(crearTicketResponse.getIssueKey());
            respuesta.setIssueId(String.valueOf(crearTicketResponse.getIssueId()));
            respuesta.setEstado(crearTicketResponse.getCurrentStatus().getStatus());
            inteSicretJsdWSDAO.insertarJsdSeguimiento(respuesta, request.getIdEvento(), request.getEvento());


            response.setRegistroProcesado(true);
            return response;

        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);
            EventosDTO eventosDTO = new EventosDTO();
            eventosDTO.setIdEvento(Long.valueOf(request.getIdEvento()));
            eventosDTO.setIdExterno(request.getIdEvento());
            eventosDTO.setTipo("Crear ticket JSD");
            eventosDTO.setTipoEvento(request.getEvento());
            envioCorreoError(eventosDTO, e.getMessage(), e);
            //crear clase nueva mail notifier
            throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }

    }

    private CrearTicketResponse callCrearTicket(ConfigDTO configDTO, CrearTicketRequest crearTicketRequest) throws RestClientException
    {
        RestServiceCaller<CrearTicketRequest, CrearTicketResponse> caller = new RestServiceCallerAsJson<CrearTicketRequest, CrearTicketResponse>();
        CrearTicketResponse crearTicketResponse;
        try
        {
            LOGGER.info("Calling Service Create Ticket JSD with username");
            crearTicketResponse = caller.call(crearTicketRequest, CrearTicketResponse.class, configDTO);
        }
        catch (RestClientException e)
        {
            boolean isErrorCorreoInvalido = false;
            if (e.getErrorResponse() != null && e.getErrorResponse() instanceof CrearTicketJsdErrorResponse)
            {
                LOGGER.info("ErrorResponse = " + e.getErrorResponse());
                CrearTicketJsdErrorResponse errorResponse = (CrearTicketJsdErrorResponse) e.getErrorResponse();
                if (errorResponse.getErrorMessage().contains(crearTicketRequest.getRaiseOnBehalfOf() + " is not a valid email address"))
                {
                    isErrorCorreoInvalido = true;
                }
            }
            LOGGER.info("isErrorCorreoInvalido=" + isErrorCorreoInvalido);

            if (isErrorCorreoInvalido)
            {
                crearTicketRequest.setRaiseOnBehalfOf(crearTicketRequest.getRaiseOnBehalfOf() + "@grupogtd.com");

                LOGGER.info("Calling Service Create Ticket JSD with email");
                RestServiceCaller<CrearTicketRequest, CrearTicketResponse> retryCaller = new RestServiceCallerAsJson<CrearTicketRequest, CrearTicketResponse>();
                crearTicketResponse = retryCaller.call(crearTicketRequest, CrearTicketResponse.class, configDTO);

            }
            else
            {
                throw e;
            }

        }
        return crearTicketResponse;
    }

    private ConfigDTO buildNewConfigDTO() throws RestClientException
    {

        AuthenticationInfoDTO authInfo = new AuthenticationInfoDTO();
        authInfo.setUserService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_ENDPOINT_USER));
        authInfo.setPassService(getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_CREARTICKET_ENDPOINT));

        String urlService = getPropertiesClientHandler.getUrlService(PROPERTY_KEY_JSD_CREAR_TICKET_ENDPOINT);
        LOGGER.info("URL JSD" + urlService);
        ConfigDTO configDTO = new ConfigDTO(urlService, HttpSuccessStatus.CREATED);
        configDTO.setSSL(true);
        configDTO.setAuthInfo(authInfo);

        List<ErrorResponseConfigDTO> errorResponseConfig = new ArrayList<ErrorResponseConfigDTO>();
        errorResponseConfig.add(new ErrorResponseConfigDTO(CrearTicketJsdErrorResponse.class, new Response.Status[]{Response.Status.BAD_REQUEST}));
        errorResponseConfig.add(new ErrorResponseConfigDTO(
                        CrearTicketJsdErrorResponse.class,
                        new Response.Status[]{Response.Status.BAD_REQUEST, Response.Status.INTERNAL_SERVER_ERROR}
                )
        );
        configDTO.setErrorResponseConfig(errorResponseConfig);
        configDTO.setTimeOut(60000);

        return configDTO;
    }

    private CrearTicketRequest buildNewCrearTicketRequest(GetCreateTicketRequest request, String usuarioCreacion) throws DAOException
    {
        List<ConfiguracionTicketDTO> response = inteSicretJsdWSDAO.getConfiguracionTicket(request.getEvento());

        CustomFieldDTO custoKey = new CustomFieldDTO();
        CustomFieldDTO custoKey2 = new CustomFieldDTO();
        CustomFieldDTO custoKey3 = new CustomFieldDTO();
        CustomFieldDTO custoKey4 = new CustomFieldDTO();
        CustomFieldIdDTO custoKey5 = new CustomFieldIdDTO();
        CustomFieldIdDTO custoKey6 = new CustomFieldIdDTO();

        List<CustomFieldDTO> custoKeyList = new ArrayList<CustomFieldDTO>();
        List<CustomFieldDTO> custoKeyList2 = new ArrayList<CustomFieldDTO>();
        List<CustomFieldDTO> custoKeyList3 = new ArrayList<CustomFieldDTO>();
        List<CustomFieldIdDTO> custoKeyList5 = new ArrayList<CustomFieldIdDTO>();


        String resumenJSD = inteSicretJsdWSDAO.getResumen(request.getIdEvento(), request.getEvento());
        String descripcionJSD = inteSicretJsdWSDAO.getDescripcion(request.getIdEvento(), request.getEvento());


        ValuesDTO valuesDTO = new ValuesDTO();
        valuesDTO.setSelf(resumenJSD);
        valuesDTO.setValue(descripcionJSD);
        valuesDTO.setId(Integer.parseInt(response.get(0).getCategoria()));

        //Crear Request

        RequestFieldValuesDTO requestFieldValuesDTO = new RequestFieldValuesDTO();
        //se llena request con datos de JSD_CONFIGURACION
        requestFieldValuesDTO.setSummary(resumenJSD);
        requestFieldValuesDTO.setDescription(descripcionJSD);
        CustomFieldIdDTO customFieldIdDTO = new CustomFieldIdDTO();
        customFieldIdDTO.setId(response.get(0).getCategoria());
        requestFieldValuesDTO.setCustomfield_10400(customFieldIdDTO);
        custoKey.setKey(response.get(0).getZona());
        custoKeyList.add(custoKey);
        requestFieldValuesDTO.setCustomfield_10408(custoKeyList);
        custoKey2.setKey(response.get(0).getServicio());
        custoKeyList2.add(custoKey2);
        requestFieldValuesDTO.setCustomfield_10412(custoKeyList2);
        custoKey3.setKey(response.get(0).getComponente());
        custoKeyList3.add(custoKey3);
        requestFieldValuesDTO.setCustomfield_10413(custoKeyList3);

        //FIXME este valor no se esta utilizando
        custoKey4.setKey(response.get(0).getTelefono());
        List<CustomFieldDTO> custoKeyList4 = new ArrayList<CustomFieldDTO>();
        custoKeyList4.add(custoKey4);

        requestFieldValuesDTO.setCustomfield_10704(getConfiguration(SUBTIPO_LISTA_TELEFONO));

        custoKey5.setId(getConfiguration(SUBTIPO_LISTA_ZONA_INFORMADOR));
        requestFieldValuesDTO.setCustomfield_12505(custoKey5);

        if(request.getEvento().equals(EVENTO_RECLAMO_PADRE))
        {
            custoKey6.setId(getConfiguration(SUBTIPO_LISTA_INCIDENTE_MASIVO));
        }
        custoKeyList5.add(custoKey6);
        requestFieldValuesDTO.setCustomfield_12506(custoKeyList5);

        CrearTicketRequest crearTicketRequest = new CrearTicketRequest();
        crearTicketRequest.setRequestTypeId(response.get(0).getRequestTypeId());
        crearTicketRequest.setServiceDeskId(getConfiguration(SUBTIPO_LISTA_SERVICE_DESK_ID));
        crearTicketRequest.setRequestFieldValues(requestFieldValuesDTO);
        crearTicketRequest.setRaiseOnBehalfOf(usuarioCreacion);//"XPASTEN"
        return crearTicketRequest;
    }

    private String getConfiguration(String subTipoLista) throws DAOException
    {
        return inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, subTipoLista, ESTADO_LISTA_ACTIVO);
    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_CREAR_T, Constants.NOMBRE_PROCESO_INTE_SICRET_JSD_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }

    @Override
    public String getPropertieValue(String key, String ambiente) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Paso por GetClientRiskMessageHandlerImpl - getPropertyValue()");
        try
        {
            return inteSicretJsdWSDAO.getPropertyValue(key, ambiente);
        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }
}
