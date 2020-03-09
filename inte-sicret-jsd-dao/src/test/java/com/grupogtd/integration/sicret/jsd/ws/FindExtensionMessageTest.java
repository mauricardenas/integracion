package com.grupogtd.integration.sicret.jsd.ws;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class FindExtensionMessageTest
{

    private static final Log LOGGER = LogFactory.getLog(FindExtensionMessageTest.class);

    private enum AttachmentFileNameExample
    {
         T1_SIN_ESPACIOS("[^ArhivoSinEspacios.png]")
        ,T1_CON_ESPACIOS_ENTREMEDIO("[^Arhivo Con Espacios Entremedio.png]")
        ,T1_CON_ESPACIO_AL_INICIO("[^ ArhivoConEspaciosAlInicio.png]")
        ,T1_CON_ESPACIOS_AL_INICIO("[^   ArhivoConEspaciosAlInicio.png]")
        ,T1_CON_ESPACIO_AL_FINAL("[^ArhivoConEspacioAlFinal .png]")
        ,T1_CON_ESPACIOS_AL_FINAL("[^ArhivoConEspaciosAlFinal  .png]")
        ,T1_CON_ESPACIOS_AL_INICIO_MEDIO_FINAL("[^  Arhivo Con Espacios Entre  .png]")
        ,T1_CON_EXCLAMACION_ENTREMEDIO("[^ArhivoCon!ExclamacionEntre.png]")
        ,T1_CON_EXCLAMACION_FINAL("[^ArhivoConExclamacionFinal!.png]")
        ,T1_CON_EXCLAMACION_MEDIO_FINAL("[^ArhivoCon!ExclamacionFinal!.png]")
        ,T1_CON_EXCLAMACION_INICIO_MEDIO_FINAL("[^!ArhivoCon!ExclamacionFinal!.png]")

        ,T2_SIN_ESPACIOS("!ArhivoSinEspacios.png!")
        ,T2_CON_ESPACIOS_ENTREMEDIO("!Arhivo Con Espacios Entremedio.png!")
        ,T2_CON_ESPACIO_AL_INICIO("[! ArhivoConEspaciosAlInicio.png!")
        ,T2_CON_ESPACIOS_AL_INICIO("!   ArhivoConEspaciosAlInicio.png!")
        ,T2_CON_ESPACIO_AL_FINAL("!ArhivoConEspacioAlFinal .png!")
        ,T2_CON_ESPACIOS_AL_FINAL("!ArhivoConEspaciosAlFinal  .png!")
        ,T2_CON_ESPACIOS_AL_INICIO_MEDIO_FINAL("!  Arhivo Con Espacios Entre  .png!")
        ,T2_CON_EXCLAMACION_ENTREMEDIO("!ArhivoCon!ExclamacionEntre.png!")
        ,T2_CON_EXCLAMACION_FINAL("!ArhivoConExclamacionFinal!.png!")
        ,T2_CON_EXCLAMACION_MEDIO_FINAL("!ArhivoCon!ExclamacionFinal!.png!")
        ,T2_CON_EXCLAMACION_INICIO_MEDIO_FINAL("!!ArhivoCon!ExclamacionFinal!.png!")

        ,T2_CON_GUION_AL_INICIO("!-ArhivoConGuionAlInicio.png!")
        ,T2_CON_GUION_ENTREMEDIO("!ArhivoCon!Exclamacion-Guion-Entre.png!")
        ,T2_CON_GUION_AL_FINAL("!ArhivoConExclamacionFinal!.png!")

        ;


        private final String filename;

        AttachmentFileNameExample(String filename)
        {
            this.filename = filename;
        }

        public String getFilename()
        {
            return filename;
        }
    }

    private enum ExtensionType
    {
        T1("[^",".png]")
        ,T2("[^",".png|algunacosa]")
        ,T3("!",".png!")
        ,T4("!",".png|algunacosa!")
        ;
        private final String startwith;
        private final String endwith;
        ExtensionType(String startwith, String endwith)
        {
            this.startwith = startwith;
            this.endwith = endwith;
        }

        public String getStartwith()
        {
            return startwith;
        }

        public String getEndwith()
        {
            return endwith;
        }
    }
    private static final String BODY1 = "!Captura con espacios .png!  ADjunto con comentario !Captura con espacios .png|thumbnail!";
    private static final String BODY3 = "Se revisa servicio en central no estando cargado el Call-Out.\n\n!image-2019-07-02-20-34-57-135.png!";
    private static final String BODY4 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n!image-2019-07-01-19-17-57-207.png!\n\n!image-2019-07-01-19-18-31-050.png!";

    private static final String BODY2 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n!screenshot-1.png!\n\n!image-2019-06-27-12-24-00-299.png|width=794,height=461!\n Gracias!";

    @Test
    public void testFormat1()
    {
        Set<String> expectedFilenameSet = new HashSet<String>(Arrays.asList(new String[]{"screenshot-1.png", "image-2019-06-27-12-24-00-299.png"}));
        List<String> filenames = FindExtensionMessage.getFileNames(BODY2, "!", "!");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }


        LOGGER.info("====================");

    }
    private static final String BODY_FORMAT2 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n[^screenshot-1.png]\n\n[^image-2019-06-27-12-24-00-299.png|width=794,height=461]\n Gracias!";
    @Test
    public void testFormat2()
    {
        Set<String> expectedFilenameSet = new HashSet<String>(Arrays.asList(new String[]{"screenshot-1.png", "image-2019-06-27-12-24-00-299.png"}));
        List<String> filenames = FindExtensionMessage.getFileNames(BODY_FORMAT2, "[^", "]");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }
        LOGGER.info("====================");

    }
    private static final String BODY_FORMAT3 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n\n\nimage-2019-06-27-12-24-00-299.png|width=794,height=461]\n Gracias!]";
    @Test
    public void testFormat3()
    {
        Set<String> expectedFilenameSet = new HashSet<String>();
        List<String> filenames = FindExtensionMessage.getFileNames(BODY_FORMAT3, "[^", "]");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }
        LOGGER.info("====================");

    }

    private static final String BODY_FORMAT4 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n\n\n[^image-2019-06-27-12-24-00-299.png|width=794,height=461\n Gracias!";
    @Test
    public void testFormat4()
    {
        Set<String> expectedFilenameSet = new HashSet<String>();
        List<String> filenames = FindExtensionMessage.getFileNames(BODY_FORMAT4, "[^", "]");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }
        LOGGER.info("====================");

    }

    private static final String BODY_FORMAT5 = "Se revisa servicio de Telefonia!, estando registrada en ONT y central.\n\n\n\n!image-2019-06-27-12-24-00-299.png|width=794,height=461\n Gracias!";
    @Test
    public void testFormat5()
    {
        Set<String> expectedFilenameSet = new HashSet<String>();
        List<String> filenames = FindExtensionMessage.getFileNames(BODY_FORMAT5, "[^", "]");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }
        LOGGER.info("====================");
    }

    private static final String BODY_FORMAT6 = "pruea!!! !pruebasistemasSINespacio .png|thumbnail!";
    @Test
    public void testFormat6()
    {
        Set<String> expectedFilenameSet = new HashSet<String>(Arrays.asList(new String[]{"pruebasistemasSINespacio .png"}));
        List<String> filenames = FindExtensionMessage.getFileNames(BODY_FORMAT6, "!", "!");

        LOGGER.info("====================");
        for (String filename : filenames)
        {
            LOGGER.info(filename);
            assertTrue(expectedFilenameSet.contains(filename));
        }
        LOGGER.info("====================");
    }

}