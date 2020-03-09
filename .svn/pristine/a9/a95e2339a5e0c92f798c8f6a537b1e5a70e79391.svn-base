package com.grupogtd.integration.sicret.jsd.ws.impl;

import com.grupogtd.integration.sicret.jsd.ws.JsdFileDownloader;
import com.grupogtd.integration.sicret.jsd.ws.exception.JsdFileDownloadException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class JsdFileDownloaderImpl implements JsdFileDownloader
{
    private final String host;
    private final int port;
    private final String scheme;
    private final String user;
    private final String password;

    public JsdFileDownloaderImpl(String host, int port, String scheme, String user, String password)
    {
        this.host = host;
        this.port = port;
        this.scheme = scheme;

        this.user = user;
        this.password = password;
    }

    public byte[] download(String url) throws JsdFileDownloadException
    {
        HttpHost target = new HttpHost(host, port, scheme);

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(user, password));

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();
        try
        {
            // Create AuthCache instance
            AuthCache authCache = new BasicAuthCache();
            // Generate BASIC scheme object and add it to the local
            // auth cache
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(target, basicAuth);

            // Add AuthCache to the execution context
            HttpClientContext localContext = HttpClientContext.create();
            localContext.setAuthCache(authCache);

            HttpGet httpget = new HttpGet(url);

            System.out.println("Executing request " + httpget.getRequestLine() + " to target " + target);

            CloseableHttpResponse response = httpClient.execute(target, httpget, localContext);

            try
            {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println("----------------------------------------");
                if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
                {
                    throw new Exception("STATUS CODE NOT VALID" + response.getStatusLine().getStatusCode());
                }
                HttpEntity entity = response.getEntity();
                return readResponse(entity);

            }
            finally
            {
                if (response != null)
                    try
                    {
                        response.close();
                    }
                    catch (IOException ignore){}
            }

        }
        catch (Exception e)
        {
            throw new JsdFileDownloadException(url, e);
        }
        finally
        {
            if (httpClient != null)
                try
                {
                    httpClient.close();
                }
                catch (IOException ignore){}
        }

    }

    private static byte[] readResponse(HttpEntity entity) throws IOException
    {
        InputStream is = null;
        try
        {
            is = entity.getContent();
            return IOUtils.toByteArray(is);
        }
        finally
        {
            if (is != null)
                try
                {
                    is.close();
                }
                catch (IOException ignore)
                {
                }
        }
    }

}
