package com.grupogtd.integration.sicret.jsd.ws.service;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.*;
import com.grupogtd.integration.sicret.jsd.ws.response.*;

public interface InteJsdSicretWSService
{
    RecibirInformacionResponse recibirInformacionJsd(RecibirInformacionRequest request)
            throws InteSicretJsdWSBusinessException;

    JsdProcesarDataResponse procesarData(JsdProcesarDataRequest request)
            throws InteSicretJsdWSBusinessException;

    InsertCommentSicretResponse insertarComentario(InsertCommentSicretRequest request)
            throws InteSicretJsdWSBusinessException;

    UpdateTicketStatusSicretResponse updateTicketStatusSicret(UpdateTicketStatusSicretRequest request)
            throws InteSicretJsdWSBusinessException;

    InsertAttachmentFilesSicretResponse insertAttachmentFilesSicret(InsertAttachmentFilesSicretRequest request)
            throws InteSicretJsdWSBusinessException;

    UpdateResolutionAreaResponse updateResolutionArea(UpdateResolutionAreaRequest request)
            throws InteSicretJsdWSBusinessException;

}
