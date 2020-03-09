package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ListaValoresDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ListaValorItemDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("listaValoresDAOImpl")
public class ListaValoresDAOImpl extends BaseDAO implements ListaValoresDAO
{
    private static final Log LOGGER = LogFactory.getLog(ListaValoresDAOImpl.class);

    private static final String PATH_OBTENER_VALOR = "com.grupogtd.integration.sicret.jsd.ws.dao.ListaValoresDAO.obtenerValor";

    @Override
    public String obtenerValor(ListaValorItemDTO item) throws DAOException
    {
        LOGGER.info("Ingreso ListaValoresDAOImpl - obtenerValor");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("item", item);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_OBTENER_VALOR, params);
            String valor = (String) params.get("OUT_VALOR");
            LOGGER.info("Saliendo ListaValoresDAOImpl - obtenerValor ->" + valor);
            return valor;
        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_VALOR_NOVISIBLE, e);
        }
    }

}
