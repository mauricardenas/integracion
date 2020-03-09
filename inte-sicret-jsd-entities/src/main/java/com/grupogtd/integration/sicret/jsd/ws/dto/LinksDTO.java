package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 16-02-2019.
 */

public class LinksDTO
{
    private String jiraRest;
    private AvatarUrlsDTO avatarUrls;
    private String web;
    private String self;


    public String getJiraRest()
    {
        return jiraRest;
    }

    public void setJiraRest(String jiraRest)
    {
        this.jiraRest = jiraRest;
    }

    public AvatarUrlsDTO getAvatarUrls()
    {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrlsDTO avatarUrls)
    {
        this.avatarUrls = avatarUrls;
    }

    public String getWeb()
    {
        return web;
    }

    public void setWeb(String web)
    {
        this.web = web;
    }

    public String getSelf()
    {
        return self;
    }

    public void setSelf(String self)
    {
        this.self = self;
    }

    @Override
    public String toString()
    {
        return "LinksDTO{" +
                "jiraRest='" + jiraRest + '\'' +
                ", avatarUrls=" + avatarUrls +
                ", web='" + web + '\'' +
                ", self='" + self + '\'' +
                '}';
    }
}


