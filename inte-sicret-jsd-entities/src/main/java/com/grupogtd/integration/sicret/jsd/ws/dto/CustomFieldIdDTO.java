package com.grupogtd.integration.sicret.jsd.ws.dto;

import java.io.Serializable;

/**
 * Created by Softtek on 16-02-2019.
 */
public class CustomFieldIdDTO implements Serializable
{
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "CustomFieldIdDTO{" +
                "id='" + id + '\'' +
                '}';
    }
}
