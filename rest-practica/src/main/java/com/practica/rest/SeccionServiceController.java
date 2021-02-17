package com.practica.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.rest.model.Producto;
import com.practica.rest.model.Seccion;

@RestController
public class SeccionServiceController {

	// Servicio de las secciones
	private static Map<String, Seccion> seccionRepo = new HashMap<>();
	static {

		Seccion carniceria = new Seccion("1", "Carniceria");
		Seccion pescaderia = new Seccion("2", "Pescaderia");
		Seccion fruteria = new Seccion("3", "Fruteria");

		seccionRepo.put(carniceria.getId(), carniceria);
		seccionRepo.put(pescaderia.getId(), pescaderia);
		seccionRepo.put(fruteria.getId(), fruteria);
	}

	// Servicio de las secciones
	private static Map<String, Producto> productoRepo = new HashMap<>();
	static {

		// Servicio de los productos
		Producto pollo = new Producto("1", "Pollo", seccionRepo.get("1"));
		Producto cerdo = new Producto("2", "Cerdo", seccionRepo.get("1"));
		Producto ternera = new Producto("3", "Ternera", seccionRepo.get("1"));
		productoRepo.put(pollo.getId(), pollo);
		productoRepo.put(cerdo.getId(), cerdo);
		productoRepo.put(ternera.getId(), ternera);

		Producto pescado = new Producto("4", "Pescado", seccionRepo.get("2"));
		Producto marisco = new Producto("5", "Marisco", seccionRepo.get("2"));
		productoRepo.put(pescado.getId(), pescado);
		productoRepo.put(marisco.getId(), marisco);

		Producto fruta = new Producto("6", "Fruta", seccionRepo.get("3"));
		Producto verdura = new Producto("7", "Verdura", seccionRepo.get("3"));
		productoRepo.put(fruta.getId(), fruta);
		productoRepo.put(verdura.getId(), verdura);
	}

	// Controladores de las secciones

	/**
	 * Método que elimina la sección
	 * 
	 * @param id
	 * @return Sección eliminada correctamente
	 */
	@DeleteMapping("/secciones/{idSec}")
	public ResponseEntity<Object> deleteSeccion(@PathVariable("idSec") String idSec) {
		seccionRepo.remove(idSec);
		return new ResponseEntity<>("La sección ha sido eliminada correctamente", HttpStatus.OK);
	}

	/**
	 * Método que modifica los datos de la sección especificada
	 * 
	 * @param id
	 * @param seccion
	 * @return Sección modificada correctamente
	 */

	@PutMapping("/secciones/{idSec}")
	public ResponseEntity<Object> updateSeccion(@PathVariable("idSec") String idSec, @RequestBody Seccion seccion) {
		seccionRepo.remove(idSec);
		seccion.setId(idSec);
		seccionRepo.put(idSec, seccion);
		return new ResponseEntity<>("La sección se ha actualizado correctamente", HttpStatus.OK);
	}

	/**
	 * Método que crea una sección nueva
	 * 
	 * @param seccion
	 * @return Sección creada correctamente
	 */
	@PostMapping("/secciones")
	public ResponseEntity<Object> createSeccion(@RequestBody Seccion seccion) {
		seccionRepo.put(seccion.getId(), seccion);
		return new ResponseEntity<>("La sección se ha creado correctamente", HttpStatus.CREATED);
	}

	/**
	 * Método que devuelve los datos de todas las secciones
	 * 
	 * @return Datos de todas las secciones
	 */
	@GetMapping("/secciones")
	public ResponseEntity<Object> getSeccion() {
		return new ResponseEntity<>(seccionRepo.values(), HttpStatus.OK);
	}

	/**
	 * Método que devuelve los datos de la sección seleccionada
	 * 
	 * @param id
	 * @return Datos de una sección específica
	 */
	@GetMapping("/secciones/{idSec}")
	public ResponseEntity<Object> getSeccionById(@PathVariable("idSec") String idSec) {
		return new ResponseEntity<>(seccionRepo.get(idSec), HttpStatus.OK);
	}

	// Controladores de los productos

	/**
	 * 
	 * @param idSec
	 * @param idProd
	 * @return Si se puede eliminar o no el producto indicado
	 */
	// FALLA ENTERO AL MOSTRAR TRAS ELIMINAR
	@DeleteMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> delete(@PathVariable("idSec") String idSec, @PathVariable("idProd") String idProd) {

		if (productoRepo.get(idProd).getSeccion().getId().equals(idSec)) {
			productoRepo.remove(idProd);
			return new ResponseEntity<>("El producto ha sido eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El producto no se ha eliminado porque no se encuentra en la sección indicada",
					HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param idSec
	 * @param idProd
	 * @param producto
	 * @return Si se actualiza o no un producto de la sección
	 */
	// FALLA ENTERO AL MOSTRAR TRAS ACTUALIZAR
	@PutMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> updateProducto(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd, @RequestBody Producto producto) {
		if (productoRepo.get(idProd).getSeccion().getId().equals(idSec)) {
			productoRepo.remove(idProd);
			producto.setId(idProd);
			productoRepo.put(idProd, producto);
			return new ResponseEntity<>("El producto se ha actualizado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					"El producto no se ha actualizado porque no se encuentra en la sección indicada",
					HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Método que crea un producto en una sección
	 * 
	 * @param idSec
	 * @param producto
	 * @return Producto creado correctamente
	 */
	// FALLA ENTERO AL MOSTRAR TRAS INSERTAR
	@PostMapping("/secciones/{idSec}/productos")
	public ResponseEntity<Object> createProducto(@PathVariable("idSec") String idSec, @RequestBody Producto producto) {
		producto.setSeccion(seccionRepo.get(idSec));
		productoRepo.put(producto.getId(), producto);
		return new ResponseEntity<>("El producto se ha creado correctamente", HttpStatus.CREATED);
	}

	/**
	 * Método que muestra los datos de todos los productos de una sección
	 * 
	 * @param idSec
	 * @return Datos de todos los productos de una sección
	 */
	@GetMapping("/secciones/{idSec}/productos")
	public ResponseEntity<Object> getProductos(@PathVariable("idSec") String idSec) {
		Map<String, Producto> productoSeccion = new HashMap<>();
		for (int id = 1; id < productoRepo.size() + 1; id++) {
			if (productoRepo.get(String.valueOf(id)).getSeccion().getId().equals(idSec)) {
				productoSeccion.put(String.valueOf(id), productoRepo.get(String.valueOf(id)));
			}
		}
		return new ResponseEntity<>(productoSeccion.values(), HttpStatus.OK);
	}

	/**
	 * Método que muestra los datos de un producto de una sección en particular
	 * 
	 * @param idSec
	 * @param idProd
	 * @return Datos de un producto específico en una sección en particular
	 */
	@GetMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> getProductoById(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd) {
		if (productoRepo.get(idProd).getSeccion().getId().equals(idSec)) {
			return new ResponseEntity<>(productoRepo.get(idProd), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					"El producto no puede ser mostrado porque no se encuentra en la sección indicada",
					HttpStatus.NOT_FOUND);
		}
	}
}
