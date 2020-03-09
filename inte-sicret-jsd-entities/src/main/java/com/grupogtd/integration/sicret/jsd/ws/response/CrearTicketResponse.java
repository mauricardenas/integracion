package com.grupogtd.integration.sicret.jsd.ws.response;

import com.grupogtd.integration.sicret.jsd.ws.dto.CreatedDateDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CurrentStatusDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.LinksDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ReporterDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Softtek on 17-02-2019.
 */

public class CrearTicketResponse implements Serializable
{
   private List<String> _expands;
   private int issueId;
   private String issueKey;
    private int requestTypeId;
    private int serviceDeskId;
    private CreatedDateDTO createdDate;
    private ReporterDTO reporter;
    private List<Object> requestFieldValues;
    private CurrentStatusDTO currentStatus;
    private LinksDTO _links;

    public List<String> get_expands()
    {
        return _expands;
    }

    public void set_expands(List<String> _expands)
    {
        this._expands = _expands;
    }

    public int getIssueId()
    {
        return issueId;
    }

    public void setIssueId(int issueId)
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

    public int getRequestTypeId()
    {
        return requestTypeId;
    }

    public void setRequestTypeId(int requestTypeId)
    {
        this.requestTypeId = requestTypeId;
    }

    public int getServiceDeskId()
    {
        return serviceDeskId;
    }

    public void setServiceDeskId(int serviceDeskId)
    {
        this.serviceDeskId = serviceDeskId;
    }

    public CreatedDateDTO getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(CreatedDateDTO createdDate)
    {
        this.createdDate = createdDate;
    }

    public ReporterDTO getReporter()
    {
        return reporter;
    }

    public void setReporter(ReporterDTO reporter)
    {
        this.reporter = reporter;
    }

    public List<Object> getRequestFieldValues()
    {
        return requestFieldValues;
    }

    public void setRequestFieldValues(List<Object> requestFieldValues)
    {
        this.requestFieldValues = requestFieldValues;
    }

    public CurrentStatusDTO getCurrentStatus()
    {
        return currentStatus;
    }

    public void setCurrentStatus(CurrentStatusDTO currentStatus)
    {
        this.currentStatus = currentStatus;
    }

    public LinksDTO get_links()
    {
        return _links;
    }

    public void set_links(LinksDTO _links)
    {
        this._links = _links;
    }

    @Override
    public String toString()
    {
        return "CrearTicketResponse{" +
                "_expands=" + _expands +
                ", issueId=" + issueId +
                ", issueKey='" + issueKey + '\'' +
                ", requestTypeId=" + requestTypeId +
                ", serviceDeskId=" + serviceDeskId +
                ", createdDate=" + createdDate +
                ", reporter=" + reporter +
                ", requestFieldValues=" + requestFieldValues +
                ", currentStatus=" + currentStatus +
                ", _links=" + _links +
                '}';
    }
}
