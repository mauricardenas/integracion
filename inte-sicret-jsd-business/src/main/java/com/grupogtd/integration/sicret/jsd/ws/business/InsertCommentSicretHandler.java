package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.InsertCommentSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.InsertCommentSicretResponse;

public interface InsertCommentSicretHandler
{
    InsertCommentSicretResponse handle(InsertCommentSicretRequest request)
            throws InteSicretJsdWSBusinessException;
}
