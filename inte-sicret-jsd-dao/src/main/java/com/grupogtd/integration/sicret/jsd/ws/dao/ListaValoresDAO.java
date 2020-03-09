package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.dto.ListaValorItemDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface ListaValoresDAO
{

    String obtenerValor(ListaValorItemDTO item) throws DAOException;

}
