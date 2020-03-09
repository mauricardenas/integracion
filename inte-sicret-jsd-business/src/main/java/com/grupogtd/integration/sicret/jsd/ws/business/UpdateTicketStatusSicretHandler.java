package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.UpdateTicketStatusSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.UpdateTicketStatusSicretResponse;

public interface UpdateTicketStatusSicretHandler
{
    UpdateTicketStatusSicretResponse handle(UpdateTicketStatusSicretRequest request)
            throws InteSicretJsdWSBusinessException;
}
