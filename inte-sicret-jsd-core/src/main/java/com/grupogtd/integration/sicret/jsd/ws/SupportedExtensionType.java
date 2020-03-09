package com.grupogtd.integration.sicret.jsd.ws;

public enum SupportedExtensionType
{
    DOC(".doc"),
    DOCX(".docx"),
    PDF(".pdf"),
    XLS(".xls"),
    XLSX(".xlsx"),
    PPT(".ppt"),
    PPTX(".pptx"),
    JPG(".jpg"),
    JPEG(".jpeg"),
    GIF(".gif"),
    PNG(".png"),
    TXT(".txt"),
    MSG(".msg"),
    NOT_MATCH("no contiene archivos adjuntos");

    private final String extension;

    SupportedExtensionType(String extension)
    {
        this.extension = extension;
    }

    public String getExtension()
    {
        return extension;
    }


    public static SupportedExtensionType getSupportedExtensionType(String extensionStr)
    {
        if (extensionStr == null)
        {
            return NOT_MATCH;
        }

        for (SupportedExtensionType value : values())
        {
            if (extensionStr.toLowerCase().contains(value.getExtension().toLowerCase()))
            {
                return value;

            }

        }
        return NOT_MATCH;
    }
}
