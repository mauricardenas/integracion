package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.WsComunicacionDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/grupogtd/integration/sicret/jsd/ws/dao/context/inteSicretJsdWS-dao-context-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManagerSicret")
@Transactional
public class WsComunicacionDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("wsComunicacionDAOImpl")
    private WsComunicacionDAO wsComunicacionDAO;

    @Test
    public void insertarJsdComunicacion()
    {
        try
        {
            String issueKey = "DVCOR-722";

            boolean isInserted = wsComunicacionDAO.insertarJsdComunicacion(issueKey, DATA);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void obtenerIssueKey()
    {
        try
        {
            String idComunicacion ="78";

            String issueKey = wsComunicacionDAO.obtenerIssueKey(idComunicacion);
            LOGGER.info("tipo evento-->"+issueKey);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void actualizarActividad()
    {
        try
        {
            String idActividad = "2027" ;
            String estado = "CERRADO";
            String subEstado = "OK";
            wsComunicacionDAO.updateActividad(idActividad, estado, subEstado);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void obtenerData()
    {
        String idComunicacion = "1";


        try
        {
            String data = wsComunicacionDAO.getJsdRequestPayloadAsJson(idComunicacion);
            LOGGER.info("data-->" + data);
        }
        catch (Exception e)
        {

            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }

    }

    public static final String DATA = "{\n" +
            "\t\"issue\": {\n" +
            "\t\t\"id\": \"62149\",\n" +
            "\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149\",\n" +
            "\t\t\"key\": \"DVCOR-1520\",\n" +
            "\t\t\"fields\": {\n" +
            "\t\t\t\"fixVersions\": [],\n" +
            "\t\t\t\"customfield_11200\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10500\",\n" +
            "\t\t\t\t\"value\": \"Requerimiento\",\n" +
            "\t\t\t\t\"id\": \"10500\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"resolution\": null,\n" +
            "\t\t\t\"customfield_10114\": null,\n" +
            "\t\t\t\"customfield_10501\": null,\n" +
            "\t\t\t\"customfield_10502\": 0.0,\n" +
            "\t\t\t\"customfield_11834\": null,\n" +
            "\t\t\t\"customfield_11833\": null,\n" +
            "\t\t\t\"lastViewed\": null,\n" +
            "\t\t\t\"customfield_12000\": {\n" +
            "\t\t\t\t\"id\": \"28\",\n" +
            "\t\t\t\t\"name\": \"Aprobación Plataformas\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/62149/sla/28\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_12002\": null,\n" +
            "\t\t\t\"customfield_12001\": {\n" +
            "\t\t\t\t\"id\": \"29\",\n" +
            "\t\t\t\t\"name\": \"Aprobación Gestor de Cambios\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/62149/sla/29\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"priority\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/priority/10000\",\n" +
            "\t\t\t\t\"iconUrl\": \"http://sd.grupogtd.com:8080/images/icons/priorities/highest.svg\",\n" +
            "\t\t\t\t\"name\": \"Severidad 1 (3 hrs)\",\n" +
            "\t\t\t\t\"id\": \"10000\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10100\": null,\n" +
            "\t\t\t\"customfield_12004\": null,\n" +
            "\t\t\t\"customfield_10101\": null,\n" +
            "\t\t\t\"customfield_12003\": null,\n" +
            "\t\t\t\"customfield_10102\": null,\n" +
            "\t\t\t\"customfield_11820\": null,\n" +
            "\t\t\t\"timeestimate\": null,\n" +
            "\t\t\t\"aggregatetimeoriginalestimate\": null,\n" +
            "\t\t\t\"versions\": [],\n" +
            "\t\t\t\"issuelinks\": [],\n" +
            "\t\t\t\"assignee\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=claudio.veliz\",\n" +
            "\t\t\t\t\"name\": \"claudio.veliz\",\n" +
            "\t\t\t\t\"key\": \"claudio.veliz\",\n" +
            "\t\t\t\t\"emailAddress\": \"claudio.veliz@grupogtd.com\",\n" +
            "\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\"48x48\": \"http://sd.grupogtd.com:8080/secure/useravatar?ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\"24x24\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=small&ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\"16x16\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=xsmall&ownerId=claudio.veliz&avatarId=10900\",\n" +
            "\t\t\t\t\t\"32x32\": \"http://sd.grupogtd.com:8080/secure/useravatar?size=medium&ownerId=claudio.veliz&avatarId=10900\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"displayName\": \"Veliz Barrientos, Claudio Andres\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t},\n" +
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
            "\t\t\t\"customfield_10330\": null,\n" +
            "\t\t\t\"customfield_11300\": null,\n" +
            "\t\t\t\"customfield_10325\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10109\",\n" +
            "\t\t\t\t\"value\": \"Llamado Telefónico\",\n" +
            "\t\t\t\t\"id\": \"10109\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10600\": null,\n" +
            "\t\t\t\"customfield_10601\": null,\n" +
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
            "\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10327\": null,\n" +
            "\t\t\t\"customfield_10328\": [\"Jira Service Desk (SER-52461)\"],\n" +
            "\t\t\t\"aggregatetimeestimate\": null,\n" +
            "\t\t\t\"customfield_10329\": [\"Mesa COR (SER-52462)\"],\n" +
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
            "\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"aggregateprogress\": {\n" +
            "\t\t\t\t\"progress\": 0,\n" +
            "\t\t\t\t\"total\": 0\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10200\": null,\n" +
            "\t\t\t\"customfield_10201\": null,\n" +
            "\t\t\t\"customfield_10322\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"customfield_10314\": null,\n" +
            "\t\t\t\"customfield_10710\": null,\n" +
            "\t\t\t\"customfield_10711\": [{\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t}, {\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/user?username=pvalencia\",\n" +
            "\t\t\t\t\t\"name\": \"pvalencia\",\n" +
            "\t\t\t\t\t\"key\": \"pvalencia\",\n" +
            "\t\t\t\t\t\"emailAddress\": \"pvalencia@grupogtd.com\",\n" +
            "\t\t\t\t\t\"avatarUrls\": {\n" +
            "\t\t\t\t\t\t\"48x48\": \"https://www.gravatar.com/avatar/f8dd9a38586dd4b0b66fa9fed4e05596?d=mm&s=48\",\n" +
            "\t\t\t\t\t\t\"24x24\": \"https://www.gravatar.com/avatar/f8dd9a38586dd4b0b66fa9fed4e05596?d=mm&s=24\",\n" +
            "\t\t\t\t\t\t\"16x16\": \"https://www.gravatar.com/avatar/f8dd9a38586dd4b0b66fa9fed4e05596?d=mm&s=16\",\n" +
            "\t\t\t\t\t\t\"32x32\": \"https://www.gravatar.com/avatar/f8dd9a38586dd4b0b66fa9fed4e05596?d=mm&s=32\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"displayName\": \"Valencia Diaz, Pablo\",\n" +
            "\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_11801\": null,\n" +
            "\t\t\t\"customfield_10316\": null,\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_11800\": null,\n" +
            "\t\t\t\"customfield_10317\": null,\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
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
            "\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_10318\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"customfield_10715\": null,\n" +
            "\t\t\t\"customfield_11804\": null,\n" +
            "\t\t\t\"customfield_10717\": [\"Soporte Jira (GRES-33588)\"],\n" +
            "\t\t\t\"customfield_10718\": [\"Soporte Jira (GRES-33588)\"],\n" +
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
            "\t\t\t\"customfield_10703\": null,\n" +
            "\t\t\t\"customfield_10704\": null,\n" +
            "\t\t\t\"resolutiondate\": null,\n" +
            "\t\t\t\"customfield_10707\": {\n" +
            "\t\t\t\t\"id\": \"21\",\n" +
            "\t\t\t\t\"name\": \"Tiempo en Validación\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/62149/sla/21\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"workratio\": -1,\n" +
            "\t\t\t\"customfield_10709\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"watches\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/DVCOR-1520/watchers\",\n" +
            "\t\t\t\t\"watchCount\": 1,\n" +
            "\t\t\t\t\"isWatching\": false\n" +
            "\t\t\t},\n" +
            "\t\t\t\"created\": \"2019-03-27T16:31:28.893-0300\",\n" +
            "\t\t\t\"customfield_10300\": {\n" +
            "\t\t\t\t\"id\": \"20\",\n" +
            "\t\t\t\t\"name\": \"Tiempo de Resolución\",\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/62149/sla/20\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ongoingCycle\": {\n" +
            "\t\t\t\t\t\"startTime\": {\n" +
            "\t\t\t\t\t\t\"iso8601\": \"2019-03-27T16:31:30-0300\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-03-27T16:31:30.423-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"27/Mar/19 16:31\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1553715090423\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"breachTime\": {\n" +
            "\t\t\t\t\t\t\"iso8601\": \"2019-03-27T19:31:30-0300\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-03-27T19:31:30.423-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"27/Mar/19 19:31\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1553725890423\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"breached\": false,\n" +
            "\t\t\t\t\t\"paused\": false,\n" +
            "\t\t\t\t\t\"withinCalendarHours\": true,\n" +
            "\t\t\t\t\t\"goalDuration\": {\n" +
            "\t\t\t\t\t\t\"millis\": 10800000,\n" +
            "\t\t\t\t\t\t\"friendly\": \"3h\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"elapsedTime\": {\n" +
            "\t\t\t\t\t\t\"millis\": 4368693,\n" +
            "\t\t\t\t\t\t\"friendly\": \"1h 12m\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"remainingTime\": {\n" +
            "\t\t\t\t\t\t\"millis\": 6431307,\n" +
            "\t\t\t\t\t\t\"friendly\": \"1h 47m\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10412\": [\"Jira Service Desk (SER-52461)\"],\n" +
            "\t\t\t\"customfield_10413\": [\"Mesa COR (SER-52462)\"],\n" +
            "\t\t\t\"customfield_10414\": null,\n" +
            "\t\t\t\"customfield_11900\": null,\n" +
            "\t\t\t\"customfield_11902\": null,\n" +
            "\t\t\t\"customfield_11909\": null,\n" +
            "\t\t\t\"updated\": \"2019-03-27T17:44:17.703-0300\",\n" +
            "\t\t\t\"timeoriginalestimate\": null,\n" +
            "\t\t\t\"description\": \"nuevo Incidente, SIN adjuntos...\",\n" +
            "\t\t\t\"customfield_11100\": 0.0,\n" +
            "\t\t\t\"timetracking\": {},\n" +
            "\t\t\t\"customfield_10800\": [\"Lagos Muñoz Leonardo Alberto (UA-27861)\", \"Lagos Muñoz Leonardo Alberto (UA-54109)\"],\n" +
            "\t\t\t\"attachment\": [{\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27289\",\n" +
            "\t\t\t\t\t\"id\": \"27289\",\n" +
            "\t\t\t\t\t\"filename\": \"bici.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553717651073,\n" +
            "\t\t\t\t\t\"size\": 965856,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27289/bici.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27289/_thumb_27289.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27284\",\n" +
            "\t\t\t\t\t\"id\": \"27284\",\n" +
            "\t\t\t\t\t\"filename\": \"como-arreglar-una-mesa-que-cojea-655x368.jpg\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553717432240,\n" +
            "\t\t\t\t\t\"size\": 29035,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/jpeg\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27284/como-arreglar-una-mesa-que-cojea-655x368.jpg\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27284/_thumb_27284.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27299\",\n" +
            "\t\t\t\t\t\"id\": \"27299\",\n" +
            "\t\t\t\t\t\"filename\": \"EAReviewersGuide.pdf\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553719079873,\n" +
            "\t\t\t\t\t\"size\": 2958511,\n" +
            "\t\t\t\t\t\"mimeType\": \"application/pdf\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27299/EAReviewersGuide.pdf\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27300\",\n" +
            "\t\t\t\t\t\"id\": \"27300\",\n" +
            "\t\t\t\t\t\"filename\": \"image-2019-03-27-17-39-06-033.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553719146610,\n" +
            "\t\t\t\t\t\"size\": 37675,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27300/image-2019-03-27-17-39-06-033.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27300/_thumb_27300.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27302\",\n" +
            "\t\t\t\t\t\"id\": \"27302\",\n" +
            "\t\t\t\t\t\"filename\": \"image-2019-03-27-17-41-47-583.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553719308337,\n" +
            "\t\t\t\t\t\"size\": 145386,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27302/image-2019-03-27-17-41-47-583.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27302/_thumb_27302.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27306\",\n" +
            "\t\t\t\t\t\"id\": \"27306\",\n" +
            "\t\t\t\t\t\"filename\": \"image-2019-03-27-17-44-00-646.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553719441050,\n" +
            "\t\t\t\t\t\"size\": 9952,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27306/image-2019-03-27-17-44-00-646.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27306/_thumb_27306.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27307\",\n" +
            "\t\t\t\t\t\"id\": \"27307\",\n" +
            "\t\t\t\t\t\"filename\": \"image-2019-03-27-17-44-04-214.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553719444600,\n" +
            "\t\t\t\t\t\"size\": 9952,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27307/image-2019-03-27-17-44-04-214.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27307/_thumb_27307.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27286\",\n" +
            "\t\t\t\t\t\"id\": \"27286\",\n" +
            "\t\t\t\t\t\"filename\": \"Incendio-casa.jpg\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553717490773,\n" +
            "\t\t\t\t\t\"size\": 30990,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/jpeg\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27286/Incendio-casa.jpg\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27286/_thumb_27286.png\"\n" +
            "\t\t\t\t}, {\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/attachment/27288\",\n" +
            "\t\t\t\t\t\"id\": \"27288\",\n" +
            "\t\t\t\t\t\"filename\": \"useravataravatarId=10349.png\",\n" +
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
            "\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"created\": 1553717629157,\n" +
            "\t\t\t\t\t\"size\": 1815,\n" +
            "\t\t\t\t\t\"mimeType\": \"image/png\",\n" +
            "\t\t\t\t\t\"content\": \"http://sd.grupogtd.com:8080/secure/attachment/27288/useravataravatarId%3D10349.png\",\n" +
            "\t\t\t\t\t\"thumbnail\": \"http://sd.grupogtd.com:8080/secure/thumbnail/27288/_thumb_27288.png\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"customfield_10408\": [\"Transversal (SER-3695)\"],\n" +
            "\t\t\t\"summary\": \"prueba WH SIN adjuntos\",\n" +
            "\t\t\t\"customfield_10000\": [],\n" +
            "\t\t\t\"customfield_10001\": {\n" +
            "\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\"jiraRest\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149\",\n" +
            "\t\t\t\t\t\"web\": \"http://sd.grupogtd.com:8080/servicedesk/customer/portal/4/DVCOR-1520\",\n" +
            "\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/request/62149\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"requestType\": {\n" +
            "\t\t\t\t\t\"id\": \"23\",\n" +
            "\t\t\t\t\t\"_links\": {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/servicedeskapi/servicedesk/4/requesttype/23\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"name\": \"Incidente\",\n" +
            "\t\t\t\t\t\"description\": \"Registro y notificación de una interrupción parcial, total o degradación de un servicio/Plataforma\",\n" +
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
            "\t\t\t\t\t\t\"iso8601\": \"2019-03-27T16:31:28-0300\",\n" +
            "\t\t\t\t\t\t\"jira\": \"2019-03-27T16:31:28.893-0300\",\n" +
            "\t\t\t\t\t\t\"friendly\": \"27/Mar/19 16:31\",\n" +
            "\t\t\t\t\t\t\"epochMillis\": 1553715088893\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_10002\": [],\n" +
            "\t\t\t\"customfield_10400\": {\n" +
            "\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/customFieldOption/10204\",\n" +
            "\t\t\t\t\"value\": \"Otra Falla\",\n" +
            "\t\t\t\t\"id\": \"10204\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"customfield_11601\": null,\n" +
            "\t\t\t\"customfield_11600\": null,\n" +
            "\t\t\t\"environment\": null,\n" +
            "\t\t\t\"customfield_11603\": null,\n" +
            "\t\t\t\"customfield_11602\": null,\n" +
            "\t\t\t\"duedate\": null,\n" +
            "\t\t\t\"comment\": {\n" +
            "\t\t\t\t\"comments\": [{\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120006\",\n" +
            "\t\t\t\t\t\t\"id\": \"120006\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"pa'Claudio\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553715112787,\n" +
            "\t\t\t\t\t\t\"updated\": 1553715112787\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120010\",\n" +
            "\t\t\t\t\t\t\"id\": \"120010\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"cambio de prioridad\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553715205863,\n" +
            "\t\t\t\t\t\t\"updated\": 1553715205863\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120054\",\n" +
            "\t\t\t\t\t\t\"id\": \"120054\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"agrego comentario\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553717373547,\n" +
            "\t\t\t\t\t\t\"updated\": 1553717373547\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120058\",\n" +
            "\t\t\t\t\t\t\"id\": \"120058\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"!como-arreglar-una-mesa-que-cojea-655x368.jpg|thumbnail!\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553717434670,\n" +
            "\t\t\t\t\t\t\"updated\": 1553717434670\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120063\",\n" +
            "\t\t\t\t\t\t\"id\": \"120063\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"un último comentario\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553717533087,\n" +
            "\t\t\t\t\t\t\"updated\": 1553717533087\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120070\",\n" +
            "\t\t\t\t\t\t\"id\": \"120070\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"!bici.png|thumbnail!\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553717653723,\n" +
            "\t\t\t\t\t\t\"updated\": 1553717653723\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120114\",\n" +
            "\t\t\t\t\t\t\"id\": \"120114\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"[^EAReviewersGuide.pdf]\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553719084393,\n" +
            "\t\t\t\t\t\t\"updated\": 1553719084393\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120117\",\n" +
            "\t\t\t\t\t\t\"id\": \"120117\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"!image-2019-03-27-17-39-06-033.png!\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553719148607,\n" +
            "\t\t\t\t\t\t\"updated\": 1553719148607\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120121\",\n" +
            "\t\t\t\t\t\t\"id\": \"120121\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"[~claudio.veliz] [~Llagos] vean esta pantalla\\n\\n!image-2019-03-27-17-41-47-583.png!\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553719314050,\n" +
            "\t\t\t\t\t\t\"updated\": 1553719314050\n" +
            "\t\t\t\t\t}, {\n" +
            "\t\t\t\t\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120125\",\n" +
            "\t\t\t\t\t\t\"id\": \"120125\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"body\": \"!image-2019-03-27-17-44-04-214.png!\\n\\nOh la la! y entonces? \\n\\n!image-2019-03-27-17-44-00-646.png!\\n\\n'ta rara la vaina!!!!\",\n" +
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
            "\t\t\t\t\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\t\t\t\t\"active\": true,\n" +
            "\t\t\t\t\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t\"created\": 1553719457703,\n" +
            "\t\t\t\t\t\t\"updated\": 1553719457703\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t],\n" +
            "\t\t\t\t\"maxResults\": 10,\n" +
            "\t\t\t\t\"total\": 10,\n" +
            "\t\t\t\t\"startAt\": 0\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"comment\": {\n" +
            "\t\t\"self\": \"http://sd.grupogtd.com:8080/rest/api/2/issue/62149/comment/120125\",\n" +
            "\t\t\"id\": \"120125\",\n" +
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
            "\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\"active\": true,\n" +
            "\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t},\n" +
            "\t\t\"body\": \"!image-2019-03-27-17-44-04-214.png!\\n\\nOh la la! y entonces? \\n\\n!image-2019-03-27-17-44-00-646.png!\\n\\n'ta rara la vaina!!!!\",\n" +
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
            "\t\t\t\"displayName\": \"Lagos Muñoz, Leonardo Alberto\",\n" +
            "\t\t\t\"active\": true,\n" +
            "\t\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t\t},\n" +
            "\t\t\"created\": 1553719457703,\n" +
            "\t\t\"updated\": 1553719457703\n" +
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
            "\t\t\"displayName\": \"Automático\",\n" +
            "\t\t\"active\": true,\n" +
            "\t\t\"timeZone\": \"America/Santiago\"\n" +
            "\t},\n" +
            "\t\"timestamp\": 1553719459147\n" +
            "}\n";

}