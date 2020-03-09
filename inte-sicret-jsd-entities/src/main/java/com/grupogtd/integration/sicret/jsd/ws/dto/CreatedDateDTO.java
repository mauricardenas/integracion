package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 16-02-2019.
 */
public class CreatedDateDTO
{
    private String iso8601;
    private String jira;
    private String friendly;
    private Long epochMillis;

    public String getIso8601()
    {
        return iso8601;
    }

    public void setIso8601(String iso8601)
    {
        this.iso8601 = iso8601;
    }

    public String getJira()
    {
        return jira;
    }

    public void setJira(String jira)
    {
        this.jira = jira;
    }

    public String getFriendly()
    {
        return friendly;
    }

    public void setFriendly(String friendly)
    {
        this.friendly = friendly;
    }

    public Long getEpochMillis()
    {
        return epochMillis;
    }

    public void setEpochMillis(Long epochMillis)
    {
        this.epochMillis = epochMillis;
    }

    @Override
    public String toString()
    {
        return "CreatedDateDTO{" +
                "iso8601='" + iso8601 + '\'' +
                ", jira='" + jira + '\'' +
                ", friendly='" + friendly + '\'' +
                ", epochMillis=" + epochMillis +
                '}';
    }
}
