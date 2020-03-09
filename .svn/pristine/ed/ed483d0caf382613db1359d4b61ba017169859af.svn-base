package com.grupogtd.integration.sicret.jsd.ws.exception;

/**
 * Created by rpalacios on 16-03-2017.
 */
public class CanNotGetPropertyConfigurationException extends InteSicretJsdWSBusinessException
{
    @Override
    public String getCode()
    {
        return ErrorCode.CAN_NOT_GET_PROPERTY_CONFIGURATION_EXCEPTION;
    }

    public CanNotGetPropertyConfigurationException(String propertyKey, Exception e)
    {
        super(ErrorMessage.CAN_NOT_GET_PROPERTY_CONFIGURATION_EXCEPTION.replaceFirst("\\$\\{$propertyKey}", propertyKey),e);
    }
}
