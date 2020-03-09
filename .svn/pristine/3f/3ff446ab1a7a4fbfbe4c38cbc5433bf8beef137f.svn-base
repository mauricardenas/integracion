package com.grupogtd.integration.sicret.jsd.ws.dto;

import java.io.Serializable;

/**
 * Created by softtek on 26/02/2019.
 */
public class EventosDTO implements Serializable
{

    public EventosDTO(String tipo, String tipoEvento)
    {
        this.tipo = tipo;
        this.tipoEvento = tipoEvento;
    }

    public EventosDTO(String idExterno, String tipo, String tipoEvento)
    {
        this.idExterno = idExterno;
        this.tipo = tipo;
        this.tipoEvento = tipoEvento;
    }

    public EventosDTO()
    {
    }

    private String idExterno;
    private Long idEvento;
    private String tipo;
    private String tipoEvento;

    public String getTipoEvento()
    {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento)
    {
        this.tipoEvento = tipoEvento;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TblEventosDTO{" +
                "idExterno='" + idExterno + '\'' +
                ", idEvento=" + idEvento +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
