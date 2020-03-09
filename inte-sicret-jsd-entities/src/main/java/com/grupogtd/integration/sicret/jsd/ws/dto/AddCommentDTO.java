package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 15-03-2019.
 */
public class AddCommentDTO
{
    private String comentario;
    private String issueKey;
    private String usuarioCreacion;

    public String getComentario()
    {
        return comentario;
    }

    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    public String getIssueKey()
    {
        return issueKey;
    }

    public void setIssueKey(String issueKey)
    {
        this.issueKey = issueKey;
    }

    public String getUsuarioCreacion()
    {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion)
    {
        this.usuarioCreacion = usuarioCreacion;
    }

    @Override
    public String toString()
    {
        return "AddCommentDTO{" +
                "comentario='" + comentario + '\'' +
                ", issueKey='" + issueKey + '\'' +
                ", usuarioCreacion='" + usuarioCreacion + '\'' +
                '}';
    }
}
