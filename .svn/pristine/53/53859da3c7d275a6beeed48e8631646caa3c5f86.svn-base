package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.component.rest.api.RestServiceCaller;
import com.grupogtd.component.rest.business.RestServiceCallerAsJson;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.component.rest.model.ConfigDTO;
import com.grupogtd.component.rest.model.HttpSuccessStatus;
import com.grupogtd.integration.sicret.jsd.ws.business.GetPropertiesClientHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Softtek on 19-03-2019.
 */
@Component("GetPropertiesClientHandlerImpl")
public class GetPropertiesClientHandlerImpl implements GetPropertiesClientHandler
{
    private static final String GET_PROPERTY_WS_URL = "/property-ws/service/getProperty";
    private static final Log LOGGER = LogFactory.getLog(GetPropertiesClientHandlerImpl.class);

     public String getUrlService(String propertyKey)
            throws RestClientException
    {

        String urlPropertyService = getBaseURL() + GET_PROPERTY_WS_URL;
        LOGGER.info("urlPropertyService >> "+urlPropertyService);

        ConfigDTO config = new ConfigDTO(urlPropertyService, HttpSuccessStatus.OK);

        GetPropertyRequest getPropertyRequest = new GetPropertyRequest();
        getPropertyRequest.setKey(propertyKey);

        RestServiceCaller<GetPropertyRequest, GetPropertyResponse>
                caller = new RestServiceCallerAsJson<GetPropertyRequest, GetPropertyResponse>();
        GetPropertyResponse outputObject = caller.call(getPropertyRequest, GetPropertyResponse.class, config);

        return outputObject.getValue();
    }

    private static String getBaseURL()
    {
        String ambiente = System.getProperty("ambiente");
        AmbienteType ambienteType = AmbienteType.getAmbienteType(ambiente);
        return ambienteType.getBaseURL();
    }


    private enum AmbienteType
    {
        DESARROLLO("DESARROLLO", "http://localhost:8080"),
        TESTING("TESTING", "http://10.1.202.222:8180"),
        HOMOLOGACION("HOMOLOGACION", "http://10.1.202.227:8380"),
        PRE_PRODUCCION("PRE-PRODUCCION", "http://10.1.202.227:8180"),
        PRODUCCION("PRODUCCION", "http://10.1.202.221:8080"),
        INVALIDO("INVALIDO", "http://10.1.202.221:8080");


        private final String ambiente;
        private final String baseURL;

        AmbienteType(String ambiente, String baseURL)
        {
            this.ambiente = ambiente;
            this.baseURL = baseURL;
        }

        public String getAmbiente()
        {
            return ambiente;
        }

        public String getBaseURL()
        {
            return baseURL;
        }

        public static AmbienteType getAmbienteType(String ambiente)
        {
            if (ambiente==null)
            {
                return AmbienteType.INVALIDO;
            }

            for (AmbienteType value : values())
            {
                if (value.getAmbiente().equalsIgnoreCase(ambiente)) return value;
            }
            return AmbienteType.INVALIDO;
        }
    }

    public static class GetPropertyRequest implements Serializable
    {
        private String key;

        public String getKey()
        {
            return key;
        }

        void setKey(String key)
        {
            this.key = key;
        }

        @Override
        public String toString()
        {
            return "GetPropertyRequest{" +
                    ", key='" + key + '\'' +
                    '}';
        }
    }

    public static class GetPropertyResponse implements Serializable
    {
        private String value;

        String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "GetPropertyResponse{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
