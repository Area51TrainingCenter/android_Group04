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
	

	public static String VAR_VOTACION_ID = "id";
	public static String VAR_VOTACION_NOMBRE = "nombre";
	
	
}
