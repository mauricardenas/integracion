package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by jespinosa on 09/10/2017.
 */
public class DAOException extends InteSicretJsdWSDAOException {

    public String getCode(){
        return ErrorCode.ERROR_CALL_FN;
    }

    public DAOException()
    {
        super(ErrorCode.UNKNOWN);
    }

    public DAOException(String message)
    {
        super(message);
    }

    public DAOException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DAOException(Throwable cause)
    {
        super(cause);
    }
}
