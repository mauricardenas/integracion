package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.AddCommentDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ConfiguracionTicketDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CorreoDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.RespuestaBusDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;
import com.grupogtd.integration.sicret.jsd.ws.exception.ErrorMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ramiro.urbina on 24-11-2017.
 */
@SuppressWarnings("unchecked")
@Component("InteSicretJsdWSImpl")
public class InteSicretJsdWSDAOImpl extends BaseDAO implements InteSicretJsdWSDAO
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImpl.class);

    private static final String PATH_CONFIGURACION_TICKET = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getConfiguracionJSD";
    private static final String PATH_PROPERTIES = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getPropertyValue";
    private static final String PATH_RESUMEN = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getResumen";
    private static final String PATH_DESCRIPCION = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getDescripcion";
    private static final String PATH_OBTENER_CONFIGURACION = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getConfiguracion";
    private static final String PATH_ESTADO_APLICACION = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getEstadoValidacion";
    private static final String PATH_INSERTAR_SEGUIMIENTO = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.insertarJsdSeguimiento";
    private static final String PATH_USUARIO_CREACION = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getUsuarioCreacion";
    private static final String PATH_OBTENER_ISSUE_KEY = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getIssueKey";
    private static final String PATH_OBTENER_DESTINATARIOS = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getDestinatarios";
    private static final String PATH_COMENTARIO_ACTIVIDAD = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getComentarioActividad";
    private static final String PATH_COMENTARIO_RECLAMO = "com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO.getComentarioReclamo";

    @SuppressWarnings("unchecked")
    @Override
    public List<ConfiguracionTicketDTO> getConfiguracionTicket(String evento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getConfiguracionTicket");

        try
        {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_evento", evento);

            getSqlSession().selectOne(PATH_CONFIGURACION_TICKET, params);
            LOGGER.info(params);

            List<ConfiguracionTicketDTO> item = (List<ConfiguracionTicketDTO>) params.get("OUT_CURSOR_JSD");
            LOGGER.info("Configuracion"+item);
            return item;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }

    }

    @Override
    public String getPropertyValue(String key, String ambiente) throws DAOException
    {
        LOGGER.info("Ingreso InfoClientDAOImpl - getPropertyValue");
        try
        {

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("i_key", key);
            params.put("i_environment", ambiente);
            getSqlSession().selectOne(PATH_PROPERTIES, params);
            String URL = (String) params.get("OUT_VALUE");
            LOGGER.info("URL-->"+ URL);
            return URL;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }

    @Override
    public String getResumen(String idActividad, String Evento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getResumen");

        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_actividad", idActividad);
            params.put("p_evento", Evento);
            getSqlSession().selectOne(PATH_RESUMEN, params);
            LOGGER.info(params);
            String mensaje = (String) params.get("OUT_RESUMEN");
            LOGGER.info("Resumen-->"+mensaje);
            return mensaje;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }

    @Override
    public String getDescripcion(String idActividad, String Evento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getDescripcion");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_actividad", idActividad);
            params.put("p_evento", Evento);
            getSqlSession().selectOne(PATH_DESCRIPCION, params);
            LOGGER.info(params);
            String mensaje = (String) params.get("OUT_DESCRIPCION");
            LOGGER.info("DESCRIPCION-->"+mensaje);
            return mensaje;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }

    @Override
    public String getConfiguracion(String tipoLista, String subTipoLista, String estadoLista)
            throws DAOException
    {
        return getConfiguracion(tipoLista, subTipoLista, null, estadoLista);
    }

    @Override
    public String getConfiguracion(String tipoLista, String subTipoLista, String valorVisible, String estadoLista) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getObtenerTelefono");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_tipo_lista", tipoLista);
            params.put("p_subtipo_lista", subTipoLista);
            params.put("p_estado_lista", estadoLista);
            params.put("p_valor_visible", valorVisible);
            getSqlSession().selectOne(PATH_OBTENER_CONFIGURACION, params);
            LOGGER.info(params);
            String telefono = (String) params.get("OUT_CONFIGURACION");
            LOGGER.info("CONFIGURACION-->"+telefono);
            return telefono;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }

    @Override
    public void insertarJsdSeguimiento(RespuestaBusDTO respuestaBus, String idEvento, String Evento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - insertarJsdSeguimiento");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_evento", idEvento);
            params.put("p_evento", Evento);
            params.put("p_issue_id", respuestaBus.getIssueId());
            params.put("p_issue_key", respuestaBus.getIssueKey());
            LOGGER.info(params);
            getSqlSession().selectOne(PATH_INSERTAR_SEGUIMIENTO, params);
            LOGGER.info("Saliendo InteSicretJsdWSDAOImpl - insertarJsdSeguimiento");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }


    @Override
    public String getEstadoValidacion(String idAplicacion) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getEstadoValidacion");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_aplicacion", idAplicacion);
            getSqlSession().selectOne(PATH_ESTADO_APLICACION, params);
            LOGGER.info(params);
            String estado= (String) params.get("OUT_ESTADO");
            LOGGER.info("ESTADO APLICACION-->"+ estado);
            return estado;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_LISTA_VALIDACION, e);
        }
    }

    @Override
    public String getUsuarioCreacion(String idEvento, String evento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getUsuarioCreacion");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_evento", idEvento);
            params.put("p_evento", evento);
            getSqlSession().selectOne(PATH_USUARIO_CREACION, params);
            LOGGER.info(params);
            String usuario= (String) params.get("OUT_USUARIO");
            LOGGER.info("USUARIO CREACION-->"+ usuario);
            return usuario;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_CREAR_TICKET, e);
        }
    }

    @Override
    public String getIssueKey(String idEvento) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getIssueKey");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_evento", idEvento);
            getSqlSession().selectOne(PATH_OBTENER_ISSUE_KEY, params);
            LOGGER.info(params);
            String issueKey= (String) params.get("OUT_ISSUE");
            LOGGER.info("ISSUE KEY-->"+ issueKey);
            return issueKey;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_MODIFICAR_TICKET, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CorreoDTO> getDestinatarios(String tipoLista, String subTipoLista, String estadoLista) throws
            DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getValorVisible");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_tipo_lista", tipoLista);
            params.put("p_subtipo_lista", subTipoLista);
            params.put("p_estado_lista", estadoLista);
            getSqlSession().selectOne(PATH_OBTENER_DESTINATARIOS, params);
            LOGGER.info(params);
            List<CorreoDTO> correoDTOS = (List<CorreoDTO>) params.get("OUT_DESTINATARIOS");
            LOGGER.info("VALOR_VISIBLE-->" + correoDTOS);
            return correoDTOS;

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_ENVIAR_CORREO, e);
        }
    }

    @Override
    public List<AddCommentDTO> getComentarioActividad(String idBitacora) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getComentarioActividad");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_bitacora", idBitacora);
            getSqlSession().selectOne(PATH_COMENTARIO_ACTIVIDAD, params);
            LOGGER.info(params);
            return (List<AddCommentDTO>) params.get("OUT_CURSOR");

        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_COMENTARIO, e);
        }
    }

    @Override
    public List<AddCommentDTO> getComentarioReclamo(String idBitacora) throws DAOException
    {
        LOGGER.info("Ingreso InteSicretJsdWSDAOImpl - getComentarioReclamo");
        try
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("p_id_bitacora", idBitacora);
            getSqlSession().selectOne(PATH_COMENTARIO_RECLAMO, params);
            LOGGER.info(params);
            return (List<AddCommentDTO>) params.get("OUT_CURSOR");
        } catch (Exception e)
        {
            throw new DAOException(ErrorMessage.MESSAGE_ERROR_OBTENER_COMENTARIO, e);
        }
    }
}
