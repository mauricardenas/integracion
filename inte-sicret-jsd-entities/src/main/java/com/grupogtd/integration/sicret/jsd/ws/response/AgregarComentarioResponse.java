package com.grupogtd.integration.sicret.jsd.ws.response;

import com.grupogtd.integration.sicret.jsd.ws.dto.AuthorDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CreatedDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.LinksDTO;

import java.io.Serializable;

/**
 * Created by Softtek on 15-03-2019.
 */
public class AgregarComentarioResponse implements Serializable
{
    private int id;
    private String body;
    private boolean _public;
    private AuthorDTO author;
    private CreatedDTO created;
    private LinksDTO links;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public boolean is_public()
    {
        return _public;
    }

    public void set_public(boolean _public)
    {
        this._public = _public;
    }

    public AuthorDTO getAuthor()
    {
        return author;
    }

    public void setAuthor(AuthorDTO author)
    {
        this.author = author;
    }

    public CreatedDTO getCreated()
    {
        return created;
    }

    public void setCreated(CreatedDTO created)
    {
        this.created = created;
    }

    public LinksDTO getLinks()
    {
        return links;
    }

    public void setLinks(LinksDTO links)
    {
        this.links = links;
    }

    @Override
    public String toString()
    {
        return "AgregarComentarioResponse{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", _public=" + _public +
                ", author=" + author +
                ", created=" + created +
                ", links=" + links +
                '}';
    }
}
