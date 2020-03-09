package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.RecibirInformacionJsdHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.ListaValoresDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ListaValorItemDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.*;
import com.grupogtd.integration.sicret.jsd.ws.request.RecibirInformacionRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.RecibirInformacionResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

@Component
public class RecibirInformacionJsdHandlerImpl implements RecibirInformacionJsdHandler
{
    private static final Log LOGGER = LogFactory.getLog(RecibirInformacionJsdHandlerImpl.class);

    public static final int MAX_RETRY_NUMBER_DEFAULT = 2;

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("listaValoresDAOImpl")
    private ListaValoresDAO listaValoresDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Override
    public RecibirInformacionResponse handle(RecibirInformacionRequest request) throws InteSicretJsdWSBusinessException
    {
        try
        {
            RecibirInformacionResponse recibirInformacionResponse = new RecibirInformacionResponse();
            boolean isProcesado =  procesarJson(request);
            if(!isProcesado)
            {
                recibirInformacionResponse.setSuccessful(false);
                return recibirInformacionResponse;
            }
            recibirInformacionResponse.setSuccessful(true);
            return recibirInformacionResponse;


        }
        catch (InteSicretJsdWSBusinessException e)
        {
            envioCorreoError(new EventosDTO(getIssueKey(request),"RECIBIR_INFORMACION_JSD", "JSD_INTEGRACION_WS"), e.getMessage(), e);
            throw e;
        }
        catch (Exception e)
        {
            envioCorreoError(new EventosDTO(getIssueKey(request),"RECIBIR_INFORMACION_JSD", "JSD_INTEGRACION_WS"), e.getMessage(), e);
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, e);
        }
    }

    private boolean procesarJson(RecibirInformacionRequest request)
            throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("RecibirInformacionJsdHandlerImpl");

        String issueKey = getIssueKey(request);
        boolean isIssueKey =  jsdSeguimientoDAO.existeIssueKey(issueKey);
        LOGGER.info("RecibirInformacionRequest-Issue Key-->" +issueKey );
        if(!isIssueKey)
        {
            LOGGER.warn("---INFORMACION - NO SE ENCONTRO EL ISSUE_KEY EN LA TABLA JSD_SEGUIMIENTO - ISSUE KEY-->"+issueKey);
          return false;
        }
        int maxRetryNumber = getMaxRetryNumber();

        int intent = 1;
        boolean wasSuccessful = false;
        while (intent <= maxRetryNumber && !wasSuccessful)
        {
            if (intent > 1)
            {
                sleep(3000);
            }
            try
            {
                wasSuccessful = wsComunicacionDAO.insertarJsdComunicacion(issueKey, request.getJson());
            }
            catch (DAOException e)
            {
                LOGGER.error(e);
                wasSuccessful = false;
            }
            intent++;
        }

        if (!wasSuccessful)
        {
            throw new WasNotPossibleSaveRequestPayloadException() ;
        }
        return true;
    }

    private String getIssueKey(RecibirInformacionRequest request)
            throws IssueKeyNotFoundInRequestPayloadException
    {
        String issueKey = JsonDataRetriever.getData(request.getJson(), "$.issue.key", String.class);
        if (issueKey == null || issueKey.isEmpty())
        {
            throw new IssueKeyNotFoundInRequestPayloadException();
        }
        return issueKey;
    }

    private int getMaxRetryNumber()
    {
        int maxRetryNumber = MAX_RETRY_NUMBER_DEFAULT;
        ListaValorItemDTO item = new ListaValorItemDTO(TIPO_LISTA, SUBTIPO_LISTA_REPROCESO, VALOR_VISIBLE_REPROCESO, null, ESTADO_LISTA_ACTIVO);
        try
        {
            maxRetryNumber = Integer.parseInt(listaValoresDAO.obtenerValor(item));
        }
        catch (NumberFormatException e)
        {
            LOGGER.error("getMaxRetryNumber - Se procede con Configuracion por defecto - Parametro reintento configurado en lista de valores no es un numero valido, corrija configuracion para ->" + item.toString(), e);
        }
        catch (DAOException e)
        {
            LOGGER.error("getMaxRetryNumber - Se procede con Configuracion por defecto - Error al obtener de lista de valores la cantidad de reintentos para configuracion ->" + item.toString(), e);
        }

        return maxRetryNumber;
    }

    private void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e)
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, VALOR_VISIBLE_CORREO_ASUNTO_RECIBIR_INFORMACION, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));
        }
        catch (Exception ex)
        {
            LOGGER.error("Ocurrio un error al intentar enviar notificacion a lista de soporte para error en procesamiento de servicio recibirInformacionJsd", ex);
        }
    }

}
