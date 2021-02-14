package com.practica.rest.model;

import java.util.List;

public class Seccion {

	private String id;
	private String nombreSeccion;
	private List<Producto> productos;

	// Constructores
	public Seccion() {

	}

	/**
	 * @param id
	 * @param nombreSeccion
	 * @param productos
	 */
	public Seccion(String id, String nombreSeccion, List<Producto> productos) {
		super();
		this.id = id;
		this.nombreSeccion = nombreSeccion;
		this.productos = productos;
	}

	// Getters y setters
	/**
	 * Devuelve el id de la sección del supermercado
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id de la sección del supermercado
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la sección del supermercado
	 * 
	 * @return the nombreSeccion
	 */
	public String getNombreSeccion() {
		return nombreSeccion;
	}

	/**
	 * Establece el nombre de la sección del supermercado
	 * 
	 * @param nombreSeccion the nombreSeccion to set
	 */
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	/**
	 * Devuelve la lista de productos de la sección
	 * 
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * Establece la lista de productos de la sección
	 * 
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return String.format("Seccion [id=%s, nombre=_%s, productos=%s", id, nombreSeccion, productos);
	}
}
