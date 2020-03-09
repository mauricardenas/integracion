package com.grupogtd.integration.sicret.jsd.ws.dto;

import java.io.Serializable;

/**
 * Created by Softtek on 19-02-2019.
 */
public class FieldsDTO implements Serializable
{
    private OrigenDTO customfield_10325;
    private PriorityDTO priority;

    public PriorityDTO getPriority()
    {
        return priority;
    }

    public void setPriority(PriorityDTO priority)
    {
        this.priority = priority;
    }

    public OrigenDTO getCustomfield_10325()
    {
        return customfield_10325;
    }

    public void setCustomfield_10325(OrigenDTO customfield_10325)
    {
        this.customfield_10325 = customfield_10325;
    }

    @Override
    public String toString()
    {
        return "FieldsDTO{" +
                "customfield_10325=" + customfield_10325 +
                '}';
    }
}
