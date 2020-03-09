package com.grupogtd.integration.sicret.jsd.ws.response;

import com.grupogtd.integration.sicret.jsd.ws.dto.LinksDTOParticipant;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Softtek on 03-03-2019.
 */
public class AgregarParticipanteResponse implements Serializable
{
    private int size;
    private int start;
    private int limit;
    @JsonProperty("isLastPage")
    private boolean isLastPage;
    private LinksDTOParticipant _links;
    private List<Object> values;

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart(int start)
    {
        this.start = start;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public boolean isLastPage()
    {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage)
    {
        isLastPage = lastPage;
    }

    public LinksDTOParticipant get_links()
    {
        return _links;
    }

    public void set_links(LinksDTOParticipant _links)
    {
        this._links = _links;
    }

    public List<Object> getValues()
    {
        return values;
    }

    public void setValues(List<Object> values)
    {
        this.values = values;
    }

    @Override
    public String toString()
    {
        return "AgregarParticipanteResponse{" +
                "size=" + size +
                ", start=" + start +
                ", limit=" + limit +
                ", isLastPage=" + isLastPage +
                ", _links=" + _links +
                ", values=" + values +
                '}';
    }
}
