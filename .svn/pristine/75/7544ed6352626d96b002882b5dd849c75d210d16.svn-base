package com.grupogtd.integration.sicret.jsd.ws;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonDataRetrieverTest
{

    @Test
    public void getTransitionNameWithNoMatch()
    {
        String transitionName = JsonDataRetriever.getData(Json, "$.transition.transitionName", String.class);
        assertNull(transitionName);
    }

    @Test
    public void getAuthorKey()
    {
        String key = JsonDataRetriever.getData(Json, "$.comment.author.key", String.class);
        assertNotNull(key);
    }


    @Test
    public void getIssueKey()
    {
        String issueKey = JsonDataRetriever.getData(Json, "$.issue.key", String.class);
        System.out.println(issueKey);

        assertNotNull(issueKey);
        assertEquals("DVCOR-722",issueKey);
    }


    @Test
    public void getComment()
    {
        String comentario = JsonDataRetriever.getData(Json, "$.comment.body", String.class);
        System.out.println(comentario);

        assertNotNull(comentario);
    }

    @Test
    public void getIssueStatus()
    {
        String comentario = JsonDataRetriever.getData(Json, "$.issue.fields.status.name", String.class);
        System.out.println(comentario);

        assertNotNull(comentario);
    }

    @Test
    public void getAreaResolutora()
    {
        String AreaResolutora= JsonDataRetriever.getData(Json, "$.issue.fields.customfield_10717", String.class);
        System.out.println(AreaResolutora);
        assertNotNull(AreaResolutora);
    }

    @Test
    public void getCantMensajes()
    {
        Integer cantidadMensajes = JsonDataRetriever.getData(Json, "$.issue.fields.comment.total", Integer.class);
        String pathBody = JsonDataRetriever.getData(Json, "$.issue.fields.comment.comments[" + (cantidadMensajes - 1) + "].body", String.class);
        System.out.println(cantidadMensajes);
        System.out.println(pathBody);

        assertNotNull(pathBody);
    }

    private static final String Json = "{\n" +
            "\t\"issue\": {\n" +
            "\t\t\"id\": \"48693\",\n" +
            "\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693\",\n" +
            "\t\t\"key\": \"DVCOR-722\",\n" +
            "\t\t\"fields\": {\n" +
            "\t\t\t\"customfield_12011\": null,\n" +
            "\t\t\t\"customfield_12010\": null,\n" +
            "\t\t\t\"customfield_12013\": null,\n" +
            "\t\t\t\"fixVersions\": [],\n" +
            "\t\t\t\"customfield_12012\": null,\n" +
            "\t\t\t\"customfield_11200\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10500\",\n" +
            "\t\t\t\t\"value\": \"Requerimiento\",\n" +
            "\t\t\t\t\"id\": \"10500\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12015\": null,\n" +
            "\t\t\t\"resolution\": null,\n" +
            "\t\t\t\"customfield_12014\": null,\n" +
            "\t\t\t\"customfield_12017\": null,\n" +
            "\t\t\t\"customfield_10114\": null,\n" +
            "\t\t\t\"customfield_12016\": null,\n" +
            "\t\t\t\"customfield_12008\": null,\n" +
            "\t\t\t\"customfield_10501\": null,\n" +
            "\t\t\t\"customfield_12007\": null,\n" +
            "\t\t\t\"customfield_10502\": 0.0,\n" +
            "\t\t\t\"customfield_11834\": null,\n" +
            "\t\t\t\"customfield_11833\": null,\n" +
            "\t\t\t\"customfield_12009\": null,\n" +
            "\t\t\t\"lastViewed\": null,\n" +
            "\t\t\t\"customfield_12000\": {\n" +
            "\t\t\t\t\"id\": \"28\",\n" +
            "\t\t\t\t\"name\": \"AprobaciÃ³n Plataformas\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/48693/sla/28\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12002\": null,\n" +
            "\t\t\t\"customfield_12001\": {\n" +
            "\t\t\t\t\"id\": \"29\",\n" +
            "\t\t\t\t\"name\": \"AprobaciÃ³n Gestor de Cambios\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/48693/sla/29\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"priority\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/priority/10001\",\n" +
            "\t\t\t\t\"iconUrl\": \"http://sd.grupogtd.com:8080/images/icons/priorities/high.svg\",\n" +
            "\t\t\t\t\"name\": \"Severidad 2 (4 hrs)\",\n" +
            "\t\t\t\t\"id\": \"10001\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10100\": null,\n" +
            "\t\t\t\"customfield_12004\": null,\n" +
            "\t\t\t\"customfield_10101\": null,\n" +
            "\t\t\t\"customfield_12003\": null,\n" +
            "\t\t\t\"customfield_10102\": null,\n" +
            "\t\t\t\"customfield_12006\": null,\n" +
            "\t\t\t\"customfield_12005\": null,\n" +
            "\t\t\t\"customfield_11820\": null,\n" +
            "\t\t\t\"timeestimate\": null,\n" +
            "\t\t\t\"aggregatetimeoriginalestimate\": null,\n" +
            "\t\t\t\"versions\": [],\n" +
            "\t\t\t\"issuelinks\": [],\n" +
            "\t\t\t\"assignee\": null,\n" +
            "\t\t\t\"status\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/status/1\",\n" +
            "\t\t\t\t\"iconUrl\": \"http://sd.grupogtd.com:8080/images/icons/statuses/open.png\",\n" +
            "\t\t\t\t\"name\": \"Abierto\",\n" +
            "\t\t\t\t\"id\": \"1\",\n" +
            "\t\t\t\t\"statusCategory\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/statuscategory/2\",\n" +
            "\t\t\t\t\t\"id\": 2,\n" +
            "\t\t\t\t\t\"key\": \"new\",\n" +
            "\t\t\t\t\t\"colorName\": \"blue-gray\",\n" +
            "\t\t\t\t\t\"name\": \"To Do\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"components\": [],\n" +
            "\t\t\t\"customfield_12110\": null,\n" +
            "\t\t\t\"customfield_12112\": null,\n" +
            "\t\t\t\"customfield_10330\": null,\n" +
            "\t\t\t\"customfield_12111\": null,\n" +
            "\t\t\t\"customfield_12114\": null,\n" +
            "\t\t\t\"customfield_11300\": null,\n" +
            "\t\t\t\"customfield_12113\": null,\n" +
            "\t\t\t\"customfield_12116\": null,\n" +
            "\t\t\t\"customfield_12115\": null,\n" +
            "\t\t\t\"customfield_12107\": null,\n" +
            "\t\t\t\"customfield_10325\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10112\",\n" +
            "\t\t\t\t\"value\": \"Monitoreo/Alarmas\",\n" +
            "\t\t\t\t\"id\": \"10112\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10600\": null,\n" +
            "\t\t\t\"customfield_12106\": null,\n" +
            "\t\t\t\"customfield_10601\": null,\n" +
            "\t\t\t\"customfield_12109\": null,\n" +
            "\t\t\t\"customfield_10602\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10327\": null,\n" +
            "\t\t\t\"customfield_12108\": null,\n" +
            "\t\t\t\"customfield_10328\": [\"(CN) Sistemas Monitoreo (SER-33593)\"],\n" +
            "\t\t\t\"aggregatetimeestimate\": null,\n" +
            "\t\t\t\"customfield_10329\": [\"(CN) Zabbix (SER-33596)\"],\n" +
            "\t\t\t\"customfield_11819\": null,\n" +
            "\t\t\t\"creator\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"subtasks\": [],\n" +
            "\t\t\t\"reporter\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12101\": null,\n" +
            "\t\t\t\"customfield_12100\": null,\n" +
            "\t\t\t\"aggregateprogress\": {\n" +
            "\t\t\t\t\"progress\": 0,\n" +
            "\t\t\t\t\"total\": 0\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12103\": null,\n" +
            "\t\t\t\"customfield_10200\": \"2019-02-05T16:48:00.000-0300\",\n" +
            "\t\t\t\"customfield_12102\": null,\n" +
            "\t\t\t\"customfield_10201\": null,\n" +
            "\t\t\t\"customfield_10322\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"customfield_12105\": null,\n" +
            "\t\t\t\"customfield_12104\": null,\n" +
            "\t\t\t\"customfield_10710\": null,\n" +
            "\t\t\t\"customfield_10711\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=tbarthold\",\n" +
            "\t\t\t\t\t\"name\": \"tbarthold\",\n" +
            "\t\t\t\t\t\"key\": \"tbarthold\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"tbarthold@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=tbarthold&avatarId=10541\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Barthold, Tomas\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=pblanco\",\n" +
            "\t\t\t\t\t\"name\": \"pblanco\",\n" +
            "\t\t\t\t\t\"key\": \"pblanco\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"PBlanco@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/a2f65bf89bc86f3bb6c2bc278bc4f3b0?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/a2f65bf89bc86f3bb6c2bc278bc4f3b0?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/a2f65bf89bc86f3bb6c2bc278bc4f3b0?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/a2f65bf89bc86f3bb6c2bc278bc4f3b0?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Blanco Salinas, Pablo Andres\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Javier.Vargas\",\n" +
            "\t\t\t\t\t\"name\": \"Javier.Vargas\",\n" +
            "\t\t\t\t\t\"key\": \"javier.vargas\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Javier.Vargas@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&avatarId=10341\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Vargas Castillo, Javier Andres\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_11801\": null,\n" +
            "\t\t\t\"customfield_10712\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=tbarthold\",\n" +
            "\t\t\t\t\t\"name\": \"tbarthold\",\n" +
            "\t\t\t\t\t\"key\": \"tbarthold\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"tbarthold@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=tbarthold&avatarId=10541\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=tbarthold&avatarId=10541\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Barthold, Tomas\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Araceli.Delrio\",\n" +
            "\t\t\t\t\t\"name\": \"Araceli.Delrio\",\n" +
            "\t\t\t\t\t\"key\": \"araceli.delrio\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Araceli.Delrio@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/791d5fff096769b819e4a49adfb60e03?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/791d5fff096769b819e4a49adfb60e03?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/791d5fff096769b819e4a49adfb60e03?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/791d5fff096769b819e4a49adfb60e03?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Del Rio Lopetegui, Araceli\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Sergio.Osorio\",\n" +
            "\t\t\t\t\t\"name\": \"Sergio.Osorio\",\n" +
            "\t\t\t\t\t\"key\": \"sergio.osorio\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Sergio.Osorio@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&avatarId=10341\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&avatarId=10341\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Osorio Mardones, Sergio Andres\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=claudio.veliz\",\n" +
            "\t\t\t\t\t\"name\": \"claudio.veliz\",\n" +
            "\t\t\t\t\t\"key\": \"claudio.veliz\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"claudio.veliz@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=claudio.veliz&avatarId=10900\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Veliz Barrientos, Claudio Andres\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_11800\": null,\n" +
            "\t\t\t\"customfield_10713\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Ramiro.Avila\",\n" +
            "\t\t\t\t\t\"name\": \"Ramiro.Avila\",\n" +
            "\t\t\t\t\t\"key\": \"ramiro.avila\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Ramiro.Avila@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/36760ca0e88f55b497e7dad95a9b6e4d?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/36760ca0e88f55b497e7dad95a9b6e4d?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/36760ca0e88f55b497e7dad95a9b6e4d?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/36760ca0e88f55b497e7dad95a9b6e4d?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Avila Soto, Ramiro\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Sao_Paulo\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=jatenciobarra%40gmail.com\",\n" +
            "\t\t\t\t\t\"name\": \"jatenciobarra@gmail.com\",\n" +
            "\t\t\t\t\t\"key\": \"jatenciobarra@gmail.com\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"jatenciobarra@gmail.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?avatarId=10335\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&avatarId=10335\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&avatarId=10335\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&avatarId=10335\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Jose Luis Atencio Barra\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_10318\": [\"Centro Norte (SER-16)\"],\n" +
            "\t\t\t\"customfield_10715\": null,\n" +
            "\t\t\t\"customfield_11804\": null,\n" +
            "\t\t\t\"customfield_10717\": [\"Soporte Jira (GRES-33588)\"],\n" +
            "\t\t\t\"customfield_10718\": [\"Monitoreo y Control (GRES-8461)\"],\n" +
            "\t\t\t\"progress\": {\n" +
            "\t\t\t\t\"progress\": 0,\n" +
            "\t\t\t\t\"total\": 0\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_11809\": null,\n" +
            "\t\t\t\"worklog\": {\n" +
            "\t\t\t\t\"startAt\": 0,\n" +
            "\t\t\t\t\"maxResults\": 20,\n" +
            "\t\t\t\t\"total\": 0\n" +
            "\t\t\t},\n" +
            "\t\t\t\"issuetype\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issuetype/10002\",\n" +
            "\t\t\t\t\"id\": \"10002\",\n" +
            "\t\t\t\t\"iconUrl\": \"http://sd.grupogtd.com:8080/secure/viewavatar?size=xsmall&avatarId=10308&avatarType=issuetype\",\n" +
            "\t\t\t\t\"name\": \"Incidente\",\n" +
            "\t\t\t\t\"subtask\": false,\n" +
            "\t\t\t\t\"avatarId\": 10308\n" +
            "\t\t\t},\n" +
            "\t\t\t\"timespent\": null,\n" +
            "\t\t\t\"project\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/project/10300\",\n" +
            "\t\t\t\t\"id\": \"10300\",\n" +
            "\t\t\t\t\"key\": \"DVCOR\",\n" +
            "\t\t\t\t\"name\": \"Desarrollo COR\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/projectavatar?avatarId=10324\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/projectavatar?size=small&avatarId=10324\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/projectavatar?size=xsmall&avatarId=10324\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/projectavatar?size=medium&avatarId=10324\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_11000\": null,\n" +
            "\t\t\t\"customfield_11002\": null,\n" +
            "\t\t\t\"aggregatetimespent\": null,\n" +
            "\t\t\t\"customfield_11401\": null,\n" +
            "\t\t\t\"customfield_10312\": null,\n" +
            "\t\t\t\"customfield_11400\": null,\n" +
            "\t\t\t\"customfield_10704\": null,\n" +
            "\t\t\t\"resolutiondate\": null,\n" +
            "\t\t\t\"customfield_10707\": {\n" +
            "\t\t\t\t\"id\": \"21\",\n" +
            "\t\t\t\t\"name\": \"Tiempo en ValidaciÃ³n\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/48693/sla/21\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"workratio\": -1,\n" +
            "\t\t\t\"customfield_10709\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"watches\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/DVCOR-722/watchers\",\n" +
            "\t\t\t\t\"watchCount\": 1,\n" +
            "\t\t\t\t\"isWatching\": false\n" +
            "\t\t\t},\n" +
            "\t\t\t\"created\": \"2019-02-07T17:56:29.507-0300\",\n" +
            "\t\t\t\"customfield_10300\": {\n" +
            "\t\t\t\t\"id\": \"20\",\n" +
            "\t\t\t\t\"name\": \"Tiempo de ResoluciÃ³n\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/48693/sla/20\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ongoingCycle\": {\n" +
            "\t\t\t\t\t\"startTime\": {\n" +
            "\t\t\t\t\t\t\"iso8601\": \"2019-02-07T17:56:30-0300\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-02-07T17:56:30.904-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"07/Feb/19 17:56\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1549572990904\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"breachTime\": {\n" +
            "\t\t\t\t\t\t\"iso8601\": \"2019-02-07T21:56:30-0300\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-02-07T21:56:30.904-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"07/Feb/19 21:56\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1549587390904\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"breached\": true,\n" +
            "\t\t\t\t\t\"paused\": false,\n" +
            "\t\t\t\t\t\"withinCalendarHours\": true,\n" +
            "\t\t\t\t\t\"goalDuration\": {\n" +
            "\t\t\t\t\t\t\"millis\": 14400000,\n" +
            "\t\t\t\t\t\t\"friendly\": \"4h\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"elapsedTime\": {\n" +
            "\t\t\t\t\t\t\"millis\": 7588517428,\n" +
            "\t\t\t\t\t\t\"friendly\": \"2,107h 55m\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"remainingTime\": {\n" +
            "\t\t\t\t\t\t\"millis\": -7574117428,\n" +
            "\t\t\t\t\t\t\"friendly\": \"-2,103h 55m\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10412\": [\"(CN) Sistemas Monitoreo (SER-33593)\"],\n" +
            "\t\t\t\"customfield_10413\": [\"(CN) Zabbix (SER-33596)\"],\n" +
            "\t\t\t\"customfield_10414\": null,\n" +
            "\t\t\t\"customfield_11900\": null,\n" +
            "\t\t\t\"customfield_11902\": null,\n" +
            "\t\t\t\"customfield_11909\": null,\n" +
            "\t\t\t\"updated\": \"2019-05-06T13:51:45.063-0300\",\n" +
            "\t\t\t\"timeoriginalestimate\": null,\n" +
            "\t\t\t\"description\": null,\n" +
            "\t\t\t\"customfield_11100\": 0.0,\n" +
            "\t\t\t\"timetracking\": {},\n" +
            "\t\t\t\"customfield_10800\": [\"Lagos MuÃ±oz Leonardo Alberto (UA-27861)\", \"Lagos MuÃ±oz Leonardo Alberto (UA-54109)\"],\n" +
            "\t\t\t\"attachment\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/24619\",\n" +
            "\t\t\t\t\t\"id\": \"24619\",\n" +
            "\t\t\t\t\t\"filename\": \"participante-creator-reporter.png\",\n" +
            "\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1552308744317,\n" +
            "\t\t\t\t\t\"size\": 28745,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/24619/participante-creator-reporter.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/24619/_thumb_24619.png\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_10408\": [\"Centro Norte (SER-16)\"],\n" +
            "\t\t\t\"summary\": \"prueba creando con GR directo Monitoreo\",\n" +
            "\t\t\t\"customfield_10000\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=xpasten\",\n" +
            "\t\t\t\t\t\"name\": \"xpasten\",\n" +
            "\t\t\t\t\t\"key\": \"xpasten\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"xpasten@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/eae22efbadc7fd5be58ed733dda75d89?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/eae22efbadc7fd5be58ed733dda75d89?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/eae22efbadc7fd5be58ed733dda75d89?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/eae22efbadc7fd5be58ed733dda75d89?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Pasten Pino, Ximena Estefania\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Fguajardo\",\n" +
            "\t\t\t\t\t\"name\": \"Fguajardo\",\n" +
            "\t\t\t\t\t\"key\": \"fguajardo@grupogtd.com\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"Fguajardo@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/002fc389196d965d431c9fc8dac0d9c8?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/002fc389196d965d431c9fc8dac0d9c8?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/002fc389196d965d431c9fc8dac0d9c8?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/002fc389196d965d431c9fc8dac0d9c8?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Guajardo Rebolledo Fernando Andres\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_10001\": {\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"jiraRest\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693\",\n" +
            "\t\t\t\t\t\"web\": \"http://sd.grupogtd.com:8080/servicedesk/customer/portal/4/DVCOR-722\",\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/48693\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"requestType\": {\n" +
            "\t\t\t\t\t\"id\": \"23\",\n" +
            "\t\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/servicedesk/4/requesttype/23\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"name\": \"Incidente\",\n" +
            "\t\t\t\t\t\"description\": \"Registro y notificaciÃ³n de una interrupciÃ³n parcial, total o degradaciÃ³n de un servicio/Plataforma\",\n" +
            "\t\t\t\t\t\"serviceDeskId\": \"4\",\n" +
            "\t\t\t\t\t\"groupIds\": [\"5\"],\n" +
            "\t\t\t\t\t\"icon\": {\n" +
            "\t\t\t\t\t\t\"id\": \"10530\",\n" +
            "\t\t\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\t\t\"iconUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/viewavatar?avatarType=SD_REQTYPE&size=large&avatarId=10530\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/viewavatar?avatarType=SD_REQTYPE&size=small&avatarId=10530\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/viewavatar?avatarType=SD_REQTYPE&size=xsmall&avatarId=10530\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/viewavatar?avatarType=SD_REQTYPE&size=medium&avatarId=10530\"\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"currentStatus\": {\n" +
            "\t\t\t\t\t\"status\": \"Abierto\",\n" +
            "\t\t\t\t\t\"statusDate\": {\n" +
            "\t\t\t\t\t\t\"iso8601\": \"2019-05-06T12:51:45-0400\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-05-06T13:51:45.063-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"06/May/19 12:51\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1557161505063\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10002\": [],\n" +
            "\t\t\t\"customfield_10400\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10201\",\n" +
            "\t\t\t\t\"value\": \"Equipo Tv\",\n" +
            "\t\t\t\t\"id\": \"10201\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_11601\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12019\": null,\n" +
            "\t\t\t\"customfield_11600\": \"2019-02-20T16:49:00.000-0300\",\n" +
            "\t\t\t\"customfield_12018\": null,\n" +
            "\t\t\t\"environment\": null,\n" +
            "\t\t\t\"customfield_11603\": \"2019-02-22T16:49:00.000-0300\",\n" +
            "\t\t\t\"customfield_11602\": \"me equivoquÃ©... es la fuente de poder... hay q comprar una nueva\",\n" +
            "\t\t\t\"duedate\": null,\n" +
            "\t\t\t\"comment\": {\n" +
            "\t\t\t\t\"comments\": [{\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/88677\",\n" +
            "\t\t\t\t\t\t\"id\": \"88677\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"Hello world!\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550520511300,\n" +
            "\t\t\t\t\t\t\"updated\": 1550520511300\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/88681\",\n" +
            "\t\t\t\t\t\t\"id\": \"88681\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"otro comentario publico\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550520730400,\n" +
            "\t\t\t\t\t\t\"updated\": 1550520730400\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/90098\",\n" +
            "\t\t\t\t\t\t\"id\": \"90098\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"Otro comentario x webhooks\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550667992063,\n" +
            "\t\t\t\t\t\t\"updated\": 1550667992063\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/90114\",\n" +
            "\t\t\t\t\t\t\"id\": \"90114\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"otro\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550668515473,\n" +
            "\t\t\t\t\t\t\"updated\": 1550668515473\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/90128\",\n" +
            "\t\t\t\t\t\t\"id\": \"90128\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"3er commednt con DISABLED WebHook\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550668926153,\n" +
            "\t\t\t\t\t\t\"updated\": 1550668926153\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/90659\",\n" +
            "\t\t\t\t\t\t\"id\": \"90659\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"[Diagnostico] \\nFecha de Diagnostico: 20-02-2019 16:49\\nDiagnÃ³stico: yo creo q es el cable suelto\\nFecha Estimada de SoluciÃ³n: 21-02-2019 16:49\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550692168003,\n" +
            "\t\t\t\t\t\t\"updated\": 1550692168003\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/90661\",\n" +
            "\t\t\t\t\t\t\"id\": \"90661\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"[Diagnostico] \\nFecha de Diagnostico: 20-02-2019 16:49\\nDiagnÃ³stico: me equivoquÃ©... es la fuente de poder... hay q comprar una nueva\\nFecha Estimada de SoluciÃ³n: 22-02-2019 16:49\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550692196097,\n" +
            "\t\t\t\t\t\t\"updated\": 1550692196097\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/91589\",\n" +
            "\t\t\t\t\t\t\"id\": \"91589\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"plop\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550772082667,\n" +
            "\t\t\t\t\t\t\"updated\": 1550772082667\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/91595\",\n" +
            "\t\t\t\t\t\t\"id\": \"91595\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"plop 2\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550772340450,\n" +
            "\t\t\t\t\t\t\"updated\": 1550772340450\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/92165\",\n" +
            "\t\t\t\t\t\t\"id\": \"92165\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"ahora si???\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1550839387973,\n" +
            "\t\t\t\t\t\t\"updated\": 1550839387973\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/145103\",\n" +
            "\t\t\t\t\t\t\"id\": \"145103\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"en progreso :)\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1556131052187,\n" +
            "\t\t\t\t\t\t\"updated\": 1556131052187\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154236\",\n" +
            "\t\t\t\t\t\t\"id\": \"154236\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"Cambio de GR con Comentario de EnProgreso a Abierto\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557160574887,\n" +
            "\t\t\t\t\t\t\"updated\": 1557160574887\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154246\",\n" +
            "\t\t\t\t\t\t\"id\": \"154246\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"Cambio de GR con Comentario de Abierto a Abierto\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557160762027,\n" +
            "\t\t\t\t\t\t\"updated\": 1557160762027\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154250\",\n" +
            "\t\t\t\t\t\t\"id\": \"154250\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"empezamos\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557160970260,\n" +
            "\t\t\t\t\t\t\"updated\": 1557160970260\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154258\",\n" +
            "\t\t\t\t\t\t\"id\": \"154258\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"nuevo cambio de GR desde En Progreso a Abierto c/comment\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557161149733,\n" +
            "\t\t\t\t\t\t\"updated\": 1557161149733\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154265\",\n" +
            "\t\t\t\t\t\t\"id\": \"154265\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"Inicio progreso!\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557161450130,\n" +
            "\t\t\t\t\t\t\"updated\": 1557161450130\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154268\",\n" +
            "\t\t\t\t\t\t\"id\": \"154268\",\n" +
            "\t\t\t\t\t\t\"author\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"escalo a otro GR desde EnProg a Abierto c/comment\",\n" +
            "\t\t\t\t\t\t\"updateAuthor\": {\n" +
            "\t\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\t\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\t\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\t\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1557161505063,\n" +
            "\t\t\t\t\t\t\"updated\": 1557161505063\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"maxResults\": 17,\n" +
            "\t\t\t\t\"total\": 17,\n" +
            "\t\t\t\t\"startAt\": 0\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"comment\": {\n" +
            "\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/48693/comment/154268\",\n" +
            "\t\t\"id\": \"154268\",\n" +
            "\t\t\"author\": {\n" +
            "\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\"active\": true,\n" +
            "\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t},\n" +
            "\t\t\"body\": \"escalo a otro GR desde EnProg a Abierto c/comment\",\n" +
            "\t\t\"updateAuthor\": {\n" +
            "\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=Llagos\",\n" +
            "\t\t\t\"name\": \"Llagos\",\n" +
            "\t\t\t\"key\": \"llagos\",\n" +
            "\t\t\t\"emailAddress\": \"Llagos@grupogtd.com\",\n" +
            "\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=llagos&avatarId=10542\",\n" +
            "\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=llagos&avatarId=10542\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"displayName\": \"Lagos MuÃ±oz, Leonardo Alberto\",\n" +
            "\t\t\t\"active\": true,\n" +
            "\t\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t\t},\n" +
            "\t\t\"created\": 1557161505063,\n" +
            "\t\t\"updated\": 1557161505063\n" +
            "\t},\n" +
            "\t\"user\": {\n" +
            "\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=apiuser\",\n" +
            "\t\t\"name\": \"apiuser\",\n" +
            "\t\t\"key\": \"apiuser\",\n" +
            "\t\t\"emailAddress\": \"noreply@grupogtd.com\",\n" +
            "\t\t\"avatarUrls\": {\n" +
            "\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/9d65f3480e314d36c8bd918d54c1f475?d=mm&s=48\",\n" +
            "\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/9d65f3480e314d36c8bd918d54c1f475?d=mm&s=24\",\n" +
            "\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/9d65f3480e314d36c8bd918d54c1f475?d=mm&s=16\",\n" +
            "\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/9d65f3480e314d36c8bd918d54c1f475?d=mm&s=32\"\n" +
            "\t\t},\n" +
            "\t\t\"displayName\": \"AutomÃ¡tico\",\n" +
            "\t\t\"active\": true,\n" +
            "\t\t\"timeZone\": \"America/Asuncion\"\n" +
            "\t},\n" +
            "\t\"timestamp\": 1557161508352\n" +
            "}";
}