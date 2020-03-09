package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by rpalacios on 16-03-2017.
 */
public class IssueKeyNotFoundInRequestPayloadException extends InteSicretJsdWSBusinessException
{
    @Override
    public String getCode()
    {
        return ErrorCode.ISSUE_KEY_NOT_FOUND_IN_PAYLOAD;
    }

    public IssueKeyNotFoundInRequestPayloadException()
    {
        super(ErrorMessage.ISSUE_KEY_NOT_FOUND_IN_PAYLOAD);
    }

    public IssueKeyNotFoundInRequestPayloadException(String message)
    {
        super(message);
    }

    public IssueKeyNotFoundInRequestPayloadException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public IssueKeyNotFoundInRequestPayloadException(Throwable cause)
    {
        super(cause);
    }
}
