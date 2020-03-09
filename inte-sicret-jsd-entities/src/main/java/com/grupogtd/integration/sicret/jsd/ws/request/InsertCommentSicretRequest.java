package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;

public class InsertCommentSicretRequest implements Serializable
{
    private String idComunicacion;
    private String metodo;

    public String getIdComunicacion()
    {
        return idComunicacion;
    }

    public void setIdComunicacion(String idComunicacion)
    {
        this.idComunicacion = idComunicacion;
    }

    public String getMetodo()
    {
        return metodo;
    }

    public void setMetodo(String metodo)
    {
        this.metodo = metodo;
    }

    @Override
    public String toString()
    {
        return "InsertCommentSicretRequest{" +
                "idComunicacion='" + idComunicacion + '\'' +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
