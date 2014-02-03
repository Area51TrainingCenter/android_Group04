package com.area51.datos;

public class ItemLista {

	protected int itemId;
	protected String itemNombre;
	protected String itemApellido;
	protected String itemImagen;
	
	
	
	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}



	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	/**
	 * @return the itemNombre
	 */
	public String getItemNombre() {
		return itemNombre;
	}



	/**
	 * @param itemNombre the itemNombre to set
	 */
	public void setItemNombre(String itemNombre) {
		this.itemNombre = itemNombre;
	}



	/**
	 * @return the itemApellido
	 */
	public String getItemApellido() {
		return itemApellido;
	}



	/**
	 * @param itemApellido the itemApellido to set
	 */
	public void setItemApellido(String itemApellido) {
		this.itemApellido = itemApellido;
	}



	/**
	 * @return the itemImagen
	 */
	public String getItemImagen() {
		return itemImagen;
	}



	/**
	 * @param itemImagen the itemImagen to set
	 */
	public void setItemImagen(String itemImagen) {
		this.itemImagen = itemImagen;
	}



	public ItemLista() {
		// TODO Auto-generated constructor stub
	}



	public ItemLista(int itemId, String itemNombre, String itemApellido,
			String itemImagen) {
		this.itemId = itemId;
		this.itemNombre = itemNombre;
		this.itemApellido = itemApellido;
		this.itemImagen = itemImagen;
	}

}
