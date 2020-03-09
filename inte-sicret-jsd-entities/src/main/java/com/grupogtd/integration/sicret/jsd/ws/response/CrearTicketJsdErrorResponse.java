package com.grupogtd.integration.sicret.jsd.ws.response;

public class CrearTicketJsdErrorResponse
{
    private String errorMessage;

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString()
    {
        return "CrearTicketJsdErrorResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
