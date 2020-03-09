package com.grupogtd.integration.sicret.jsd.ws.client.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.constant.HttpMethodType;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.client.InteJsdSicretWsApiClient;
import com.grupogtd.integration.sicret.jsd.ws.client.PropertyServiceDelegate;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InteJsdSicretWsApiClienImpl implements InteJsdSicretWsApiClient
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWsApiClientImpl.class);

    private static final String INTEGRATION_JIRA_JSD = "com.grupogtd.intesicretjsd.ws.endpoint";

    public JsdProcesarDataResponse procesarData(JsdProcesarDataRequest request) throws RestClientException
    {
        String urlProcesarDataJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlProcesarDataJsdService -> " + urlProcesarDataJsdService);
        urlProcesarDataJsdService=urlProcesarDataJsdService+request.getMetodo();
        LOGGER.info("urlProcesarDataJsdService ->"+urlProcesarDataJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlProcesarDataJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        config.setTimeOut(65000);

        RestServiceCaller<JsdProcesarDataRequest, JsdProcesarDataResponse>
                caller = new RestServiceCallerAsJson<JsdProcesarDataRequest, JsdProcesarDataResponse>();

        JsdProcesarDataResponse response = caller.call(request, JsdProcesarDataResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public UpdateTicketStatusSicretResponse updateTicketStatus(UpdateTicketStatusSicretRequest request) throws RestClientException
    {

        String urlUpdateTicketStatusJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlUpdateTicketStatusJsdService -> " + urlUpdateTicketStatusJsdService);
        urlUpdateTicketStatusJsdService=urlUpdateTicketStatusJsdService+request.getMetodo();
        LOGGER.info("urlUpdateTicketStatusJsdService ->"+urlUpdateTicketStatusJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlUpdateTicketStatusJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        config.setTimeOut(65000);

        RestServiceCaller<UpdateTicketStatusSicretRequest, UpdateTicketStatusSicretResponse>
                caller = new RestServiceCallerAsJson<UpdateTicketStatusSicretRequest, UpdateTicketStatusSicretResponse>();

        UpdateTicketStatusSicretResponse response = caller.call(request, UpdateTicketStatusSicretResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public InsertCommentSicretResponse insertCommentSicret(InsertCommentSicretRequest request) throws RestClientException
    {

        String urlinsertCommentSicretJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlinsertCommentSicretJsdService -> " + urlinsertCommentSicretJsdService);
        urlinsertCommentSicretJsdService=urlinsertCommentSicretJsdService+request.getMetodo();
        LOGGER.info("urlinsertCommentSicretJsdService ->"+urlinsertCommentSicretJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlinsertCommentSicretJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        config.setTimeOut(65000);

        RestServiceCaller<InsertCommentSicretRequest, InsertCommentSicretResponse>
                caller = new RestServiceCallerAsJson<InsertCommentSicretRequest, InsertCommentSicretResponse>();

        InsertCommentSicretResponse response = caller.call(request, InsertCommentSicretResponse.class, config);
        LOGGER.info(response);

        return response;
    }



    public InsertAttachmentFilesSicretResponse insertAttachmentFilesSicret(InsertAttachmentFilesSicretRequest request) throws RestClientException
    {

        String urlinsertAttachmentFilesSicretJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlinsertAttachmentFilesSicretJsdService -> " + urlinsertAttachmentFilesSicretJsdService);
        urlinsertAttachmentFilesSicretJsdService=urlinsertAttachmentFilesSicretJsdService+request.getMetodo();
        LOGGER.info("urlinsertAttachmentFilesSicretJsdService ->"+urlinsertAttachmentFilesSicretJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlinsertAttachmentFilesSicretJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        config.setTimeOut(65000);

        RestServiceCaller<InsertAttachmentFilesSicretRequest, InsertAttachmentFilesSicretResponse>
                caller = new RestServiceCallerAsJson<InsertAttachmentFilesSicretRequest, InsertAttachmentFilesSicretResponse>();

        InsertAttachmentFilesSicretResponse response = caller.call(request, InsertAttachmentFilesSicretResponse.class, config);
        LOGGER.info(response);

        return response;
    }

    public UpdateResolutionAreaResponse updateResolutionArea(UpdateResolutionAreaRequest request) throws RestClientException
    {
        String urlUpdateResolutionAreaSicretJsdService = PropertyServiceDelegate.getPropertyValue(INTEGRATION_JIRA_JSD);
        LOGGER.info("urlupdateResolutionAreaSicretJsdService -> " + urlUpdateResolutionAreaSicretJsdService);
        urlUpdateResolutionAreaSicretJsdService=urlUpdateResolutionAreaSicretJsdService+request.getMetodo();
        LOGGER.info("urlupdateResolutionAreaSicretJsdService ->"+urlUpdateResolutionAreaSicretJsdService);
        //2) Consumir el Servicio y retornar el response

        ConfigDTO config = new ConfigDTO(urlUpdateResolutionAreaSicretJsdService, HttpSuccessStatus.OK);
        config.setHttpMethod(HttpMethodType.POST);
        //config.setTimeOut(65000);

        RestServiceCaller<UpdateResolutionAreaRequest, UpdateResolutionAreaResponse>
                caller = new RestServiceCallerAsJson<UpdateResolutionAreaRequest, UpdateResolutionAreaResponse>();

        UpdateResolutionAreaResponse response = caller.call(request, UpdateResolutionAreaResponse.class, config);
        LOGGER.info(response);

        return response;
    }


}
