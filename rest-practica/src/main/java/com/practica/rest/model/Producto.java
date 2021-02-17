package com.practica.rest.model;

public class Producto {

	private String id;
	private String nombre;
	private Seccion seccion;

	// Constructores
	public Producto() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param seccion
	 */
	public Producto(String id, String nombre, Seccion seccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.seccion = seccion;
	}

	// Getters y setters
	/**
	 * Devuelve el id del producto
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id del producto
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre del producto
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto
	 * 
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the seccion
	 */
	public Seccion getSeccion() {
		return seccion;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return String.format("Producto [id=%s, nombre=%s]", id, nombre);
	}

}
