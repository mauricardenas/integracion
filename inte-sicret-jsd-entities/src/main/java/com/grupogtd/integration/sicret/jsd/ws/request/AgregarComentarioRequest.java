package com.grupogtd.integration.sicret.jsd.ws.request;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Softtek on 15-03-2019.
 */
@JsonIgnoreProperties
public class AgregarComentarioRequest implements Serializable
{
    private String body;
    @JsonProperty("public")
    private boolean _public;

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public boolean is_public()
    {
        return _public;
    }

    public void set_public(boolean _public)
    {
        this._public = _public;
    }

    @Override
    public String toString()
    {
        return "AgregarComentarioRequest{" +
                "body='" + body + '\'' +
                ", _public=" + _public +
                '}';
    }
}
