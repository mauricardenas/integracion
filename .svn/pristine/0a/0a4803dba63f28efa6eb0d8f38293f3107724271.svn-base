package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by rpalacios on 16-03-2017.
 */
public class JsdFileDownloadException extends InteSicretJsdWSBusinessException
{
    @Override
    public String getCode()
    {
        return ErrorCode.JSD_FILE_DOWNLOAD_EXCEPTION;
    }

    public JsdFileDownloadException(String url, Exception e)
    {
        super(ErrorMessage.JSD_FILE_DOWNLOAD_EXCEPTION.replaceFirst("\\$\\{urlArchivoAdjunto}", url),e);
    }
}
