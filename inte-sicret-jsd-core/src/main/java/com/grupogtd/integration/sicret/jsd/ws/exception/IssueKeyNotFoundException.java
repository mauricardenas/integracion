package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by rpalacios on 16-03-2017.
 */
public class IssueKeyNotFoundException extends InteSicretJsdWSBusinessException
{
    @Override
    public String getCode()
    {
        return ErrorCode.ISSUE_KEY_NOT_FOUND;
    }

    public IssueKeyNotFoundException()
    {
        super(ErrorMessage.ISSUE_KEY_NOT_FOUND);
    }

    public IssueKeyNotFoundException(String message)
    {
        super(message);
    }

    public IssueKeyNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public IssueKeyNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
