package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.JsdSeguimientoDAO;
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
public class JsdSeguimientoDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("jsdSeguimientoDAOImpl")
    private JsdSeguimientoDAO jsdSeguimientoDAO;

    @Test
    public void obtenerTipoEvento()
    {
        try
        {
            String issueKey = "DVCOR-1119";

            String tipoEvento = jsdSeguimientoDAO.obtenerTipoEvento(issueKey);
            LOGGER.info("tipo evento-->" + tipoEvento);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void obtenerIdExterno()
    {
        try
        {
            String issueKey = "DVCOR-837";
            String idExterno = jsdSeguimientoDAO.obtenerIdExterno(issueKey);
            LOGGER.info("idExterno-->" + idExterno);

        } catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

        @Test
        public void existeIssueKey()
        {
            try
            {
                String issueKey = "DVCOR-837";
                boolean isIssueKey = jsdSeguimientoDAO.existeIssueKey(issueKey);
                LOGGER.info("isIssueKey-->" + isIssueKey);

            } catch (Exception e)
            {
                e.printStackTrace();
                Assert.fail("Execution Failed with exception: " + e.getMessage());
            }
        }


}