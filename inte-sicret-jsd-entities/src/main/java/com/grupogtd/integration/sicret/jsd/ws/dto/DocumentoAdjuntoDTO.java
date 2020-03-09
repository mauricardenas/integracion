package com.grupogtd.integration.sicret.jsd.ws.dto;

import java.util.Arrays;

public class DocumentoAdjuntoDTO
{
    private String tipoObjeto;
    private Long idExterno;
    private String nombreArchivo;
    private String usuario;
    private String origen;
    private byte[] archivo;

    public String getTipoObjeto()
    {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto)
    {
        this.tipoObjeto = tipoObjeto;
    }

    public Long getIdExterno()
    {
        return idExterno;
    }

    public void setIdExterno(Long idExterno)
    {
        this.idExterno = idExterno;
    }

    public String getNombreArchivo()
    {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo)
    {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getOrigen()
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public byte[] getArchivo()
    {
        return archivo;
    }

    public void setArchivo(byte[] archivo)
    {
        this.archivo = archivo;
    }

    @Override
    public String toString()
    {
        return "DocumentoAdjuntoDTO{" +
                "tipoObjeto='" + tipoObjeto + '\'' +
                ", idExterno=" + idExterno +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", origen='" + origen + '\'' +
                '}';
    }
}
