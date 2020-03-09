package com.grupogtd.integration.sicret.jsd.ws.impl;

import com.grupogtd.alfresco.client.archivo.AlfrescoFile;
import com.grupogtd.alfresco.client.archivo.AlfrescoFileByte;
import com.grupogtd.alfresco.client.dto.AlfrescoRespuestaDTO;
import com.grupogtd.alfresco.client.dto.AlfrescoSubirArchivoDTO;
import com.grupogtd.alfresco.client.fachada.AlfrescoFachada;
import com.grupogtd.integration.sicret.jsd.ws.AlfrescoUploader;
import com.grupogtd.integration.sicret.jsd.ws.dto.DocumentoAdjuntoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AlfrescoUploaderImpl implements AlfrescoUploader
{
    private static final Log LOGGER = LogFactory.getLog(AlfrescoUploaderImpl.class);

    @Override
    public AlfrescoRespuestaDTO upload(DocumentoAdjuntoDTO documentoAdjuntoDTO)
    {
        AlfrescoRespuestaDTO alfrescoRespuestaDTO = new AlfrescoRespuestaDTO(false);
        try
        {
            AlfrescoSubirArchivoDTO alfrescoSubirArchivoDTO = new AlfrescoSubirArchivoDTO();
            alfrescoSubirArchivoDTO.setUsuario(documentoAdjuntoDTO.getUsuario());
            alfrescoSubirArchivoDTO.setOrigen(documentoAdjuntoDTO.getOrigen());
            alfrescoSubirArchivoDTO.setTipoObjetoArchivoAdjunto(documentoAdjuntoDTO.getTipoObjeto());
            alfrescoSubirArchivoDTO.setIdObjetoArchivoAdjunto(documentoAdjuntoDTO.getIdExterno());

            AlfrescoFile alfrescoFile = new AlfrescoFileByte(documentoAdjuntoDTO.getArchivo(), documentoAdjuntoDTO.getNombreArchivo());
            alfrescoSubirArchivoDTO.setAlfrescoFile(alfrescoFile);

            AlfrescoFachada alfrescoFachada = new AlfrescoFachada();
            alfrescoRespuestaDTO = alfrescoFachada.subirArchivoSync(alfrescoSubirArchivoDTO);
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        return alfrescoRespuestaDTO;
    }
}
