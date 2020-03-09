package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.business.GetEstadoAplicacionHandler;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.EstadoAplicacionRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.EstadoAplicacionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.ESTADO_APLICACION;

/**
 * Created by Softtek on 12-03-2019.
 */
@Component
public class GetEstadoAplicacionHandlerImpl implements GetEstadoAplicacionHandler
{

    @Autowired
    @Qualifier("InteSicretJsdWSImpl")
    private InteSicretJsdWSDAO inteSicretJsdWSDAO;

    @Override
    public EstadoAplicacionResponse handle(EstadoAplicacionRequest request) throws InteSicretJsdWSBusinessException
    {
        try
        {
        EstadoAplicacionResponse estadoAplicacionResponse = new EstadoAplicacionResponse();
        estadoAplicacionResponse.setVigente(false);
        String estadoValidacion=   inteSicretJsdWSDAO.getEstadoValidacion(request.getIdAplicacion());

        if(ESTADO_APLICACION.equals(estadoValidacion))
        {
            estadoAplicacionResponse.setVigente(true);
        }

        return estadoAplicacionResponse;
    }catch (Exception e)
        {

            throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_LISTA_VALIDACION, e);
        }
    }

}
