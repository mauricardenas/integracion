package com.grupogtd.integration.sicret.jsd.ws.dao.impl;

import com.grupogtd.integration.sicret.jsd.ws.dao.InteSicretJsdWSDAO;
import com.grupogtd.integration.sicret.jsd.ws.dto.AddCommentDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.ConfiguracionTicketDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.CorreoDTO;
import com.grupogtd.integration.sicret.jsd.ws.dto.RespuestaBusDTO;
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

import java.util.List;

import static com.grupogtd.integration.sicret.jsd.ws.constant.Constants.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/grupogtd/integration/sicret/jsd/ws/dao/context/inteSicretJsdWS-dao-context-test.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManagerSicret")
@Transactional
public class InteSicretJsdWSDAOImplIntegrationTest
{
    private static final Log LOGGER = LogFactory.getLog(InteSicretJsdWSDAOImplIntegrationTest.class);

    @Autowired
    @Qualifier("InteSicretJsdWSImpl")
    private InteSicretJsdWSDAO inteSicretJsdWSDAO;

    @Test
    public void getConfiguracionTicket()
    {
        try
        {
            String evento = "O-REVISAR_SERVICIO_TV";//O-REVISAR_SERV_TELEFONIA O-REVISAR_SERVICIO_TV OTRA_ACTIVIDAD_COR RECLAMO_PADRE

            List<ConfiguracionTicketDTO> items = inteSicretJsdWSDAO.getConfiguracionTicket(evento);
            if (items != null)
            {
                for (ConfiguracionTicketDTO item : items)
                {
                    Assert.assertNotNull(item.getRequestTypeId());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getResumen()
    {
        try
        {
            String idActvidad  = "5000811";
            String evento = "RECLAMO_PADRE";

            String item = inteSicretJsdWSDAO.getResumen(idActvidad, evento);
            LOGGER.info(item);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }
    @Test
    public void getDescripcion()
    {
        try
        {
            String idActvidad  = "5000811";
            String evento = "RECLAMO_PADRE";

            String item = inteSicretJsdWSDAO.getDescripcion(idActvidad, evento);
            LOGGER.info(item);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getObetenerConfiguracion()
    {
        try
        {
            String tipoLista  = "JSD_TICKET";
            String subtipoLista  = "TELEFONO_CALLCENTER";
            String estado = "ACTIVO";
            String telefono = inteSicretJsdWSDAO.getConfiguracion(tipoLista, subtipoLista, estado);
            LOGGER.info("telefono -> " + telefono);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getEstadoAplicacion()
    {
        try
        {
            String idApp  = "INTEG_SICRET_JSD";

            String estado = inteSicretJsdWSDAO.getEstadoValidacion(idApp);
            //TODO corregir
            Assert.assertNotNull(estado);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void insertarJsdSeguimiento()
    {
        try
        {
            RespuestaBusDTO respuesta = new RespuestaBusDTO();


            respuesta.setIssueId("12345");
            respuesta.setIssueKey("prueba");
            String idEvento ="1234";
            String evento = "RECLAMO_PADRE";

           inteSicretJsdWSDAO.insertarJsdSeguimiento(respuesta,idEvento,evento);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getUsuarioCreacion()
    {
        try
        {

            String idEvento ="876";
            String evento = "O-REVISAR SERV TELEFONIA";

            String usuario = inteSicretJsdWSDAO.getUsuarioCreacion(idEvento, evento);

            //TODO corregir
            Assert.assertNotNull(usuario);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void ModifyTicketOrigin()
    {
        try
        {
            String idEvento ="2623874";
            String issueKeyP = inteSicretJsdWSDAO.getIssueKey(idEvento);
            LOGGER.info("issueKey -> " + issueKeyP);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }
    @Test
    public void getObtenerOrigen()
    {
        try
        {
            String estado = "ACTIVO";

            //noinspection Duplicates
            String origen = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ORIGEN, estado);
            //TODO corregir
            Assert.assertNotNull(origen);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getConfiguracion()
    {
        try
        {
            //noinspection Duplicates
            String asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_CREAR_T, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_MOD_T, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_COMENTARIO, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_PROCESAR_DATA, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_ACTUALIZA_ESTADO, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_RECIBIR_INFORMACION, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ASUNTO, VALOR_VISIBLE_CORREO_ASUNTO_INSERTAR_ARCHIVO, ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_ZONA_INFORMADOR,  ESTADO_LISTA_ACTIVO);
            asunto = inteSicretJsdWSDAO.getConfiguracion(TIPO_LISTA, SUBTIPO_LISTA_INCIDENTE_MASIVO,  ESTADO_LISTA_ACTIVO);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void obtenerCorreos() {
        try {

            List<CorreoDTO> list = inteSicretJsdWSDAO.getDestinatarios(TIPO_LISTA, VALOR_VISIBLE_CORREO_ASUNTO_CREAR_T, ESTADO_LISTA_ACTIVO);
            if (!list.isEmpty())
            {
                for (CorreoDTO item : list)
                {
                    Assert.assertNotNull(item.getCorreo());
                }
                LOGGER.info(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

    @Test
    public void getComentarioAct()
    {
        try
        {
            //noinspection Duplicates
            List<AddCommentDTO> list = inteSicretJsdWSDAO.getComentarioActividad("107366031");
            if (!list.isEmpty())
            {
                for (AddCommentDTO item : list)
                {
                    Assert.assertNotNull(item.getComentario());
                }
                LOGGER.info(list);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }


    @Test
    public void getComentarioREC()
    {
        try
        {
            //noinspection Duplicates
            List<AddCommentDTO> list  = inteSicretJsdWSDAO.getComentarioReclamo("6362473");
            if (!list.isEmpty())
            {
                for (AddCommentDTO item : list)
                {
                    Assert.assertNotNull(item.getComentario());
                }
                LOGGER.info(list);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Execution Failed with exception: " + e.getMessage());
        }
    }

}