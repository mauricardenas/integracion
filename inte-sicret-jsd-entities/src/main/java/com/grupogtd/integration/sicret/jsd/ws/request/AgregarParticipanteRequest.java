package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Softtek on 03-03-2019.
 */
public class AgregarParticipanteRequest implements Serializable
{
    private List<String> usernames;

    public List<String> getUsernames()
    {
        return usernames;
    }

    public void setUsernames(List<String> usernames)
    {
        this.usernames = usernames;
    }

    @Override
    public String toString()
    {
        return "AgregarParticipanteRequest{" +
                "usernames=" + usernames +
                '}';
    }
}
