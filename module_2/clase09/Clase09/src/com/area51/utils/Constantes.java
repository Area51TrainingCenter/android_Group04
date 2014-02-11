package com.area51.utils;

import java.util.ArrayList;

import com.area51.datos.Alumno;

public class Constantes {

	//Para manejo de datos
	public static ArrayList<Alumno> listaAlumnos = null;
	
	//Para manejo de SQLite
	public static String dbName = "Universidad";
	public static int dbVersion = 1;

	public static String tableName = "Alumnos";

	public static String createTableSql = "CREATE TABLE " + tableName + 
			"( idAlumno INTEGER PRIMARY KEY, " +
			"nombreAlumno TEXT, " +
			"edadAlumno INTEGER ) ";
	
	public static String dropTableSql 
	= "DROP TABLE IF EXISTS " + tableName;

	public static String deleteTableSql 
	= "DELETE FROM " + tableName;
	
	

}
