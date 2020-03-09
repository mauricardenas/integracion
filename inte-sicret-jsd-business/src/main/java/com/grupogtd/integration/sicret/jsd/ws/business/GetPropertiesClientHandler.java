package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.component.rest.exception.RestClientException;

/**
 * Created by Softtek on 19-03-2019.
 */
public interface GetPropertiesClientHandler
{
     String getUrlService(String propertyKey)
            throws RestClientException;
}
