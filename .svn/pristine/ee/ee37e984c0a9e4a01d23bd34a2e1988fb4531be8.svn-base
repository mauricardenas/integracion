package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.ListaValoresDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ListaValorItemDTO;
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
public class ListaValoresDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("listaValoresDAOImpl")
    private ListaValoresDAO listaValoresDAO;

    @Test
    public void obtenerIdSolucion()
    {
        try
        {
            ListaValorItemDTO item = new ListaValorItemDTO(
                    "JSD_TICKET",
                    "SEGUIMIENTO_ESTADO_ESPERADO",
                    "RECLAMO_PADRE",
                    null,
                    "ACTIVO"
            );
            String valor = listaValoresDAO.obtenerValor(item);
            LOGGER.info(" valor-->" + valor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void obtenerAsunto()
    {
        try
        {
            ListaValorItemDTO item = new ListaValorItemDTO(
                    "JSD_TICKET",
                    "ASUNTO",
                    null ,
                    "ENVIAR_CORREO_ERROR_ADJUNTA_ARCHIVO",
                    "ACTIVO"
            );
            String valor = listaValoresDAO.obtenerValor(item);
            LOGGER.info(" valor-->" + valor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }


}