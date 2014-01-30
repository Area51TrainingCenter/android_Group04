package com.area51.datos;

public class ItemLista {

	protected int idItem;
	protected String nombreItem;
	protected String rutaImagenItem;
	protected String descripcionItem;
	
	
	
	
	
	/**
	 * @return the rutaImagenItem
	 */
	public String getRutaImagenItem() {
		return rutaImagenItem;
	}
	/**
	 * @param rutaImagenItem the rutaImagenItem to set
	 */
	public void setRutaImagenItem(String rutaImagenItem) {
		this.rutaImagenItem = rutaImagenItem;
	}
	/**
	 * @return the descripcionItem
	 */
	public String getDescripcionItem() {
		return descripcionItem;
	}
	/**
	 * @param descripcionItem the descripcionItem to set
	 */
	public void setDescripcionItem(String descripcionItem) {
		this.descripcionItem = descripcionItem;
	}
	
	/**
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	/**
	 * @return the nombreItem
	 */
	public String getNombreItem() {
		return nombreItem;
	}
	/**
	 * @param nombreItem the nombreItem to set
	 */
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	
	
	public ItemLista(int idItem, String nombreItem, String rutaImagenItem,
			String descripcionItem) {
		this.idItem = idItem;
		this.nombreItem = nombreItem;
		this.rutaImagenItem = rutaImagenItem;
		this.descripcionItem = descripcionItem;
	}
	
	
	

}
