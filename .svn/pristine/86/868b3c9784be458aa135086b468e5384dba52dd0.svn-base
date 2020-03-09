package com.grupogtd.integration.sicret.jsd.ws;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JsonDataRetriever
{
    private JsonDataRetriever()
    {
    }

    private static final Log LOGGER = LogFactory.getLog(JsonDataRetriever.class);


    public static <OUT>  OUT getData(String json,String key, Class<OUT> outClass)
    {
        LOGGER.info("getData(key[" + key + "])");

        OUT data = null;
        JsonParser parser = new JsonParser();
        try
        {
            JsonElement elementObject = parser.parse(json);
            JsonObject asJsonObject = elementObject.getAsJsonObject();
            boolean flag = false;
            JsonElement jsonElement= null;


            String[] parts = key.split("\\.");

            for (int i = 1; i < parts.length-1; i++)
            {
                String part = parts[i];
                if(parts[i+1].contains("["))
                {
                    int start = parts[i+1].indexOf("[");
                    int end= parts[i+1].indexOf("]");
                    String position = parts[i+1].substring(start+1, end);
                    int post = Integer.parseInt(position);
                    String array = parts[i+1].substring(0,start);

                    // asJsonObject.getAsJsonArray(part);
                    JsonArray jarray = asJsonObject.getAsJsonObject(part).getAsJsonArray(array);
                    asJsonObject = jarray.get(post).getAsJsonObject();
                     jsonElement = asJsonObject.get(parts[parts.length - 1]);
                    flag = true;


                }else if(!parts[i].contains("["))
                {
                    JsonElement partAsJsonElement = asJsonObject.get(part);
                    if (partAsJsonElement == null)
                    {
                        return null;
                    }
                    asJsonObject = partAsJsonElement.getAsJsonObject();
                }

            }

            if(!flag)
            {
                 jsonElement = asJsonObject.get(parts[parts.length - 1]);
            }


            if (outClass == Long.class)
            {
                return (OUT) new Long(jsonElement.getAsLong());
            }
            else if (outClass == String.class)
            {
                data = (OUT) jsonElement.getAsString();
            }
            else if (outClass == Integer.class)
            {
                data = (OUT) new Integer(jsonElement.getAsInt());
            }

        }
        catch (Exception e)
        {
            LOGGER.error("getData(key[" + key + "]) fail with message [" + e.getMessage() + ']', e);
        }

        LOGGER.info("getData(key[" + key + "]) returns ->[" + data + ']');
        return data;

    }










}
