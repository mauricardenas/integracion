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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Message Address Service Rest implementation
 * Created by rpalacios on 14-05-2017.
 */
@Controller
@RequestMapping("/")
public class InteSicretJsdWSRestService
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSRestService.class);

    @Autowired
    @Qualifier(value = "inteSicretJsdWSService")
    private InteSicretJsdWSService inteSicretJsdService;

    @RequestMapping(value = "getCreateTicket", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    GetCreateTicketResponse getCreateTicket(@RequestBody GetCreateTicketRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("getCreateTicket Starting... request:\n" + request);
        GetCreateTicketResponse response = inteSicretJsdService.getCreateTicket(request);
        LOGGER.info("getCreateTicket Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "modifyOriginTicket", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ModifyTicketOriginResponse modifyOriginTicket(@RequestBody ModifyTicketOriginRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("modifyOriginTicket Starting... request:\n" + request);
        ModifyTicketOriginResponse response = inteSicretJsdService.modifyOriginTicket(request);
        LOGGER.info("modifyOriginTicket Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "addParticipant", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    AddParticipantJsdResponse addParticipant(@RequestBody AddParticipantJsdRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("addParticipant Starting... request:\n" + request);
        AddParticipantJsdResponse response = inteSicretJsdService.addParticipantJsd(request);
        LOGGER.info("addParticipant Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "getListaValidacion", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    EstadoAplicacionResponse getListaValidacion(@RequestBody EstadoAplicacionRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("addParticipant Starting... request:\n" + request);
        EstadoAplicacionResponse response = inteSicretJsdService.getEstadoAplicaion(request);
        LOGGER.info("addParticipant Finishing... returning:\n" + response.toString());
        return response;
    }

    @RequestMapping(value = "addCommentTicket", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    AddCommentTicketResponse addCommentTicket(@RequestBody AddCommentTicketRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("addCommentTicket Starting... request:\n" + request);
        AddCommentTicketResponse response = inteSicretJsdService.addCommentTicket(request);
        LOGGER.info("addCommentTicket Finishing... returning:\n" + response.isCommentAdded());
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
            : String.valueOf(ErrorCode.BASE)
            ;
        String message = (ex instanceof InteSicretJsdWSBusinessException)
                ? ex.getMessage()
                : String.valueOf(ErrorMessage.BASE)
                ;

        LOGGER.error(ex);

        errorResponse.setCode(code);
        errorResponse.setMessage(message);

        return errorResponse;
    }


}
