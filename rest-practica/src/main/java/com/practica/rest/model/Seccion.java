package com.practica.rest.model;

public class Seccion {

	private String id;
	private String nombreSeccion;

	// Constructores
	public Seccion() {

	}

	/**
	 * @param id
	 * @param nombreSeccion
	 */
	public Seccion(String id, String nombreSeccion) {
		super();
		this.id = id;
		this.nombreSeccion = nombreSeccion;
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

}
