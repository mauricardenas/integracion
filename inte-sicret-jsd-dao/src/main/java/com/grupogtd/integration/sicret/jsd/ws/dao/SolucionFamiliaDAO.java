package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface SolucionFamiliaDAO
{

    String obtenerIdSolucion(String codigoSolucion)
            throws InteSicretJsdWSBusinessException;

    boolean existeSolucion(String idReclamo) throws InteSicretJsdWSBusinessException;
}
