package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

public interface BitacoraDAO
{

    void insertBitacora(String comentario, String idReclamo)
            throws InteSicretJsdWSBusinessException;

}
