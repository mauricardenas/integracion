package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.EventosDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("eventosDAOImpl")
public class EventosDAOImpl extends BaseDAO implements EventosDAO
{
    private static final Log LOGGER = LogFactory.getLog(EventosDAOImpl.class);

    private static final String PATH_INSERTAR_EVENTO = "com.grupogtd.integration.sicret.jsd.ws.dao.EventosDAO.insertEvento";

    @Override
    public void insertEvento(String idEvento, String evento, String tipoEvento) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso EventosDAOImpl - insertEvento");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_evento", idEvento);
            params.put("p_evento", evento);
            params.put("p_tipo_evento", tipoEvento);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_INSERTAR_EVENTO, params);
            LOGGER.info("Saliendo EventosDAOImpl - insertEvento");

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_INSERTAR, e);
        }
    }

}
