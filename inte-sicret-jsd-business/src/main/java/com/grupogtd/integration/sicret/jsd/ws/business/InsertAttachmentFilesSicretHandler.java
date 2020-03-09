package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.InsertAttachmentFilesSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.InsertAttachmentFilesSicretResponse;

public interface InsertAttachmentFilesSicretHandler
{
    InsertAttachmentFilesSicretResponse handle(InsertAttachmentFilesSicretRequest request)   throws InteSicretJsdWSBusinessException;
}
