package com.grupogtd.integration.sicret.jsd.ws.service.impl;

import com.grupogtd.integration.sicret.jsd.ws.business.*;
import com.grupogtd.integration.sicret.jsd.ws.business.impl.CommonTemplateHandlerImpl;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;
import com.grupogtd.integration.sicret.jsd.ws.service.InteJsdSicretWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("InteJsdSicretWSService")
public class InteJsdSicretWSServiceImpl implements InteJsdSicretWSService
{
    @Autowired
    private RecibirInformacionJsdHandler recibirInformacionJsdHandler;

    @Autowired
    private JsdProcesarDataHandler jsdProcesarDataHandler;

    @Autowired
    private InsertCommentSicretHandler insertCommentSicretHandler;

    @Autowired
    private UpdateTicketStatusSicretHandler updateTicketStatusSicretHandler;

    @Autowired
    private InsertAttachmentFilesSicretHandler insertAttachmentFilesSicretHandler;

    @Autowired
    @Qualifier("updateResolutionAreaHandler")
    private CommonTemplateHandlerImpl<UpdateResolutionAreaRequest,UpdateResolutionAreaResponse> updateResolutionAreaHandler;

    @Override
    public RecibirInformacionResponse recibirInformacionJsd(RecibirInformacionRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return recibirInformacionJsdHandler.handle(request);
    }

    @Override
    public JsdProcesarDataResponse procesarData(JsdProcesarDataRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return jsdProcesarDataHandler.handle(request);
    }

    @Override
    public InsertCommentSicretResponse insertarComentario(InsertCommentSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return insertCommentSicretHandler.handle(request);
    }

    @Override
    public UpdateTicketStatusSicretResponse updateTicketStatusSicret(UpdateTicketStatusSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return updateTicketStatusSicretHandler.handle(request);
    }

    @Override
    public InsertAttachmentFilesSicretResponse insertAttachmentFilesSicret(InsertAttachmentFilesSicretRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return insertAttachmentFilesSicretHandler.handle(request);
    }

    @Override
    public UpdateResolutionAreaResponse updateResolutionArea(UpdateResolutionAreaRequest request)
            throws InteSicretJsdWSBusinessException
    {
        return updateResolutionAreaHandler.handle(request);
    }
}
