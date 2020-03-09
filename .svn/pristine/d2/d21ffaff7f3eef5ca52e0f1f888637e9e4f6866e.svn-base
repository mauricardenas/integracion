package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.alfresco.client.dto.AlfrescoRespuestaDTO;
import com.grupogtd.component.rest.exception.RestClientException;
import com.grupogtd.integration.sicret.jsd.ws.AlfrescoUploader;
import com.grupogtd.integration.sicret.jsd.ws.FindExtensionMessage;
import com.grupogtd.integration.sicret.jsd.ws.JsdFileDownloader;
import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotiferInput;
import com.grupogtd.integration.sicret.jsd.ws.business.ErrorMailNotifier;
import com.grupogtd.integration.sicret.jsd.ws.business.InsertAttachmentFilesSicretHandler;
import com.grupogtd.integration.sicret.jsd.ws.constant.Constants;
import com.grupogtd.integration.sicret.jsd.ws.constant.PropertyKey;
import com.grupogtd.integration.sicret.jsd.ws.dao.ArchivoAdjuntoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.AttachmentFileDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.DocumentoAdjuntoDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.*;
import com.grupogtd.integration.sicret.jsd.ws.impl.AlfrescoUploaderImpl;
import com.grupogtd.integration.sicret.jsd.ws.impl.JsdFileDownloaderImpl;
import com.grupogtd.integration.sicret.jsd.ws.request.InsertAttachmentFilesSicretRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.InsertAttachmentFilesSicretResponse;
import com.grupogtd.properties.ws.request.GetPropertyRequest;
import com.grupogtd.properties.ws.response.GetPropertyResponse;
import com.grupogtd.property.ws.PropertyWsApiClient;
import com.grupogtd.property.ws.impl.PropertyWsApiClientImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;

@Component
public class InsertAttachmentFilesSicretHandlerImpl implements InsertAttachmentFilesSicretHandler
{
    private static final Log LOGGER = LogFactory.getLog(JsdProcesarDataHandlerImpl.class);

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("archivoAdjuntoDAOImpl")
    private ArchivoAdjuntoDAO archivoAdjuntoDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Autowired
    @Qualifier("errorMailNotifier")
    private ErrorMailNotifier errorMailNotifier;

    @Override
    public InsertAttachmentFilesSicretResponse handle(InsertAttachmentFilesSicretRequest request) throws InteSicretJsdWSBusinessException
    {
        String jsonPayload = wsComunicacionDAO.getJsdRequestPayloadAsJson(request.getIdComunicacion());
        String comment = JsonDataRetriever.getData(jsonPayload, "$.comment.body", String.class);

        List<String> attachedFiles = FindExtensionMessage.extractFileNames(comment);

        if (attachedFiles.isEmpty())
        {
            return new InsertAttachmentFilesSicretResponse(false);
        }

        String schema = getPropertyValue(PropertyKey.JSD_ENDPOINT_SCHEMA.getKey());
        String host = getPropertyValue(PropertyKey.JSD_ENDPOINT_HOST.getKey());
        int port = Integer.valueOf(getPropertyValue(PropertyKey.JSD_ENDPOINT_PORT.getKey()));
        String user = getPropertyValue(PropertyKey.JSD_ENDPOINT_USER.getKey());
        String pass = getPropertyValue(PropertyKey.JSD_ENDPOINT_PASS.getKey());

        int okCounter = 0;
        for (String attachedFile : attachedFiles)
        {
            try
            {
                String issueKey = JsonDataRetriever.getData(jsonPayload, "$.issue.key", String.class);
                String idExterno = jsdSeguimientoDAO.obtenerIdExterno(issueKey);
                String tipoEvento = jsdSeguimientoDAO.obtenerTipoEvento(issueKey);
                boolean existsAttachedFileInDB = archivoAdjuntoDAO.hayArchivoAdjunto(idExterno, attachedFile);

                if (existsAttachedFileInDB)
                {
                    LOGGER.warn("File attachment currently exists in sicret.archivo_adjunto for filename : " + attachedFile + ", idExterno: " + idExterno);
                    okCounter++;
                    continue;
                }

                AttachmentFileDTO attachmentFileDTO = getAttachmentFileURL(jsonPayload, attachedFile);

                if (attachmentFileDTO.getUrlAttachmentFile() == null)
                {
                    LOGGER.warn("File attachment URL not found -> filename : " + attachedFile);
                    continue;
                }
                LOGGER.info(attachmentFileDTO.getUrlAttachmentFile());

                attachmentFileDTO.setUrlAttachmentFile(migrateUrlToEsb(attachmentFileDTO.getUrlAttachmentFile(), schema, host, port));
                LOGGER.info(attachmentFileDTO.getUrlAttachmentFile());

                JsdFileDownloader downloader = new JsdFileDownloaderImpl(host, port, schema, user, pass);
                byte[] fileAsBytes;
                try
                {
                    fileAsBytes = downloader.download(attachmentFileDTO.getUrlAttachmentFile());
                }
                catch (JsdFileDownloadException e)
                {
                    e.printStackTrace();
                    envioCorreoError(new EventosDTO(request.getIdComunicacion(), "JSD_ADJUNTA_ARCHIVO", "JSD_INTEGRACION_WS"), e.getMessage(), new FailedFileUploadException());
                    LOGGER.warn("File attachment URL not found -> filename : " + attachedFile);
                    continue;
                }


                DocumentoAdjuntoDTO documentoAdjuntoDTO = new DocumentoAdjuntoDTO();
                documentoAdjuntoDTO.setArchivo(fileAsBytes);
                documentoAdjuntoDTO.setIdExterno(Long.valueOf(idExterno));
                documentoAdjuntoDTO.setNombreArchivo(attachmentFileDTO.getIdAttachmentFile()+"-"+attachedFile.trim());
                documentoAdjuntoDTO.setUsuario(ALFRESCO_USUARIO_SISTEMA);

                if(EVENTO_RECLAMO_PADRE.equals(tipoEvento))
                {
                    documentoAdjuntoDTO.setTipoObjeto(ALFRESCO_TIPO_OBJ_RECLAMO);
                }else
                {
                    documentoAdjuntoDTO.setTipoObjeto(ALFRESCO_TIPO_OBJ_ACTIVIDAD);
                }

                AlfrescoUploader uploader = new AlfrescoUploaderImpl();
                AlfrescoRespuestaDTO alfrescoRespuestaDTO = uploader.upload(documentoAdjuntoDTO);
                if (!alfrescoRespuestaDTO.isOk())
                {
                    LOGGER.warn("File upload to alfresco was fail: filename -> " + attachedFile);
                    continue;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                envioCorreoError(new EventosDTO(request.getIdComunicacion(), "JSD_ADJUNTA_ARCHIVO", "JSD_INTEGRACION_WS"),  e.getMessage(), new FailedFileUploadException());
                LOGGER.warn("File attachment process was wrong for filename -> " + attachedFile);
                continue;
            }

            okCounter++;

        }

        LOGGER.info("[[[[attachments.size = " + attachedFiles.size() + " | okCounter  = " + okCounter + "]]]]");
        boolean isAllFilesProcessed = okCounter == attachedFiles.size();

        LOGGER.info("isAllFilesProcessed = " + isAllFilesProcessed);
        if(!isAllFilesProcessed)
        {
            envioCorreoError(new EventosDTO(request.getIdComunicacion(), "JSD_ADJUNTA_ARCHIVO", "JSD_INTEGRACION_WS"), new FailedFileUploadException().getMessage(), new FailedFileUploadException());
            throw new FailedFileUploadException();
        }
        return new InsertAttachmentFilesSicretResponse(isAllFilesProcessed);
    }

    private static AttachmentFileDTO getAttachmentFileURL(String jsonPayload, String attachedFile)
    {
        String attachmentFileURL;
        AttachmentFileDTO attachmentFileDTO = new AttachmentFileDTO();
        String attachmentFilename;
        int i=0;
            do
            {
                 attachmentFilename = JsonDataRetriever.getData(jsonPayload, "$.issue.fields.attachment[" + i + "].filename", String.class);
                if (attachmentFilename == null)
                {
                    break;
                }
                if (attachedFile.trim().equalsIgnoreCase(attachmentFilename))
                {
                    attachmentFileURL = JsonDataRetriever.getData(jsonPayload, "$.issue.fields.attachment[" + i + "].content", String.class);
                    String id = JsonDataRetriever.getData(jsonPayload, "$.issue.fields.attachment[" + i + "].id", String.class);
                    attachmentFileDTO.setUrlAttachmentFile(attachmentFileURL);
                    attachmentFileDTO.setIdAttachmentFile(id);
                }
                i++;
            } while (!attachedFile.trim().equalsIgnoreCase(attachmentFilename));

        return attachmentFileDTO;
    }

    protected static String migrateUrlToEsb(String attachmentFileURL, String schema, String host, int port)
    {

        int indexStart = attachmentFileURL.indexOf("/secure");
        String relativeURL = attachmentFileURL.substring(indexStart);
        LOGGER.info("relativeURL -> " + relativeURL);

        String migratedURL = schema + "://" + host + ":" + port + "/jira" + relativeURL;
        LOGGER.info("migratedURL -> " + migratedURL);
        return migratedURL;

    }

    private static String getPropertyValue(String propertyKey) throws CanNotGetPropertyConfigurationException
    {
        try
        {
            PropertyWsApiClient client = new PropertyWsApiClientImpl();
            GetPropertyResponse response = client.call(new GetPropertyRequest(propertyKey));
            return response.getValue();
        }
        catch (RestClientException e)
        {
            throw new CanNotGetPropertyConfigurationException(propertyKey, e);
        }
    }

    private void envioCorreoError(EventosDTO eventos, String mensajeError, Exception e) throws InteSicretJsdWSBusinessException
    {
        try
        {
            errorMailNotifier.notify(new ErrorMailNotiferInput(e, eventos, mensajeError, Constants.VALOR_VISIBLE_CORREO_ASUNTO_INSERTAR_ARCHIVO, Constants.NOMBRE_PROCESO_INTE_JSD_SICRET_WS));

        }
        catch (Exception ex)
        {
            throw new InteSicretJsdWSBusinessException(ErrorMessage.UNKNOWN, ex);
        }
    }


}
