package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface EventosDAO
{
    void insertEvento(String idEvento, String evento, String tipoEvento) throws InteSicretJsdWSBusinessException;
}
