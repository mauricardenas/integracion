package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

public interface CommonTemplateHandler<REQUEST, RESPONSE>
{
    RESPONSE handle(REQUEST request) throws InteSicretJsdWSBusinessException;
}
