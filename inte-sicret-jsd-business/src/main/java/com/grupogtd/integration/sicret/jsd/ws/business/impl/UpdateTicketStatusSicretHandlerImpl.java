package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.UpdateTicketStatusSicretHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.*;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ListaValorItemDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorCode;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.request.UpdateTicketStatusSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.UpdateTicketStatusSicretResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

@Component
public class UpdateTicketStatusSicretHandlerImpl implements UpdateTicketStatusSicretHandler
{
    private static final Log LOGGER = LogFactory.getLog(UpdateTicketStatusSicretHandlerImpl.class);

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("solucionFamiliaDAOImpl")
    private SolucionFamiliaDAO solucionFamiliaDAO;

    @Autowired
    @Qualifier("solucionReclamoDAOImpl")
    private SolucionReclamoDAO solucionReclamoDAO;

    @Autowired
    @Qualifier("listaValoresDAOImpl")
    private ListaValoresDAO listaValoresDAO;


    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Override
    public UpdateTicketStatusSicretResponse handle(UpdateTicketStatusSicretRequest request) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Paso por UpdateTicketStatusSicretHandler - handle()");
        try
        {
            LOGGER.info("UpdateTicketStatusSicretRequest-->" + request);

            String data = wsComunicacionDAO.getJsdRequestPayloadAsJson(request.getIdComunicacion());
            String estadoTicket = JsonDataRetriever.getData(data, "$.issue.fields.status.name", String.class);
            String issueKey = wsComunicacionDAO.obtenerIssueKey(request.getIdComunicacion());
            String idExterno = jsdSeguimientoDAO.obtenerIdExterno(issueKey);

            ListaValorItemDTO itemEstadoTkPadre = new ListaValorItemDTO(TIPO_LISTA, SUBTIPO_LISTA_SEGUIMIENTO, VALOR_VISIBLE_RECLAMO_PADRE, null, ESTADO_LISTA_ACTIVO);
            String estadoTicketReclamoPadre = listaValoresDAO.obtenerValor(itemEstadoTkPadre);

            ListaValorItemDTO itemEstadoTkAct = new ListaValorItemDTO(TIPO_LISTA, SUBTIPO_LISTA_SEGUIMIENTO, VALOR_VISIBLE_ACTIVIDAD, null, ESTADO_LISTA_ACTIVO);
            String estadoTicketActividad = listaValoresDAO.obtenerValor(itemEstadoTkAct);


            if(TIPO_EVENTO_ACTIVIDAD.equalsIgnoreCase(request.getTipoEvento()) & estadoTicketActividad.equalsIgnoreCase(estadoTicket) )
            {
                LOGGER.info("INFO!!! Ingreso a actualizar estado ticket  - ACTIVIDAD");
                wsComunicacionDAO.updateActividad(idExterno, ESTADO_ACTIVIDAD, SUBESTADO_ACTIVIDAD);
                return new UpdateTicketStatusSicretResponse(true);
            }
            else if(TIPO_EVENTO_RECLAMO_PADRE.equalsIgnoreCase(request.getTipoEvento()) & estadoTicketReclamoPadre.equalsIgnoreCase(estadoTicket))
            {
                LOGGER.info("INFO!!! Ingreso a actualizar estado ticket  - RECLAMO PADRE");
                flujoReclamo(idExterno, data);
                return new UpdateTicketStatusSicretResponse(true);
            }else
            {
                LOGGER.info("INFO!!! No se actualizan reclamo/actividad por estado del tiket --> "+estadoTicket);
            }

            return new UpdateTicketStatusSicretResponse(true);
        }
        catch (Exception e)
        {
            LOGGER.error(ErrorCode.UNKNOWN, e);

            EventosDTO eventosDTO = new EventosDTO();
            eventosDTO.setIdExterno(request.getIdComunicacion());
            eventosDTO.setTipo("JSD_ACTUALIZAR_ESTADO");
            eventosDTO.setTipoEvento("JSD_INTEGRACION_WS");

            envioCorreoError(eventosDTO, e.getMessage(), e);

            throw new InteSicretJsdWSBusinessException(ErrorMessage.MESSAGE_ERROR_ACTUALIZAR_TICKET, e);
        }


    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws
            InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, VALOR_VISIBLE_CORREO_ASUNTO_ACTUALIZA_ESTADO, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));

        } catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }

    private void flujoReclamo(String idReclamo, String data) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("INFO!!! Ingreso a actualizar estado ticket  - flujoReclamo()");
        try
        {
            int maxMensajes = JsonDataRetriever.getData(data, "$.issue.fields.comment.total", Integer.class);
            String mensaje = JsonDataRetriever.getData(data, "$.issue.fields.comment.comments[" + (maxMensajes - 1) + "].body", String.class);
            String idSolucion = solucionFamiliaDAO.obtenerIdSolucion(CODIGO_SOLUCION);

            solucionReclamoDAO.insertSolucionReclamo(idSolucion, idReclamo, mensaje);
            solucionReclamoDAO.updateReclamo(idSolucion, idReclamo, mensaje);

        }catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }


    }


}
