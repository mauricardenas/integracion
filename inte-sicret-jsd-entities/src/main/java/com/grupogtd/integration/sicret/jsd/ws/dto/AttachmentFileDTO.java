package com.grupogtd.integration.sicret.jsd.ws.dto;

public class AttachmentFileDTO
{
    private String urlAttachmentFile;
    private String idAttachmentFile;

    public String getUrlAttachmentFile()
    {
        return urlAttachmentFile;
    }

    public void setUrlAttachmentFile(String urlAttachmentFile)
    {
        this.urlAttachmentFile = urlAttachmentFile;
    }

    public String getIdAttachmentFile()
    {
        return idAttachmentFile;
    }

    public void setIdAttachmentFile(String idAttachmentFile)
    {
        this.idAttachmentFile = idAttachmentFile;
    }

    @Override
    public String toString()
    {
        return "AttachmentFileDTO{" +
                "urlAttachmentFile='" + urlAttachmentFile + '\'' +
                ", idAttachmentFile='" + idAttachmentFile + '\'' +
                '}';
    }
}
