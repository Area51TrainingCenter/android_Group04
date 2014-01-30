package com.area51.datos;

public class ItemLista {

	protected int idItem;
	protected String nombreItem;
	
	
	public ItemLista(int idItem, String nombreItem) {
		this.idItem = idItem;
		this.nombreItem = nombreItem;
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
	
	
	

}
