package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.business.CommonTemplateHandler;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.GrupoResolutorNotFoundException;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class CommonTemplateHandlerImpl<REQUEST, RESPONSE> implements CommonTemplateHandler<REQUEST, RESPONSE>
{
    private static final Log LOGGER = LogFactory.getLog(CommonTemplateHandlerImpl.class);

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Override
    public RESPONSE handle(REQUEST request) throws InteSicretJsdWSBusinessException
    {
        try
        {   return handleRequest(request);
        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.FAILED_UPDATE_RESOLUTION_AREA, e);
            envioCorreoError(getEventoDTO(request)
                    , getAsunto()
                    , e.getMessage()
                    , e
            );
            throw new InteSicretJsdWSBusinessException(getErrorMessage(), e);
        }
    }

    private void envioCorreoError(EventosDTO eventos, String asunto, String mensajeError, Exception e)
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, asunto, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));

        }
        catch (Exception ex)
        {
            LOGGER.error(ex);
        }
    }

    protected abstract EventosDTO getEventoDTO(REQUEST request);

    protected abstract String getErrorMessage();

    protected abstract String getAsunto();

    protected abstract RESPONSE handleRequest(REQUEST request) throws InteSicretJsdWSBusinessException, GrupoResolutorNotFoundException;
}
