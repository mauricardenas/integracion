package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;

public class UpdateTicketStatusSicretRequest implements Serializable
{
    private String idComunicacion;
    private String tipoEvento;
    private String metodo;

    public String getIdComunicacion()
    {
        return idComunicacion;
    }

    public void setIdComunicacion(String idComunicacion)
    {
        this.idComunicacion = idComunicacion;
    }

    public String getTipoEvento()
    {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento)
    {
        this.tipoEvento = tipoEvento;
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
        return "UpdateTicketStatusSicretRequest{" +
                "idComunicacion='" + idComunicacion + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
