package com.area51.datos;

public class ItemGridView {

	protected long itemId;
	protected String itemNombre;
	protected int itemImagen;
	/**
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(long itemId) {
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
	 * @return the itemImagen
	 */
	public int getItemImagen() {
		return itemImagen;
	}
	/**
	 * @param itemImagen the itemImagen to set
	 */
	public void setItemImagen(int itemImagen) {
		this.itemImagen = itemImagen;
	}
	public ItemGridView(long itemId, String itemNombre, int itemImagen) {
		this.itemId = itemId;
		this.itemNombre = itemNombre;
		this.itemImagen = itemImagen;
	}
	
	
	
}
