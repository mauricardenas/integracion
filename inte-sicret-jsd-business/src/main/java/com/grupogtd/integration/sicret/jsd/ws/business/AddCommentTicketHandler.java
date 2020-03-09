package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.AddCommentTicketRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.AddCommentTicketResponse;

/**
 * Created by Softtek on 15-03-2019.
 */
public interface AddCommentTicketHandler
{
    AddCommentTicketResponse handle (AddCommentTicketRequest request)
            throws InteSicretJsdWSBusinessException;
}
