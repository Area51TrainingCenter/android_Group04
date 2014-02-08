package com.area51.datos;

public class ItemGridView {

	protected int gridId;
	protected String gridNombre;
	protected int gridImagen;
	
	
	/**
	 * @return the gridId
	 */
	public int getGridId() {
		return gridId;
	}


	/**
	 * @param gridId the gridId to set
	 */
	public void setGridId(int gridId) {
		this.gridId = gridId;
	}


	/**
	 * @return the gridNombre
	 */
	public String getGridNombre() {
		return gridNombre;
	}


	/**
	 * @param gridNombre the gridNombre to set
	 */
	public void setGridNombre(String gridNombre) {
		this.gridNombre = gridNombre;
	}


	/**
	 * @return the gridImagen
	 */
	public int getGridImagen() {
		return gridImagen;
	}


	/**
	 * @param gridImagen the gridImagen to set
	 */
	public void setGridImagen(int gridImagen) {
		this.gridImagen = gridImagen;
	}

	public ItemGridView(int gridId, String gridNombre, int gridImagen) {
		this.gridId = gridId;
		this.gridNombre = gridNombre;
		this.gridImagen = gridImagen;
	}

}
