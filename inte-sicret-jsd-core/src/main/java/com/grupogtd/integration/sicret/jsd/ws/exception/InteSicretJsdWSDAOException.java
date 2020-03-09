package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by jespinosa on 13/06/2017.
 */
public class InteSicretJsdWSDAOException extends InteSicretJsdWSBusinessException {

    public String getCode(){
        return ErrorCode.DAO_EXCEPTION;
    }

    public InteSicretJsdWSDAOException()
    {
        super(ErrorMessage.UNKNOWN);
    }

    public InteSicretJsdWSDAOException(String message)
    {
        super(message);
    }

    public InteSicretJsdWSDAOException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InteSicretJsdWSDAOException(Throwable cause)
    {
        super(cause);
    }
}
