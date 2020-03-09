package com.grupogtd.integration.sicret.jsd.ws.business.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertAttachmentFilesSicretHandlerImplTest
{
    private static final String HOST = "172.20.100.187";
    private static final int PORT = 7305;
    private static final String SCHEMA = "http";
    @Test
    public void migrateUrlToEsbOk()
    {
        String attachmentURL="https://10.1.202.222:7202/secure/attachment/38907/KC1969.jpg";
        String migrateUrl = InsertAttachmentFilesSicretHandlerImpl.migrateUrlToEsb(attachmentURL, SCHEMA, HOST, PORT);
        assertEquals("http://172.20.100.187:7305/jira/secure/attachment/38907/KC1969.jpg", migrateUrl);


    }
}