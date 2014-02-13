package com.area51.utils;

import java.util.ArrayList;

import com.area51.datos.Alumno;

public class Constantes {

	//Para manejo de datos
	public static ArrayList<Alumno> listaAlumnos = null;
	
	//Para manejo de SQLite
	public static String dbName = "Universidad3";
	public static int dbVersion = 1;

	public static String colIdAlumno = "idAlumno";
	public static String colNombreAlumno = "nombreAlumno";
	public static String colEdadAlumno = "edadAlumno";
	
	
	
	public static int colIdAlumno_index = 0;
	public static int colNombreAlumno_index = 1;
	public static int colEdadAlumno_index = 2;
	

	public static String tableName = "Alumnos";

	public static String createTableSql = "CREATE TABLE " + tableName + 
			"( "+colIdAlumno+" INT PRIMARY KEY, " +
			""+ colNombreAlumno + " TEXT, " +
			""+ colEdadAlumno + " INT ) ";
	
	public static String dropTableSql 
	= "DROP TABLE IF EXISTS " + tableName;

	public static String deleteTableSql 
	= "DELETE FROM " + tableName;
	
	

}
