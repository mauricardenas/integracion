package com.grupogtd.integration.sicret.jsd.ws.exception;

public class ErrorCode
{
    private ErrorCode()
    {
    }


    public static final String BASE = "0001";
    public static final String UNKNOWN = "0002";
    public static final String DAO_EXCEPTION="0004";
    public static final String ERROR_CALL_FN ="0032";
    public static final String NOTIFICATION_ERROR="0004";
    public static final String ISSUE_KEY_NOT_FOUND_IN_PAYLOAD = "0005";
    public static final String WAS_NO_POSSIBLE_SAVE_REQUEST_PAYLOAD = "0006";
    public static final String JSD_FILE_DOWNLOAD_EXCEPTION = "0007";
    public static final String CAN_NOT_GET_PROPERTY_CONFIGURATION_EXCEPTION = "0007";
    public static final String ISSUE_KEY_NOT_FOUND = "0009";
    public static final String FAILED_FILE_UPLOAD = "0010";
    public static final String FAILED_GET_EVENT_TYPE = "0011";
    public static final String FAILED_UPDATE_RESOLUTION_AREA = "0012";
    public static final String FAILED_GET_GRUPO_RESOLUTOR = "0013";
}
