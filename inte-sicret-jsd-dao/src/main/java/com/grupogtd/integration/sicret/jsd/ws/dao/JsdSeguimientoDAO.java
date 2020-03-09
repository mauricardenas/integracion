package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface JsdSeguimientoDAO
{
    String obtenerTipoEvento(String issueKey)
            throws InteSicretJsdWSBusinessException;

    String obtenerIdExterno(String issueKey)
            throws InteSicretJsdWSBusinessException;

    boolean existeIssueKey(String issueKey)
            throws InteSicretJsdWSBusinessException;

    String obtenerAreaResolutora(String issueKey)
            throws InteSicretJsdWSBusinessException;

    boolean actualizarAreaResolutora(String issueKey, String areaResolutora)
            throws InteSicretJsdWSBusinessException;

}
