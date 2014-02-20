package com.area51.utils;

import com.area51.datos.Usuario;

public class Constantes {
	
	//Variables de consulta al API
	public static String API = "http://api.segundoacosta.com/";
	public static String SECTION_LOGUEO = "logueo.php?";
	public static String SECTION_VOTACION = "votacion.php?";
	public static String SECTION_VOTACION_INGRESO = "ingreso_votacion.php?";
	public static String SECTION_VOTACION_RESULTADO = "resultado_votacion.php?";
			
	public static String VAR_USUARIO = "usuario=";
	public static String VAR_CLAVE = "clave=";
	public static String VAR_VOTACION = "votacion=";
	
	
	
	//Para las constantes de evaluacion del request

	public static String CONSTANTE_RESPUESTA = "respuesta";
	public static String CONSTANTE_RESPUESTA_VAL = "OK";
	public static String CONSTANTE_MENSAJE = "mensaje";
	public static String CONSTANTE_DATOS = "datos";
	
	//Para el objeto usuario
	public static Usuario objUsuario;
	public static String VAR_USUARIO_ID = "id";
	public static String VAR_USUARIO_NOMBRE = "usuario";
	public static String VAR_USUARIO_VOTACION = "votacion";
	public static String VAR_USUARIO_ESTADO = "estado";
	

	public static String VAR_VOTACION_ID = "id";
	public static String VAR_VOTACION_NOMBRE = "nombre";
	
	
	
	//Para verificacion de red
	public static String RED = "";
	
	
	//Para SQLite
	public static String DB_NAME = "pruebadb";
	public static int DB_VERSION = 1;
	

	public static String TABLE_USUARIO_NAME = "usuario";
	
	public static String USUARIO_ID = "id";
	public static String USUARIO_NOMBRE = "usuario";
	public static String USUARIO_ESTADO = "estado";
	public static String USUARIO_VOTACION = "votacion";
	
	public static int USUARIO_ID_INDEX = 0;
	public static int USUARIO_NOMBRE_INDEX = 1;
	public static int USUARIO_ESTADO_INDEX = 2;
	public static int USUARIO_VOTACION_INDEX = 3;
	
	
	public static String CREATE_TABLE = " CREATE TABLE " + TABLE_USUARIO_NAME +
			"( " +
			USUARIO_ID + " INT PRIMARY KEY, " +
			USUARIO_NOMBRE + " TEXT, " +
			USUARIO_ESTADO + " TEXT, " +
			USUARIO_VOTACION + " TEXT " +
			" ) ";
	
	public static String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_USUARIO_NAME;
	
	/*
	//Para la sesion del usuario

	public static String SESION_USUARIO_ID = "";
	public static String SESION_USUARIO_NOMBRE = "";
	public static String SESION_USUARIO_ESTADO = "";
	public static String SESION_USUARIO_VOTACION = "";
	*/
	
	
	
	
	
		
	
	
}
