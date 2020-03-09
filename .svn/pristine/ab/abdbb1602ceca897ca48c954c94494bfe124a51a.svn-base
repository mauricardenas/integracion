package com.grupogtd.integration.sicret.jsd.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;

public class FindExtensionMessage
{
    private static final Log LOGGER = LogFactory.getLog(FindExtensionMessage.class);

    private FindExtensionMessage()
    {
    }

    public static List<String> extractFileNames(String comentario)
    {
        List<String> fileNames = FindExtensionMessage.getFileNames(comentario, "[^", "]");
        List<String> fileNames2 = FindExtensionMessage.getFileNames(comentario, "!", "!");
        fileNames.addAll(fileNames2);
        LOGGER.info("FILENAMES FOUND ->"+fileNames);
        return fileNames;
    }

    protected static List<String> getFileNames(String body, String startWith, String endWith)
    {
        int indexEnd;
        List<String> filenames = new LinkedList<String>();
        do
        {
            indexEnd = body.lastIndexOf(endWith);
            //LOGGER.info(indexEnd);
            int indexStart = body.lastIndexOf(startWith, indexEnd - 1);
            //LOGGER.info(indexStart);
            if (indexStart==-1){
                break;
            }
            String filenamePart = body.substring(indexStart, indexEnd);
            //LOGGER.info(filenamePart);
            if (!FindExtensionMessage.hasExtensions(filenamePart))
            {
                body = body.substring(0,indexStart)+startWith;
                continue;
            }
            /*
            else if (!hasExtensionAtEnd(filenamePart) && hasExtensionBetween(filenamePart, endWith))
            {
                body = body.substring(0,indexEnd);
                continue;
            }
            */
            int index3 = filenamePart.lastIndexOf("|", indexEnd - 1);
            //LOGGER.info(index3);
            if (index3!=-1){
                filenamePart = filenamePart.substring(0, index3);
                //LOGGER.info(filenamePart);
            }
            String filename = filenamePart.substring(startWith.length());
            filenames.add(filename);
            //LOGGER.info(filename);
            body = body.substring(0,indexStart);
        }while(indexEnd!=-1);

        return filenames;
    }

    private static boolean hasExtensions(String fileName)
    {
        SupportedExtensionType[] values = SupportedExtensionType.values();
        for (SupportedExtensionType value : values)
        {
            if (fileName.contains(value.getExtension())){
                return true;
            }
        }
        return false;
    }

    private static boolean hasExtensionAtEnd(String fileName)
    {
        SupportedExtensionType[] values = SupportedExtensionType.values();
        for (SupportedExtensionType value : values)
        {
            int extensionLength = value.getExtension().length();
            String extensionPart = fileName.substring(fileName.length() - extensionLength);
            if (extensionPart.equalsIgnoreCase(value.getExtension())){
                return true;
            }
        }
        return false;
    }

    private static boolean hasExtensionBetween(String fileName, String endWith)
    {
        SupportedExtensionType[] values = SupportedExtensionType.values();
        for (SupportedExtensionType value : values)
        {
            if (fileName.contains(value.getExtension()+endWith)){
                return true;
            }
        }
        return false;
    }

}