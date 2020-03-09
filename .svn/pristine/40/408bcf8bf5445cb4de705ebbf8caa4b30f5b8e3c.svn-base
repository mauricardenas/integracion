package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.JsdProcesarDataHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.EventosDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.EventTypeNotFoundException;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.JsdProcesarDataRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.JsdProcesarDataResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.EVENTO_RECLAMO_PADRE;

@Component
public class JsdProcesarDataHandlerImpl implements JsdProcesarDataHandler
{
    private static final Log LOGGER = LogFactory.getLog(JsdProcesarDataHandlerImpl.class);

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("eventosDAOImpl")
    private EventosDAO eventosDAO;

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Override
    public JsdProcesarDataResponse handle(JsdProcesarDataRequest request) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Paso por JsdProcesarDataHandlerImpl - handle()");
        LOGGER.info("JsdProcesarDataRequest-->" + request);
        try
        {
            String data = wsComunicacionDAO.getJsdRequestPayloadAsJson(request.getIdJsdComunicacion());
            String issueKey = wsComunicacionDAO.obtenerIssueKey(request.getIdJsdComunicacion());
            String tipoEvento = jsdSeguimientoDAO.obtenerTipoEvento(issueKey);

            if(tipoEvento == null)
            {
                throw new EventTypeNotFoundException();
            }


            String jsonData = JsonDataRetriever.getData(data, "$.transition.transitionName", String.class);
            boolean hasTransitionName = null != jsonData;
            if (EVENTO_RECLAMO_PADRE.equals(tipoEvento) && hasTransitionName)
            {
                eventosDAO.insertEvento("JSD_ACTUALIZA_GRUPO_RESOLUTOR", "GRUPO_RESOLUTOR",request.getIdJsdComunicacion() );
                return new JsdProcesarDataResponse(true);
            }

            jsonData = JsonDataRetriever.getData(data, "$.comment.author.key", String.class);
            boolean hasAuthorComment = null != jsonData;
            if (hasAuthorComment && tipoEvento != null)
            {
                eventosDAO.insertEvento("JSD_INSERTA_COMENTARIO", "COMENTARIO_JSD", request.getIdJsdComunicacion());
                return new JsdProcesarDataResponse(true);
            }

            jsonData = JsonDataRetriever.getData(data, "$.issue.fields.status.name", String.class);
            boolean hasStatusName = null != jsonData;
            if (EVENTO_RECLAMO_PADRE.equals(tipoEvento) && hasStatusName)
            {
                eventosDAO.insertEvento("JSD_ACTUALIZA_ESTADO", "ESTADO_JSD_RECLAMO", request.getIdJsdComunicacion());
                return new JsdProcesarDataResponse(true);
            }else if(hasStatusName && tipoEvento != null)
            {
                eventosDAO.insertEvento("JSD_ACTUALIZA_ESTADO", "ESTADO_JSD_ACTIVIDAD", request.getIdJsdComunicacion());
                return new JsdProcesarDataResponse(true);
            }

            LOGGER.error("Request no es valido para los flujos soportados. idJsdComunicacion ->" + request.getIdJsdComunicacion());
            return new JsdProcesarDataResponse(true);
        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);
            envioCorreoError(new EventosDTO(request.getIdJsdComunicacion(), "JSD_PROCESAR_DATA", "JSD_INTEGRACION_WS"), e.getMessage(), e);
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }


    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_PROCESAR_DATA, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }
}
