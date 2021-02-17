package com.practica.rest.model;

public class Empleado {

	String id;
	String nombre;

	// Constructores
	public Empleado() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param seccion
	 */
	public Empleado(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// Getters y setters
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
