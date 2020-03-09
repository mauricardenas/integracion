package com.grupogtd.integration.sicret.jsd.ws.service;

import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Message Address Service Rest implementation
 * Created by rpalacios on 14-05-2017.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
@Controller
@RequestMapping("/")
public class InteJsdSicretWSRestService
{
    private static final Log LOGGER = LogFactory.getLog(InteJsdSicretWSRestService.class);

    @Autowired
    @Qualifier(value = "InteJsdSicretWSService")
    private InteJsdSicretWSService inteJsdSicretService;

    @RequestMapping(value = "recordJsdEvent", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    RecibirInformacionResponse recibirInformacionJsd(HttpEntity<String> request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("recibirInformacionJsd Starting..." );

        RecibirInformacionRequest recibirInformacionRequest = new RecibirInformacionRequest();
        recibirInformacionRequest.setJson(request.getBody());
        RecibirInformacionResponse response = inteJsdSicretService.recibirInformacionJsd(recibirInformacionRequest);
        LOGGER.info("recibirInformacionJsd Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "procesarData", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    JsdProcesarDataResponse procesarData(@RequestBody JsdProcesarDataRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("procesarData Starting... request:\n" + request);
        JsdProcesarDataResponse response = inteJsdSicretService.procesarData(request);
        LOGGER.info("procesarData Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "updateTicketStatusSicret", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    UpdateTicketStatusSicretResponse updateTicketStatusSicret(@RequestBody UpdateTicketStatusSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("updateTicketStatusSicret Starting... request:\n" + request);
        UpdateTicketStatusSicretResponse response = inteJsdSicretService.updateTicketStatusSicret(request);
        LOGGER.info("updateTicketStatusSicret Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "insertCommentSicret", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    InsertCommentSicretResponse insertCommentSicret(@RequestBody InsertCommentSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("insertCommentSicret Starting... request:\n" + request);
        InsertCommentSicretResponse response = inteJsdSicretService.insertarComentario(request);
        LOGGER.info("insertCommentSicret Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "insertAttachmentFiles", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    InsertAttachmentFilesSicretResponse insertAttachmentFiles(@RequestBody InsertAttachmentFilesSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("insertAttachmentFiles Starting... request:\n" + request);
        InsertAttachmentFilesSicretResponse response = inteJsdSicretService.insertAttachmentFilesSicret(request);
        LOGGER.info("insertAttachmentFiles Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "updateResolutionArea", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    UpdateResolutionAreaResponse updateResolutionArea(@RequestBody UpdateResolutionAreaRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("updateResolutionArea Starting... request:\n" + request);
        UpdateResolutionAreaResponse response = inteJsdSicretService.updateResolutionArea(request);
        LOGGER.info("updateResolutionArea Finishing... returning:\n" + response.toString());
        return response;
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ErrorResponse handleException(Exception ex)
    {
        LOGGER.error("Entrando a handleException()");

        ErrorResponse errorResponse = new ErrorResponse();

        String code = (ex instanceof InteSicretJsdWSBusinessException)
            ? ((InteSicretJsdWSBusinessException) ex ).getCode()
                : ErrorCode.BASE
            ;
        String message = (ex instanceof InteSicretJsdWSBusinessException)
                ? ex.getMessage()
                : ErrorMessage.BASE
                ;

        LOGGER.error(ex);

        errorResponse.setCode(code);
        errorResponse.setMessage(message);

        return errorResponse;
    }


}
