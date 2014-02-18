package com.area51.datos;

public class Usuario {

	protected int idUsuario;
	protected String nombreUsuario;
	protected String votacion;
	
	
	public Usuario(int idUsuario, String nombreUsuario, String votacion) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.votacion = votacion;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
	public String getVotacion() {
		return votacion;
	}
	public void setVotacion(String votacion) {
		this.votacion = votacion;
	}
	
	
	
}
