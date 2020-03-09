package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsonDataRetriever;
import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.EventosDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.GrupoResolutorNotFoundException;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import com.grupogtd.integration.sicret.jsd.ws.exception.IssueKeyNotFoundException;
import com.grupogtd.integration.sicret.jsd.ws.request.UpdateResolutionAreaRequest;
import com.grupogtd.integration.sicret.jsd.ws.response.UpdateResolutionAreaResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.VALOR_VISIBLE_CORREO_ASUNTO_GRUPO_RESOLUTOR;

@Component("updateResolutionAreaHandler")
public class UpdateResolutionAreaHandlerImpl extends CommonTemplateHandlerImpl<UpdateResolutionAreaRequest, UpdateResolutionAreaResponse>
{
    private static final Log LOGGER = LogFactory.getLog(UpdateResolutionAreaHandlerImpl.class);

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Override
    public UpdateResolutionAreaResponse handleRequest(UpdateResolutionAreaRequest request)
            throws InteSicretJsdWSBusinessException,GrupoResolutorNotFoundException
    {
        LOGGER.info("INFO!!! Paso por UpdateResolutionAreaHandler - handle()");
        String data = wsComunicacionDAO.getJsdRequestPayloadAsJson(request.getIdComunicacion());
        String grupoResolutorJsd = JsonDataRetriever.getData(data, "$.issue.fields.customfield_10717", String.class);

        String issueKey = wsComunicacionDAO.obtenerIssueKey(request.getIdComunicacion());
        String grupoResolutorSicret = jsdSeguimientoDAO.obtenerAreaResolutora(issueKey);

        if(issueKey == null)
        {
            throw new IssueKeyNotFoundException();
        }
        if(!grupoResolutorJsd.equalsIgnoreCase(grupoResolutorSicret))
        {
            LOGGER.info("INFO--> Se actualiza grupo resolutor");
            jsdSeguimientoDAO.actualizarAreaResolutora(issueKey,grupoResolutorJsd);
        }
        return new UpdateResolutionAreaResponse(true);
    }

    @Override
    protected EventosDTO getEventoDTO(UpdateResolutionAreaRequest request)
    {
        return new EventosDTO(request.getIdComunicacion(), "JSD_ACTUALIZA_GRUPO_RESOLUTOR", "JSD_INTEGRACION_WS");
    }

    @Override
    protected String getErrorMessage()
    {
        return ErrorMessage.MESSAGE_ERROR_ACTUALIZAR_AREA_RESOLUTORA;
    }

    @Override
    protected String getAsunto()
    {
        return VALOR_VISIBLE_CORREO_ASUNTO_GRUPO_RESOLUTOR;
    }

}
