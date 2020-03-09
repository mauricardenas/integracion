package com.grupogtd.integration.sicret.jsd.ws.constant;


public class Constants
{
    public static final String NOMBRE_PROCESO_INTE_JSD_SICRET_WS = "JSD_INTEGRACION_WS";
    public static final String NOMBRE_PROCESO_INTE_SICRET_JSD_WS = "inte-sicret-jsd-ws";


    public static final String ESTADO_APLICACION = "VIGENTE";

    //Lista de valores de configuracion
    public static final String TIPO_LISTA = "JSD_TICKET";
    public static final String SUBTIPO_LISTA_TELEFONO = "TELEFONO_CALLCENTER";
    public static final String SUBTIPO_LISTA_SERVICE_DESK_ID = "SERVICE_DESK_ID";
    public static final String SUBTIPO_LISTA_ORIGEN = "ORIGEN_TICKET";
    public static final String ESTADO_LISTA_ACTIVO = "ACTIVO";
    public static final String SUBTIPO_LISTA_CORREO_DESTINO = "ENVIAR_CORREO_ERROR";
    public static final String SUBTIPO_LISTA_ZONA_INFORMADOR = "ZONA_INFORMADOR";
    public static final String SUBTIPO_LISTA_INCIDENTE_MASIVO = "INCIDENTE_MASIVO";

    //----------------------
    public static final String SUBTIPO_LISTA_ASUNTO = "ASUNTO";

    public static final String VALOR_VISIBLE_CORREO_ASUNTO_CREAR_T = "ENVIAR_CORREO_ERROR_CREAR_TICKET";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_MOD_T = "ENVIAR_CORREO_ERROR_MODIFICAR_DATOS";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_COMENTARIO = "ENVIAR_CORREO_ERROR_ENVIAR_COMENTARIO";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_PROCESAR_DATA = "ENVIAR_CORREO_ERROR_PROCESAR_DATA";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_ACTUALIZA_ESTADO = "ENVIAR_CORREO_ERROR_ACTUALIZA_ESTADO";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_RECIBIR_INFORMACION = "ENVIAR_CORREO_ERROR_RECIBIR_INFORMACION";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_INSERTAR_ARCHIVO = "ENVIAR_CORREO_ERROR_ADJUNTA_ARCHIVO";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_INSERTA_COMENTARIO = "ENVIAR_CORREO_ERROR_INSERTA_COMENTARIO";
    public static final String VALOR_VISIBLE_CORREO_ASUNTO_GRUPO_RESOLUTOR = "ENVIAR_CORREO_ERROR_ACTUALIZA_AREARESOLU";


    //----------------------

    public static final String USUARIO_CREACION = "PRC_EVENTOS";

    public static final String TIPO_EVENTO_ACTIVIDAD = "ESTADO_JSD_ACTIVIDAD";
    public static final String TIPO_EVENTO_RECLAMO_PADRE = "ESTADO_JSD_RECLAMO";
    public static final String ESTADO_ACTIVIDAD = "CERRADA";
    public static final String SUBESTADO_ACTIVIDAD = "OK";
    public static final String CODIGO_SOLUCION = "COR-01";


    public static final String FORMATO_ARCHIVO_HTML = "CorreoErrorJSD.html";

    public static final String COMENTARIO_ACTIVIDAD = "COMENTARIO_ACTIVIDAD";
    public static final String EVENTO_RECLAMO_PADRE = "RECLAMO_PADRE";
    public static final String SICRET = "SICRET";
    public static final String SUBTIPO_LISTA_REPROCESO = "CANTIDAD_REPROCESO";
    public static final String VALOR_VISIBLE_REPROCESO = "RECIBE_INFORMACION";
    public static final String VALOR_VISIBLE_RECLAMO_PADRE = "RECLAMO_PADRE";
    public static final String VALOR_VISIBLE_ACTIVIDAD = "ACTIVIDAD";
    public static final String SUBTIPO_LISTA_SEGUIMIENTO = "SEGUIMIENTO_ESTADO_ESPERADO";
    public static final String SUBTIPO_LISTA_SEVERIDAD_RECLAMO = "SEVERIDAD_RECLAMO_PADRE";
    public static final String VALOR_VISIBLE_SEVERIDAD_RECLAMO = "Severidad 4";
    public static final String SUBTIPO_LISTA_SEVERIDAD_ACTIVIDAD = "SEVERIDAD_ACTIVIDAD";
    public static final String VALOR_VISIBLE_SEVERIDAD_ACTIVIDAD = "Severidad 5";

    //constantes consumo de alfreso client
    public static final String ALFRESCO_USUARIO_SISTEMA = "PRC_EVENTO";
    public static final String ALFRESCO_TIPO_OBJ_RECLAMO = "TICKET_PADRE";
    public static final String ALFRESCO_TIPO_OBJ_ACTIVIDAD = "ACTIVIDAD";

    private Constants()
    {
    }
}
