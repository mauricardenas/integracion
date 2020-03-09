package com.grupogtd.integration.sicret.jsd.ws.response;

import java.io.Serializable;

/**
 * Created by Softtek on 12-03-2019.
 */
public class EstadoAplicacionResponse implements Serializable
{
    private boolean isVigente;

    public boolean isVigente()
    {
        return isVigente;
    }

    public void setVigente(boolean vigente)
    {
        isVigente = vigente;
    }

    @Override
    public String toString()
    {
        return "EstadoAplicacionResponse{" +
                "isVigente=" + isVigente +
                '}';
    }
}
