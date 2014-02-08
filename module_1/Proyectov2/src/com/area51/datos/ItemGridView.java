package com.area51.datos;

public class ItemGridView {
	
	protected int gridId;
	protected String gridNombre;
	protected String gridDescripcion;
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
	 * @return the gridDescripcion
	 */
	public String getGridDescripcion() {
		return gridDescripcion;
	}
	/**
	 * @param gridDescripcion the gridDescripcion to set
	 */
	public void setGridDescripcion(String gridDescripcion) {
		this.gridDescripcion = gridDescripcion;
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
	protected int gridImagen;
	public ItemGridView(int gridId, String gridNombre, String gridDescripcion,
			int gridImagen) {
		this.gridId = gridId;
		this.gridNombre = gridNombre;
		this.gridDescripcion = gridDescripcion;
		this.gridImagen = gridImagen;
	}
	

	
	

}
