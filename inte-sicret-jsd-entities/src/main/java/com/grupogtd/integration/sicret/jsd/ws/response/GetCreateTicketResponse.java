package com.grupogtd.integration.sicret.jsd.ws.response;

import java.io.Serializable;

/**
 * Created by Softtek on 14-02-2019.
 */
public class GetCreateTicketResponse implements Serializable
{
  private boolean registroProcesado;
  private boolean isReclamoPadre;

  public boolean isReclamoPadre()
  {
    return isReclamoPadre;
  }

  public void setReclamoPadre(boolean reclamoPadre)
  {
    isReclamoPadre = reclamoPadre;
  }

  public boolean isRegistroProcesado()
  {
    return registroProcesado;
  }

  public void setRegistroProcesado(boolean registroProcesado)
  {
    this.registroProcesado = registroProcesado;
  }

  @Override
  public String toString()
  {
    return "GetCreateTicketResponse{" +
            "registroProcesado=" + registroProcesado +
            ", isReclamoPadre=" + isReclamoPadre +
            '}';
  }
}
