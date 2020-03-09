package com.grupogtd.integration.sicret.jsd.ws.business;

import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;

public class ErrorMailNotiferInput
{
    private final Exception e;
    private final EventosDTO eventosDTO;
    private final String mensajeError;
    private final String asunto;
    private final String nombreProceso;

    public ErrorMailNotiferInput(Exception e, EventosDTO eventosDTO, String mensajeError, String asunto, String nombreProceso)
    {
        this.e = e;
        this.eventosDTO = eventosDTO;
        this.mensajeError = mensajeError;
        this.asunto = asunto;
        this.nombreProceso = nombreProceso;
    }

    public Exception getE()
    {
        return e;
    }

    public EventosDTO getEventosDTO()
    {
        return eventosDTO;
    }

    public String getMensajeError()
    {
        return mensajeError;
    }

    public String getAsunto()
    {
        return asunto;
    }

    public String getNombreProceso()
    {
        return nombreProceso;
    }
}
