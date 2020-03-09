package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 17-02-2019.
 */
public class CurrentStatusDTO
{
    private String status;
    private StatusDateDTO statusDate;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public StatusDateDTO getStatusDate()
    {
        return statusDate;
    }

    public void setStatusDate(StatusDateDTO statusDate)
    {
        this.statusDate = statusDate;
    }

    @Override
    public String toString()
    {
        return "CurrentStatusDTO{" +
                "status='" + status + '\'' +
                ", statusDate=" + statusDate +
                '}';
    }
}
