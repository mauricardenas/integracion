package com.grupogtd.integration.sicret.jsd.ws.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsdFileDownloader;
import org.junit.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsdFileDownloaderImplTest
{

    private static final String HOST = "172.20.100.187";
    private static final int PORT = 7305;
    private static final String SCHEMA = "http";

    private static final String USER = "sicret";
    private static final String PASS = "GrupoGtd123##";

    private static final String URL = SCHEMA + "://" + HOST + ":" + PORT + "/jira/secure/attachment/38907/KC1969.jpg";

    @org.junit.Test
    public void downloadSuccessTest()
    {

        JsdFileDownloader downloader = new JsdFileDownloaderImpl(HOST, PORT, SCHEMA, USER, PASS);
        try
        {
            byte[] byteArray = downloader.download(URL);
            writeFile(byteArray, "KC1969.jpg");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }

    private void writeFile(byte[] byteArray, String pathname) throws IOException
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(new File(pathname));
            fos.write(byteArray);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (fos != null)
                fos.close();
        }
    }
}