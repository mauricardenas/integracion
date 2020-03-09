package com.grupogtd.integration.sicret.jsd.ws.client;

import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;

/**
 * Created by Softtek on 10-01-2019.
 */
public interface InteSicretJsdWsApiClient
{
    GetCreateTicketResponse createTicketJsd(GetCreateTicketRequest request) throws RestClientException;

    ModifyTicketOriginResponse modifyOriginTicket(ModifyTicketOriginRequest request) throws RestClientException;

    AddParticipantJsdResponse addParticipantJsd(AddParticipantJsdRequest request ) throws  RestClientException;

    EstadoAplicacionResponse getEstadoAplicacion(EstadoAplicacionRequest request ) throws  RestClientException;

    AddCommentTicketResponse addCommentTicket(AddCommentTicketRequest request ) throws  RestClientException;
}
