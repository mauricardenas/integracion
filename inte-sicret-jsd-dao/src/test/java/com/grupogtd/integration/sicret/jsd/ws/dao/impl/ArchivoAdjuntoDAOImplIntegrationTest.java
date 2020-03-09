package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ArchivoAdjuntoDAO;
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

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/grupogtd/integration/sicret/jsd/ws/dao/context/inteSicretJsdWS-dao-context-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManagerSicret")
@Transactional
public class ArchivoAdjuntoDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(ArchivoAdjuntoDAOImplIntegrationTest.class);
    @Autowired
    @Qualifier("archivoAdjuntoDAOImpl")
    private ArchivoAdjuntoDAO archivoAdjuntoDAO;

    @Test
    public void hayArchivoAdjunto()
    {
        try
        {
            String idExterno = "779";
            String nombreArchivo = "auto_nuevo[1].gif";
            boolean isArchivoAdjunto = archivoAdjuntoDAO.hayArchivoAdjunto(idExterno,nombreArchivo );
            LOGGER.info("isArchivoAdjunto-->" + isArchivoAdjunto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }
}