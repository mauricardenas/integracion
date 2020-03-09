package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.RecibirInformacionRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.RecibirInformacionResponse;

public interface RecibirInformacionJsdHandler
{
    RecibirInformacionResponse handle(RecibirInformacionRequest request)
            throws InteSicretJsdWSBusinessException;
}
