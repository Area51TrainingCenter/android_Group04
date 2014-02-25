package com.area51.datos;

public class Usuario {

	protected int idUsuario;
	protected String nombreUsuario;
	protected String votacion;
	protected String estado;
	
	
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	
	public Usuario(int idUsuario, String nombreUsuario, String votacion,
			String estado) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.votacion = votacion;
		this.estado = estado;
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
