package com.grupogtd.integration.sicret.jsd.ws.client.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.constant.HttpMethodType;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.client.InteSicretJsdWsApiClient;
import com.grupogtd.integration.sicret.jsd.ws.client.PropertyServiceDelegate;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Softtek on 10-01-2019.
 */
public class InteSicretJsdWsApiClientImpl implements InteSicretJsdWsApiClient
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWsApiClientImpl.class);

    private static final String INTEGRATION_JIRA_JSD = "com.grupogtd.intesicretjsd.ws.endpoint";

    public GetCreateTicketResponse createTicketJsd(GetCreateTicketRequest request)
            throws RestClientException
    {
        String urlCreateTicketJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlCreateTicketJsdService -> " + urlCreateTicketJsdService);
        urlCreateTicketJsdService=urlCreateTicketJsdService+request.getMetodo();
        LOGGER.info("urlCreateTicketJsdService ->"+urlCreateTicketJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlCreateTicketJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        config.setTimeOut(65000);

        RestServiceCaller<GetCreateTicketRequest, GetCreateTicketResponse>
                caller = new RestServiceCallerAsJson<GetCreateTicketRequest, GetCreateTicketResponse>();

        GetCreateTicketResponse response = caller.call(request, GetCreateTicketResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public ModifyTicketOriginResponse modifyOriginTicket(ModifyTicketOriginRequest request)
            throws RestClientException
    {
        String urlModifyTicketJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlModifyOriginTicketJsdService -> " + urlModifyTicketJsdService);
        urlModifyTicketJsdService=urlModifyTicketJsdService+request.getMetodo();
        LOGGER.info("urlModifyTicketJsdService ->"+urlModifyTicketJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlModifyTicketJsdService, HttpSuccessStatus.OK);
        config.setTimeOut(65000);

        RestServiceCaller<ModifyTicketOriginRequest, ModifyTicketOriginResponse>
                caller = new RestServiceCallerAsJson<ModifyTicketOriginRequest, ModifyTicketOriginResponse>();

        ModifyTicketOriginResponse response = caller.call(request, ModifyTicketOriginResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public AddParticipantJsdResponse addParticipantJsd(AddParticipantJsdRequest request) throws RestClientException
    {
        String urlAddParticipantJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlModifyOriginTicketJsdService -> " + urlAddParticipantJsdService);
        urlAddParticipantJsdService=urlAddParticipantJsdService+request.getMetodo();
        LOGGER.info("urlAddParticipantJsdService ->"+urlAddParticipantJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlAddParticipantJsdService, HttpSuccessStatus.OK);
        config.setTimeOut(65000);

        RestServiceCaller<AddParticipantJsdRequest, AddParticipantJsdResponse>
                caller = new RestServiceCallerAsJson<AddParticipantJsdRequest, AddParticipantJsdResponse>();

        AddParticipantJsdResponse response = caller.call(request, AddParticipantJsdResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public EstadoAplicacionResponse getEstadoAplicacion(EstadoAplicacionRequest request) throws RestClientException
    {
        String urlAddParticipantJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlGetEstadoAplicacion -> " + urlAddParticipantJsdService);
        urlAddParticipantJsdService=urlAddParticipantJsdService+request.getMetodo();
        LOGGER.info("urlGetEstadoAplicacion ->"+urlAddParticipantJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlAddParticipantJsdService, HttpSuccessStatus.OK);
        config.setTimeOut(65000);

        RestServiceCaller<EstadoAplicacionRequest, EstadoAplicacionResponse>
                caller = new RestServiceCallerAsJson<EstadoAplicacionRequest, EstadoAplicacionResponse>();

        EstadoAplicacionResponse response = caller.call(request, EstadoAplicacionResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public AddCommentTicketResponse addCommentTicket(AddCommentTicketRequest request) throws RestClientException
    {
        String urladdCommentTicketJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urladdCommentTicketJsdService -> " + urladdCommentTicketJsdService);
        urladdCommentTicketJsdService=urladdCommentTicketJsdService+request.getMetodo();
        LOGGER.info("urladdCommentTicketJsdService ->"+urladdCommentTicketJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urladdCommentTicketJsdService, HttpSuccessStatus.OK);

        RestServiceCaller<AddCommentTicketRequest, AddCommentTicketResponse>
                caller = new RestServiceCallerAsJson<AddCommentTicketRequest, AddCommentTicketResponse>();

        AddCommentTicketResponse response = caller.call(request, AddCommentTicketResponse.class, config);
        LOGGER.info(response);

        return response;
    }

}
