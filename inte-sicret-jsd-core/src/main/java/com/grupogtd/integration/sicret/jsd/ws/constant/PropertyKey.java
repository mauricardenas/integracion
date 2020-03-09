package com.grupogtd.integration.sicret.jsd.ws.constant;

public enum PropertyKey
{

      JSD_ENDPOINT_HOST("com.grupogtd.intejsdsicret.jsd.ws.endpoint.host")
    , JSD_ENDPOINT_SCHEMA("com.grupogtd.intejsdsicret.jsd.ws.endpoint.schema")
    , JSD_ENDPOINT_PORT("com.grupogtd.intejsdsicret.jsd.ws.endpoint.port")
    , JSD_ENDPOINT_USER("com.grupogtd.intesicretjsd.jsd.ws.endpoint.user")
    , JSD_ENDPOINT_PASS("com.grupogtd.intesicretjsd.jsd.ws.endpoint.pass")
    ;

    private final String key;
    PropertyKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    @Override
    public String toString()
    {
        return "PropertyKey{" +
                "key='" + key + '\'' +
                '}';
    }
}
