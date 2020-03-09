package com.grupogtd.integration.sicret.jsd.ws.business.impl;


import com.grupogtd.component.mail.core.impl.ConfigurableMailNotifierTemplate;
import com.grupogtd.component.mail.dto.MailNotificationInfoDTO;
import com.grupogtd.component.mail.exception.MailNotifierException;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CorreoDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorNotificationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

/**
 * Created by softtek on 26/03/2019.
 */
@Component("errorMailNotifier")
public class ErrorMailNotifierImpl implements ErrorMailNotifier
{
    private static final Log LOGGER = LogFactory.getLog(ErrorMailNotifierImpl.class);
    private static final long ID_PLANTILLA_CORREO_ERROR = 20L;

    @Autowired
    @Qualifier("InteSicretJsdWSImpl")
    private InteSicretJsdWSDAO inteSicretJsdWSDAO;

    @Override
    public void notify(ErrorMailNotiferInput errorMailNotiferInput)
            throws ErrorNotificationException
    {
        try
        {
            Long idCorreo = ID_PLANTILLA_CORREO_ERROR;
            String asuntoCorreo = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, errorMailNotiferInput.getAsunto(), ESTADO_LISTA_ACTIVO);
            String[] emailArr = getEmails();

            LOGGER.info("idCorreo: -> " + idCorreo);
            LOGGER.info("asunto: -> " + asuntoCorreo);
            LOGGER.info("emailTo -> " + Arrays.toString(emailArr));
            LOGGER.info("error -> " + errorMailNotiferInput.getMensajeError());

            MailNotificationInfoDTO mailDTO = new MailNotificationInfoDTO();
            mailDTO.setSubject(asuntoCorreo);
            mailDTO.setTo(emailArr);
            mailDTO.setOutputFilename(Constants.FORMATO_ARCHIVO_HTML);
            mailDTO.setIdCorreo(idCorreo);

            Map<String, Object> dataMap = new HashMap<String, Object>();

            if (null != errorMailNotiferInput.getEventosDTO().getTipoEvento())
            {
                dataMap.put("${proceso}", errorMailNotiferInput.getEventosDTO().getTipoEvento());
            }
            else
            {
                dataMap.put("${proceso}", errorMailNotiferInput.getNombreProceso());
            }

            dataMap.put("${tipoAfectado}", errorMailNotiferInput.getEventosDTO().getTipo());

            if (null != errorMailNotiferInput.getEventosDTO().getTipoEvento())
            {
                dataMap.put("${identificador}", errorMailNotiferInput.getEventosDTO().getIdExterno() + "-" + errorMailNotiferInput.getEventosDTO().getTipoEvento());
            }
            else
            {
                dataMap.put("${identificador}", errorMailNotiferInput.getEventosDTO().getIdExterno());
            }

            dataMap.put("${error}", errorMailNotiferInput.getMensajeError());
            dataMap.put("${detalleError}", Arrays.toString(errorMailNotiferInput.getE().getStackTrace()));

            LOGGER.info("Datamap"+dataMap);

            com.grupogtd.component.mail.core.MailNotifier notifier = new MyConfigurableMailNotifierTemplate();

            LOGGER.debug("notify() >> Entering");
            notifier.notify(mailDTO, dataMap);
            LOGGER.debug("notify() : Finishing as OK");
        }
        catch (Exception ex)
        {
            throw new ErrorNotificationException(ex);
        }

    }

    private static class MyConfigurableMailNotifierTemplate extends ConfigurableMailNotifierTemplate
    {
        @Override
        protected Map<String, Object> fillDataMap(Map<String, Object> dataMap)
        {
            return dataMap;
        }
    }

    private String[] getEmails() throws MailNotifierException
    {
        LOGGER.info("Entrando a getEmails");
        try
        {
            List<CorreoDTO> correoDTOs = inteSicretJsdWSDAO.getDestinatarios
                    (Constants.TIPO_LISTA, Constants.SUBTIPO_LISTA_CORREO_DESTINO, Constants.ESTADO_LISTA_ACTIVO);
            List<String> emails = new ArrayList<String>(correoDTOs.size());
            for (CorreoDTO correoDTO : correoDTOs)
            {
                emails.add(correoDTO.getCorreo());
            }
            String[] emailsAsArr = emails.toArray(new String[]{});
            LOGGER.debug("getEmails : returning >> " + Arrays.toString(emailsAsArr));
            return emailsAsArr;
        }
        catch (Exception e)
        {
            throw new MailNotifierException("Error al obtener destinatarios para correo de error", e);
        }

    }
}
