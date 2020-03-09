package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.SolucionReclamoDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("solucionReclamoDAOImpl")
public class SolucionReclamoDAOImpl extends BaseDAO implements SolucionReclamoDAO
{
    private static final Log LOGGER = LogFactory.getLog(SolucionReclamoDAOImpl.class);

    private static final String PATH_INSERTAR_SOLUCION_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.SolucionReclamoDAO.insertSolucionReclamo";
    private static final String PATH_UPDATE_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.SolucionReclamoDAO.procesarReclamoPadre";

    @Override
    public void insertSolucionReclamo(String idSolucion, String idReclamo, String bodyComment) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - insertSolucionReclamo");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_solucion", idSolucion);
            params.put("p_id_reclamo", idReclamo);
            params.put("p_body_comment", bodyComment);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_INSERTAR_SOLUCION_RECLAMO, params);
            LOGGER.info("Saliendo WsComunicacionDAOImpl - insertSolucionReclamo");

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_INSERTAR_SOL_RECLAMO, e);
        }
    }

    @Override
    public void updateReclamo(String idSolucion, String idReclamo, String bodyComment) throws InteSicretJsdWSBusinessException
    {

        LOGGER.info("Ingreso WsComunicacionDAOImpl - updateReclamo");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_solucion", idSolucion);
            params.put("p_id_reclamo", idReclamo);
            params.put("p_body_comment", bodyComment);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_UPDATE_RECLAMO, params);
            LOGGER.info("Saliendo WsComunicacionDAOImpl - updateReclamo");

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_UPDATE_RECLAMO, e);
        }
    }


}
