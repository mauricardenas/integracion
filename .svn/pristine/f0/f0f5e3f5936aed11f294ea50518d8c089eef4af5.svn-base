package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.SolucionReclamoDAO;
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
public class SolucionReclamoDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("solucionReclamoDAOImpl")
    private SolucionReclamoDAO solucionReclamoDAO;

    @Test
    public void insertarSolucionReclamo()
    {
        try
        {
            String idSolucionReclamo = "1690";
            String idReclamo = "5000066";
            String mensaje = "registro de prueba";

            solucionReclamoDAO.insertSolucionReclamo(idSolucionReclamo, idReclamo, mensaje);
            LOGGER.info("Done");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void updateReclamo()
    {
        try
        {
            String idSolucionReclamo = "3261";
            String idReclamo = "5000066";
            String mensaje = "registro de prueba";

            solucionReclamoDAO.updateReclamo(idSolucionReclamo, idReclamo, mensaje);
            LOGGER.info("Done");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }


}