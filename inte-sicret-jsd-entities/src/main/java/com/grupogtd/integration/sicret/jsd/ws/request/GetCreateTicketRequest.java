package com.grupogtd.integration.sicret.jsd.ws.request;

import java.io.Serializable;

/**
 * Created by Softtek on 14-02-2019.
 */
public class GetCreateTicketRequest implements Serializable
{

    private String idEvento;
    private String evento;
    private String idAplicacion;
    private String metodo;

    public String getIdEvento() { return idEvento; }

    public void setIdEvento(String idEvento) { this.idEvento = idEvento; }

    public String getEvento() { return evento; }

    public void setEvento(String evento) { this.evento = evento; }

    public String getIdAplicacion(){ return idAplicacion; }

    public void setIdAplicacion(String idAplicacion) { this.idAplicacion = idAplicacion; }

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
        return "GetCreateTicketRequest{" +
                "idEvento='" + idEvento + '\'' +
                ", evento='" + evento + '\'' +
                ", idAplicacion='" + idAplicacion + '\'' +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
