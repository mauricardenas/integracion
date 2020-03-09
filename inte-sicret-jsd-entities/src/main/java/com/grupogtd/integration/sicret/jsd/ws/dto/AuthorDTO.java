package com.grupogtd.integration.sicret.jsd.ws.dto;

/**
 * Created by Softtek on 03-03-2019.
 */
public class AuthorDTO
{
    private String name;
    private String key;
    private String emailAddress;
    private String  displayName;
    private boolean active;
    private String timeZone;
    private LinksDTO _links;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
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
        return "AuthorDTO{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", emailAddress=" + emailAddress +
                ", displayName='" + displayName + '\'' +
                ", active=" + active +
                ", timeZone='" + timeZone + '\'' +
                ", _links=" + _links +
                '}';
    }
}
