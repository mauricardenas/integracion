package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface SolucionReclamoDAO
{
    void insertSolucionReclamo(String idSolucion, String idReclamo, String bodyComment)
            throws InteSicretJsdWSBusinessException;

    void updateReclamo(String idSolucion, String idReclamo, String bodyComment)
            throws InteSicretJsdWSBusinessException;

}
