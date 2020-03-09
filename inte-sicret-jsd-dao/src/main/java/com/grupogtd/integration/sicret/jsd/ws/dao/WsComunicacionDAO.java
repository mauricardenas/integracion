package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;

public interface WsComunicacionDAO
{
    boolean insertarJsdComunicacion(String issueKey, String data)
            throws DAOException;

    String obtenerIssueKey(String idJsdComunicacion)
            throws DAOException;

    String getJsdRequestPayloadAsJson(String idComunicacion)
            throws DAOException;

    void updateActividad(String idActividad, String estado,String subEstado)
            throws DAOException;

}
