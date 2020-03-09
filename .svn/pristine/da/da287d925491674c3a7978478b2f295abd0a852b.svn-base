package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ReclamoDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component("reclamoDAOImpl")
public class ReclamoDAOImpl  extends BaseDAO implements ReclamoDAO
{
    private static final Log LOGGER = LogFactory.getLog(ReclamoDAOImpl.class);

    private static final String PATH_IS_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.ReclamoDAO.obtenerSeveidadReclamo";

    @Override
    public boolean isReclamoPadre(String idReclamo) throws InteSicretJsdWSBusinessException
    {

        LOGGER.info("Ingreso ReclamoDAOImpl - isReclamoPadre");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_reclamo", Integer.parseInt(idReclamo));
            getSqlSession().selectOne(PATH_IS_RECLAMO, params);
            return 1 == (Integer) params.get("OUT_SEVERIDAD");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_RECLAMO_PADRE , e);
        }
    }
}
