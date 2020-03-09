package com.grupogtd.integration.sicret.jsd.ws.client;

import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.properties.ws.request.GetPropertyRequest;
import com.grupogtd.properties.ws.response.GetPropertyResponse;
import com.grupogtd.property.ws.PropertyWsApiClient;
import com.grupogtd.property.ws.impl.PropertyWsApiClientImpl;

public class PropertyServiceDelegate
{
    public static String getPropertyValue(String propertyKey)
            throws RestClientException
    {
        GetPropertyRequest getPropertyRequest = new GetPropertyRequest();
        getPropertyRequest.setKey(propertyKey);

        PropertyWsApiClient client = new PropertyWsApiClientImpl();
        GetPropertyResponse response = client.call(getPropertyRequest);

        return response.getValue();
    }
}
