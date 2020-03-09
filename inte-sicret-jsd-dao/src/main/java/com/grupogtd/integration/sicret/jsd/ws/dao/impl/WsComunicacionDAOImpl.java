package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component("wsComunicacionDAOImpl")
public class WsComunicacionDAOImpl extends BaseDAO implements WsComunicacionDAO
{
    private static final Log LOGGER = LogFactory.getLog(WsComunicacionDAOImpl.class);

    private static final String PATH_INSERT_JSD_COMUNICACION = "com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO.insertarJsdComunicacion";
    private static final String PATH_OBTENER_ISSUE_KEY = "com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO.obtenerIssueKey";
    private static final String PATH_INSERT_OBTENER_DATA = "com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO.getJsdRequestPayloadAsJson";

    private static final String PATH_UPDATE_ACTIVIDAD = "com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO.updateActividad";

    @Override
    public boolean insertarJsdComunicacion(@Param("p_issue_key") String issueKey, @Param("p_data") String data) throws DAOException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - insertarJsdComunicacion");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_issue_key", issueKey);
            LOGGER.info(params);
            params.put("p_data", data);
            getSqlSession().selectOne(PATH_INSERT_JSD_COMUNICACION, params);
            return 0 < (Integer) params.get("OUT_IS_INSERTED");
        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_INSERTAR_JSD_COMUNICACION, e);
        }
    }

    @Override
    public String obtenerIssueKey(String idJsdComunicacion) throws DAOException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - obtenerIssueKey");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_comunicacion", idJsdComunicacion);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_OBTENER_ISSUE_KEY, params);
            return (String) params.get("out_issue_key");


        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_ISSUE_KEY, e);
        }
    }

    @Override
    public String getJsdRequestPayloadAsJson(String idComunicacion) throws DAOException
    {
        LOGGER.info("Ingreso BitacoraDAOImpl - getJsdRequestPayloadAsJson");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_comunicacion", idComunicacion);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_INSERT_OBTENER_DATA, params);
            Clob clob = (Clob) params.get("v_data");
            return clobToString(clob);
        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_DATA, e);
        }
    }

    private String clobToString(Clob data)
    {
        if (data == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try
        {
            Reader reader = data.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);

            String line;
            while (null != (line = br.readLine()))
            {
                sb.append(line);
            }
            br.close();
        }
        catch (SQLException e)
        {
            // handle this exception
        }
        catch (IOException e)
        {
            // handle this exception
        }
        return sb.toString();
    }

    @Override
    public void updateActividad(String idActividad, String estado, String subEstado) throws DAOException
    {
        LOGGER.info("Ingreso WsComunicacionDAOImpl - updateActividad");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_actividad", idActividad);
            params.put("p_estado", estado);
            params.put("p_subestado", subEstado);
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_UPDATE_ACTIVIDAD, params);
            LOGGER.info("Saliendo WsComunicacionDAOImpl - updateActividad");

        }
        catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_ACTUALIZAR_ACTIVIDAD, e);
        }
    }

}
