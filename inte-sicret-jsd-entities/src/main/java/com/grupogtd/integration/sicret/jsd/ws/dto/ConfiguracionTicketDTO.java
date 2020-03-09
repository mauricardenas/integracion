package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 13-02-2019.
 */
public class ConfiguracionTicketDTO
{

    private String requestTypeId;
    private String categoria;
    private String zona;
    private String servicio;
    private String componente;
    private String resumen;
    private String descripcion;
    private String telefono;


    public String getRequestTypeId() { return requestTypeId; }

    public void setRequestTypeId(String requestTypeId) { this.requestTypeId = requestTypeId; }


    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getZona() { return zona; }

    public void setZona(String zona) { this.zona = zona; }

    public String getServicio() { return servicio; }

    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getComponente() { return componente; }

    public void setComponente(String componente) { this.componente = componente; }

    public String getResumen() { return resumen; }

    public void setResumen(String resumen) { this.resumen = resumen; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString()
    {
        return "ConfiguracionTicketDTO{" +
                "requestTypeId='" + requestTypeId + '\'' +
                ", categoria='" + categoria + '\'' +
                ", zona='" + zona + '\'' +
                ", servicio='" + servicio + '\'' +
                ", componente='" + componente + '\'' +
                ", resumen='" + resumen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
