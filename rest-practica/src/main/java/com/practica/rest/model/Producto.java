package com.practica.rest.model;

public class Producto {

	private String id;
	private String nombre;

	// Constructores
	public Producto() {

	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Producto(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return String.format("Producto [id=%s, nombre=%s]", id, nombre);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
