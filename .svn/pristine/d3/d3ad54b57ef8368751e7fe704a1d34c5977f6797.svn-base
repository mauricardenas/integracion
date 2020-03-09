package com.grupogtd.integration.sicret.jsd.ws.dao;

import com.grupogtd.integration.sicret.jsd.ws.dto.AddCommentDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ConfiguracionTicketDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CorreoDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.RespuestaBusDTO;
import com.grupogtd.integration.sicret.jsd.ws.exception.DAOException;

import java.util.List;

/**
 * Created by rpalacios on 16-05-2017.
 */
public interface InteSicretJsdWSDAO
{
    List<ConfiguracionTicketDTO> getConfiguracionTicket(String evento) throws DAOException;

    String getPropertyValue(String key, String ambiente) throws DAOException;

    String getResumen(String idActividad, String Evento) throws DAOException;

    String getDescripcion(String idActividad, String Evento) throws DAOException;

    String getConfiguracion(String tipoLista, String subTipoLista, String estadoLista) throws DAOException;

    String getConfiguracion(String tipoLista, String subTipoLista, String valorVisible, String estadoLista) throws DAOException;

    String getEstadoValidacion(String idAplicacion) throws DAOException;

    void insertarJsdSeguimiento(RespuestaBusDTO respuesta, String idEvento, String Evento) throws DAOException;

    String getUsuarioCreacion(String idEvento, String evento) throws DAOException;

    String getIssueKey(String idEvento) throws DAOException;

    List<CorreoDTO> getDestinatarios(String tipoLista, String subTipoLista, String estadoLista) throws
            DAOException;

    List<AddCommentDTO> getComentarioActividad(String idBitacora) throws DAOException;


    List<AddCommentDTO> getComentarioReclamo(String idBitacora) throws DAOException;
}
