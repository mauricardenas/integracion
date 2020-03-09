package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.SolucionFamiliaDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("solucionFamiliaDAOImpl")
public class SolucionFamiliaDAOImpl extends BaseDAO implements SolucionFamiliaDAO
{
    private static final Log LOGGER = LogFactory.getLog(SolucionFamiliaDAOImpl.class);

    private static final String PATH_OBTENER_ID_SOLUCION_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.SolucionFamiliaDAO.obtenerIdSolReclamo";
    private static final String PATH_EXISTE_SOLUCION_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.SolucionFamiliaDAO.existeSolucionReclamo";

    @Override
    public String obtenerIdSolucion(String codigoSolucion) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - obtenerIdSolucion");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_codigo_solucion", codigoSolucion);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_OBTENER_ID_SOLUCION_RECLAMO, params);
            String outIdSolucion = (String) params.get("OUT_ID_SOLUCION");
            LOGGER.info("Saliendo WsComunicacionDAOImpl - obtenerIdSolucion");
            return outIdSolucion;

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_ID_EXTERNO, e);
        }
    }

    @Override
    public boolean existeSolucion(String idReclamo) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - obtenerIdSolucion");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_reclamo", idReclamo);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_EXISTE_SOLUCION_RECLAMO, params);
            return 1 == (Integer) params.get("OUT_HAY_SOLUCION");

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_ID_SOLUCION, e);
        }
    }


}
