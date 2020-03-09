package com.grupogtd.integration.sicret.jsd.ws.request;

public class RecibirInformacionRequest
{
    private String json;

    public String getJson()
    {
        return json;
    }

    public void setJson(String json)
    {
        this.json = json;
    }

    @Override
    public String toString()
    {
        return "RecibirInformacionRequest{" +
                "json='" + json + '\'' +
                '}';
    }
}
