package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.BitacoraDAO;
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
public class BitacoraDAOImplIntegrationTest
{
    @Autowired
    @Qualifier("BitacoraDAO")
    private BitacoraDAO bitacoraDAO;

    @Test
    public void insertBitacoraReclamo()
    {
        String comentario = "comentario de prueba";
        String idReclamo = "5000801";


        try
        {
            bitacoraDAO.insertBitacora(comentario,idReclamo);
        }catch (Exception e)
        {

            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }

    }

}