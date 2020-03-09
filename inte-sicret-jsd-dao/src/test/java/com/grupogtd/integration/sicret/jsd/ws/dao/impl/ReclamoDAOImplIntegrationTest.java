package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ReclamoDAO;
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
public class ReclamoDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(ReclamoDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("reclamoDAOImpl")
    private ReclamoDAO reclamoDAO;

    @Test
    public void isReclamoPadre()
    {
        try
        {
            String idReclamo = "6135531";
            boolean isReclamoPadre = reclamoDAO.isReclamoPadre(idReclamo);
            LOGGER.info("isReclamoPadre-->" + isReclamoPadre);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }
}