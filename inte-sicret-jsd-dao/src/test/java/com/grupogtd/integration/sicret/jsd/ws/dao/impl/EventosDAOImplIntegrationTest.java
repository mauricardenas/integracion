package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.EventosDAO;
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
public class EventosDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("eventosDAOImpl")
    private EventosDAO eventosDAO;


    @Test
    public void insertarEvento()
    {
        try
        {
            String idComunicacion = "-4";
            String evento = "JSD_INSERTA_COMENTARIO";
            String tipoEvento = "COMENTARIO_JSD";

            eventosDAO.insertEvento(idComunicacion, evento, tipoEvento);
            LOGGER.info("Done!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

}