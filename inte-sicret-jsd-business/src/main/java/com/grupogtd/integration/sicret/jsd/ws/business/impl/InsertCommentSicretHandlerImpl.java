package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.InsertCommentSicretHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.BitacoraDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.EventosDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.InsertCommentSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.InsertCommentSicretResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import com.grupogtd.integration.sicret.jsd.ws.FindExtensionMessage;

@Component
public class InsertCommentSicretHandlerImpl implements InsertCommentSicretHandler
{
    private static final Log LOGGER = LogFactory.getLog(JsdProcesarDataHandlerImpl.class);

    @Autowired
    @Qualifier("BitacoraDAO")
    private BitacoraDAO bitacoraDAO;

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("eventosDAOImpl")
    private EventosDAO eventosDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;


    @Override
    public InsertCommentSicretResponse handle(InsertCommentSicretRequest request) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Paso por InsertCommentSicretHandlerImpl - handle()");
        try
        {
            String data = wsComunicacionDAO.getJsdRequestPayloadAsJson(request.getIdComunicacion());
            String autor = JsonDataRetriever.getData(data, "$.comment.author.key", String.class);

            boolean isSameAuthor = Constants.SICRET.equalsIgnoreCase(autor);
            LOGGER.info("isSameAuthor="+isSameAuthor +"autor="+autor);
            if(isSameAuthor)
           {
               return new InsertCommentSicretResponse(true);
           }

            String comentario = JsonDataRetriever.getData(data, "$.comment.body", String.class);
            List<String> fileNames = FindExtensionMessage.extractFileNames(comentario);
            if(!fileNames.isEmpty())
           {
               eventosDAO.insertEvento("JSD_ADJUNTA_ARCHIVO",  "ARCHIVO_JSD",request.getIdComunicacion());
               LOGGER.info("INFO!!! Se inserta evento de : JSD_ADJUNTA_ARCHIVO ");
           }

           String issueKey = JsonDataRetriever.getData(data, "$.issue.key", String.class);
           String idExterno = jsdSeguimientoDAO.obtenerIdExterno(issueKey);
           bitacoraDAO.insertBitacora(comentario,idExterno);


           return new InsertCommentSicretResponse(true);
        }
        catch (Exception e)
        {

            LOGGER.error(ErrorCode.UNKNOWN, e);

            EventosDTO eventosDTO = new EventosDTO();
            eventosDTO.setTipo("JSD_INSERTA_COMENTARIO");
            eventosDTO.setTipoEvento("JSD_INTEGRACION_WS");
            eventosDTO.setIdExterno(request.getIdComunicacion());
            envioCorreoError(eventosDTO, e.getMessage(), e);

            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }




    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_INSERTA_COMENTARIO, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }

}
