package com.grupogtd.integration.sicret.jsd.ws.response;

import java.io.Serializable;

/**
 * Created by Softtek on 15-03-2019.
 */
public class AddCommentTicketResponse implements Serializable
{
    private boolean commentAdded;

    public boolean isCommentAdded()
    {

        return commentAdded;
    }

    public void setCommentAdded(boolean commentAdded)
    {
        this.commentAdded = commentAdded;
    }

    @Override
    public String toString()
    {
        return "AddCommentTicketResponse{" +
                "commentAdded=" + commentAdded +
                '}';
    }
}
