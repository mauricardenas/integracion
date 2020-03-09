package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 16-02-2019.
 */
public class RespuestaBusDTO
{

    private String issueId;
    private String issueKey;
    private String estado;

    public String getIssueId()
    {
        return issueId;
    }

    public void setIssueId(String issueId)
    {
        this.issueId = issueId;
    }

    public String getIssueKey()
    {
        return issueKey;
    }

    public void setIssueKey(String issueKey)
    {
        this.issueKey = issueKey;
    }

    public String getEstado()
    {
        return estado;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    @Override
    public String toString()
    {
        return "RespuestaBusDTO{" +
                "issueId='" + issueId + '\'' +
                ", issueKey='" + issueKey + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
