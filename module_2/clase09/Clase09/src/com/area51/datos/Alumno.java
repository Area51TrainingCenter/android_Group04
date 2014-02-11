package com.area51.datos;

public class Alumno {
	
	protected int idAlumno;
	protected String nombreAlumno;
	protected int edadAlumno;
	/**
	 * @return the idAlumno
	 */
	public int getIdAlumno() {
		return idAlumno;
	}
	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	/**
	 * @return the nombreAlumno
	 */
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	/**
	 * @param nombreAlumno the nombreAlumno to set
	 */
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	/**
	 * @return the edadAlumno
	 */
	public int getEdadAlumno() {
		return edadAlumno;
	}
	/**
	 * @param edadAlumno the edadAlumno to set
	 */
	public void setEdadAlumno(int edadAlumno) {
		this.edadAlumno = edadAlumno;
	}
	public Alumno(int idAlumno, String nombreAlumno, int edadAlumno) {
		this.idAlumno = idAlumno;
		this.nombreAlumno = nombreAlumno;
		this.edadAlumno = edadAlumno;
	}
	
	
	
	

}
