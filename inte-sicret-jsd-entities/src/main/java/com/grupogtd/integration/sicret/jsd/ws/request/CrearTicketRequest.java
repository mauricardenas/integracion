package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;

/**
 * Created by Softtek on 16-02-2019.
 */

public class CrearTicketRequest implements Serializable
{
    private String serviceDeskId;
    private String requestTypeId;
    private RequestFieldValuesDTO requestFieldValues;
    private String raiseOnBehalfOf;

    public String getServiceDeskId()
    {
        return serviceDeskId;
    }

    public void setServiceDeskId(String serviceDeskId)
    {
        this.serviceDeskId = serviceDeskId;
    }

    public String getRequestTypeId()
    {
        return requestTypeId;
    }

    public void setRequestTypeId(String requestTypeId)
    {
        this.requestTypeId = requestTypeId;
    }

    public RequestFieldValuesDTO getRequestFieldValues()
    {
        return requestFieldValues;
    }

    public void setRequestFieldValues(RequestFieldValuesDTO requestFieldValues)
    {
        this.requestFieldValues = requestFieldValues;
    }

    public String getRaiseOnBehalfOf()
    {
        return raiseOnBehalfOf;
    }

    public void setRaiseOnBehalfOf(String raiseOnBehalfOf)
    {
        this.raiseOnBehalfOf = raiseOnBehalfOf;
    }

    @Override
    public String toString()
    {
        return "CrearTicketRequest{" +
                "serviceDeskId='" + serviceDeskId + '\'' +
                ", requestTypeId='" + requestTypeId + '\'' +
                ", requestFieldValues=" + requestFieldValues +
                ", raiseOnBehalfOf='" + raiseOnBehalfOf + '\'' +
                '}';
    }
}
