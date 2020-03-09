package com.grupogtd.integration.sicret.jsd.ws.service.impl;

import com.grupogtd.integration.sicret.jsd.ws.business.AddParticipantJsdHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.GetCreateTicketHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.GetEstadoAplicacionHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.ModifyTicketOriginHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.impl.AddCommentTicketHandlerImpl;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;
import com.grupogtd.integration.sicret.jsd.ws.service.InteSicretJsdWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion del servicio
 * Created by rpalacios on 15-03-2017.
 */
@Service("inteSicretJsdWSService")
public class InteSicretJsdWSServiceImpl implements InteSicretJsdWSService
{

    @Autowired
    private GetCreateTicketHandler getCreateTicketHandler;
    @Autowired
    private ModifyTicketOriginHandler modifyTicketOriginHandler;
    @Autowired
    private AddParticipantJsdHandler addParticipantJsdHandler;
    @Autowired
    private GetEstadoAplicacionHandler getEstadoAplicacionHandler;
    @Autowired
    private AddCommentTicketHandlerImpl addCommentTicketHandler;


    @Override
    public GetCreateTicketResponse getCreateTicket(GetCreateTicketRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return getCreateTicketHandler.handle(request);
    }

    @Override
    public ModifyTicketOriginResponse modifyOriginTicket(ModifyTicketOriginRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return modifyTicketOriginHandler.handle(request);
    }

    @Override
    public AddParticipantJsdResponse addParticipantJsd(AddParticipantJsdRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return addParticipantJsdHandler.handle(request);
    }

    @Override
    public EstadoAplicacionResponse getEstadoAplicaion(EstadoAplicacionRequest request) throws InteSicretJsdWSBusinessException
    {
        return getEstadoAplicacionHandler.handle(request);
    }

    @Override
    public AddCommentTicketResponse addCommentTicket(AddCommentTicketRequest request) throws InteSicretJsdWSBusinessException
    {
        return addCommentTicketHandler.handle(request);
    }


}
