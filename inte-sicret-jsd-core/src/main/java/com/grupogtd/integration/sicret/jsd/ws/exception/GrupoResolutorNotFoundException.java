package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Base Business Excepion
 */
public class GrupoResolutorNotFoundException extends Exception
{
    public String getCode(){
        return ErrorCode.FAILED_GET_GRUPO_RESOLUTOR;
    }

    public GrupoResolutorNotFoundException()
    {
        super(ErrorMessage.MESSAGE_ERROR_OBTENER_ARE_RESOLUTORA);
    }

    public GrupoResolutorNotFoundException(String message)
    {
        super(message);
    }

    public GrupoResolutorNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public GrupoResolutorNotFoundException(Throwable cause)
    {
        super(cause);
    }

}
