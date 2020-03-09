package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.BitacoraDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component("BitacoraDAO")
public class BitacoraDAOImpl  extends BaseDAO implements BitacoraDAO
{
    private static final Log LOGGER = LogFactory.getLog(BitacoraDAOImpl.class);

    private static final String PATH_INSERT_BITACORA_RECLAMO= "com.grupogtd.integration.sicret.jsd.ws.dao.BitacoraDAO.insertBitacora";


    @Override
    public void insertBitacora(String comentario, String idExterno) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso BitacoraDAOImpl - insertBitacora");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_comentario", comentario);
            params.put("p_id_externo", idExterno);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_INSERT_BITACORA_RECLAMO, params);
            LOGGER.info("Saliendo BitacoraDAOImpl - insertBitacora");
        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_INSERTAR_BITACORA_RECLAMO, e);
        }
    }



}
