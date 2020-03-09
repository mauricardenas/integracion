package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ArchivoAdjuntoDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("archivoAdjuntoDAOImpl")
public class ArchivoAdjuntoDAOImpl extends BaseDAO implements ArchivoAdjuntoDAO
{
    private static final Log LOGGER = LogFactory.getLog(ReclamoDAOImpl.class);

    private static final String PATH_HAY_ARCHIVO_ADJUNTO = "com.grupogtd.integration.sicret.jsd.ws.dao.ArchivoAdjuntoDAO.hayArchivoAdjunto";
    @Override
    public boolean hayArchivoAdjunto(String idExterno, String nombreArchivo) throws DAOException
    {
        LOGGER.info("hayArchivoAdjunto(idExterno["+idExterno+"], nombreArchivo["+nombreArchivo+"])");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_externo",idExterno);
            params.put("p_nombre_archivo", nombreArchivo);
            getSqlSession().selectOne(PATH_HAY_ARCHIVO_ADJUNTO, params);
            boolean existsArchivoAdjunto = 1 == (Integer) params.get("OUT_ARCHIVO_ADJUNTO");
            LOGGER.info("hayArchivoAdjunto() returning -> " + existsArchivoAdjunto);
            return existsArchivoAdjunto;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_ARCHIVO_ADJUNTO, e);
        }
    }
}
