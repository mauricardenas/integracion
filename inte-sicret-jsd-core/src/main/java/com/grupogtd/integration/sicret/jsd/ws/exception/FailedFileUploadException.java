package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by rpalacios on 16-03-2017.
 */
public class FailedFileUploadException extends InteSicretJsdWSBusinessException
{
    @Override
    public String getCode()
    {
        return ErrorCode.FAILED_FILE_UPLOAD;
    }

    public FailedFileUploadException()
    {
        super(ErrorMessage.FAILED_FILE_UPLOAD);
    }

    public FailedFileUploadException(String message)
    {
        super(message);
    }

    public FailedFileUploadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FailedFileUploadException(Throwable cause)
    {
        super(cause);
    }
}
