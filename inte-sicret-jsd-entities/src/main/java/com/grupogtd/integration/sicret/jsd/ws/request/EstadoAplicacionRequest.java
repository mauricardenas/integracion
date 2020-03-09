package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;

/**
 * Created by Softtek on 12-03-2019.
 */
public class EstadoAplicacionRequest implements Serializable
{
    private String idAplicacion;
    private String metodo;

    public String getIdAplicacion()
    {
        return idAplicacion;
    }

    public void setIdAplicacion(String idAplicacion)
    {
        this.idAplicacion = idAplicacion;
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
        return "EstadoAplicacionRequest{" +
                "idAplicacion='" + idAplicacion + '\'' +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
