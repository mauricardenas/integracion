package com.grupogtd.integration.sicret.jsd.ws.response;

import java.io.Serializable;

/**
 * Created by Softtek on 19-02-2019.
 */
public class ModifyTicketOriginResponse implements Serializable
{
    private boolean isModify;

    public boolean isModify()
    {
        return isModify;
    }

    public void setModify(boolean modify)
    {
        isModify = modify;
    }

    @Override
    public String toString()
    {
        return "ModifyTicketOriginResponse{" +
                "isModify=" + isModify +
                '}';
    }
}
