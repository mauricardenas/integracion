package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import com.grupogtd.integration.sicret.jsd.ws.exception.InteSicretJsdWSBusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("jsdSeguimientoDAOImpl")
public class JsdSeguimientoDAOImpl extends BaseDAO implements JsdSeguimientoDAO

{
    private static final Log LOGGER = LogFactory.getLog(JsdSeguimientoDAOImpl.class);

    private static final String PATH_OBTENER_TIPO_EVENTO = "com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO.obtenerTipoEvento";
    private static final String PATH_OBTENER_ID_EXTERNO = "com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO.obtenerIdExterno";
    private static final String PATH_EXISTE_ISSUE_KEY = "com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO.existeIssueKey";
    private static final String PATH_OBTENER_AREA_RESOLUTORA = "com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO.obtenerAreaResolutora";
    private static final String PATH_ACTUALIZAR_AREA_RESOLUTORA = "com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO.actualizaAreaResolutora";

    @Override
    public String obtenerTipoEvento(String issueKey) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - obtenerTipoEvento");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_OBTENER_TIPO_EVENTO, params);
            return (String) params.get("OUT_TIPO_EVENTO");


        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_TIPO_EVENTO, e);
        }
    }

    @Override
    public String obtenerIdExterno(String issueKey) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - obtenerIdExterno -> issueKey" +issueKey);
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_OBTENER_ID_EXTERNO, params);
            String outIdExterno = (String) params.get("OUT_ID_EXTERNO");
            LOGGER.info("Saliendo WsComunicacionDAOImpl -> obtenerIdExterno :"+outIdExterno);
            return outIdExterno;

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_ID_EXTERNO, e);
        }
    }

    @Override
    public boolean existeIssueKey(String issueKey) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso ReclamoDAOImpl - isReclamoPadre");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            getSqlSession().selectOne(PATH_EXISTE_ISSUE_KEY, params);
            return 1 == (Integer) params.get("OUT_ISSUE_KEY");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_ISSUE_KEY , e);
        }
    }

    @Override
    public String obtenerAreaResolutora(String issueKey) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso ReclamoDAOImpl - obtenerAreaResolutora");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            getSqlSession().selectOne(PATH_OBTENER_AREA_RESOLUTORA, params);
            return (String) params.get("OUT_AREA_RESOLUTORA");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_AREA_RESOLUTORA , e);
        }
    }

    @Override
    public boolean actualizarAreaResolutora(String issueKey, String areaResolutora) throws InteSicretJsdWSBusinessException
    {
        LOGGER.info("Ingreso ReclamoDAOImpl - obtenerAreaResolutora");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            params.put("p_area_resolutora", areaResolutora);
            getSqlSession().selectOne(PATH_ACTUALIZAR_AREA_RESOLUTORA, params);
            return 1 == (Integer) params.get("OUT_REG_ACT");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_AREA_RESOLUTORA , e);
        }

    }

}
