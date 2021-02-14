package com.practica.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
	public static Map<String, Producto> productoRepo = new HashMap<>();
	static {

		// Servicio de los productos
		Producto pollo = new Producto("1", "Pollo");
		Producto cerdo = new Producto("2", "Cerdo");
		Producto ternera = new Producto("3", "Ternera");
		productoRepo.put(pollo.getId(), pollo);
		productoRepo.put(cerdo.getId(), cerdo);
		productoRepo.put(ternera.getId(), ternera);

		Producto pescado = new Producto("4", "Pescado");
		Producto marisco = new Producto("5", "Marisco");
		productoRepo.put(pescado.getId(), pescado);
		productoRepo.put(marisco.getId(), marisco);

		Producto fruta = new Producto("6", "Fruta");
		Producto verdura = new Producto("7", "Verdura");
		productoRepo.put(fruta.getId(), fruta);
		productoRepo.put(verdura.getId(), verdura);
	}

	// Servicio de las secciones
	public static Map<String, Seccion> seccionRepo = new HashMap<>();
	static {

		Seccion carniceria = new Seccion("1", "Carniceria",
				Arrays.asList(productoRepo.get("1"), productoRepo.get("2"), productoRepo.get("3")));
		Seccion pescaderia = new Seccion("2", "Pescaderia",
				Arrays.asList(productoRepo.get("4"), productoRepo.get("5")));
		Seccion fruteria = new Seccion("3", "Fruteria", Arrays.asList(productoRepo.get("6"), productoRepo.get("7")));

		seccionRepo.put(carniceria.getId(), carniceria);
		seccionRepo.put(pescaderia.getId(), pescaderia);
		seccionRepo.put(fruteria.getId(), fruteria);
	}

	// Controladores de los servicios
	@DeleteMapping("/secciones/{idSec}")
	public ResponseEntity<Object> delete(@PathVariable("idSec") String id) {
		seccionRepo.remove(id);
		return new ResponseEntity<>("La sección ha sido eliminada correctamente", HttpStatus.OK);
	}

	@PutMapping("/secciones/{idSec}")
	public ResponseEntity<Object> updateSeccion(@PathVariable("idSec") String id, @RequestBody Seccion seccion) {
		seccionRepo.remove(id);
		seccion.setId(id);
		seccionRepo.put(id, seccion);
		return new ResponseEntity<>("La sección se ha actualizado correctamente", HttpStatus.OK);
	}

	@PostMapping("/secciones")
	public ResponseEntity<Object> createSeccion(@RequestBody Seccion seccion) {
		seccionRepo.put(seccion.getId(), seccion);
		return new ResponseEntity<>("La sección se ha creado correctamente", HttpStatus.CREATED);
	}

	@GetMapping("/secciones")
	public ResponseEntity<Object> getSeccion() {
		return new ResponseEntity<>(seccionRepo.values(), HttpStatus.OK);
	}

	@GetMapping("/secciones/{idSec}")
	public ResponseEntity<Object> getSeccionById(@PathVariable("idSec") String id) {
		return new ResponseEntity<>(seccionRepo.get(id), HttpStatus.OK);
	}

	// Controladores de los productos
	@DeleteMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> delete(@PathVariable("idSec") String idSec, @PathVariable("idProd") String idProd) {

		if (productoRepo.get(seccionRepo.get(idSec)).getId().equals(idProd)) {
			productoRepo.remove(idProd);
			return new ResponseEntity<>("El producto ha sido eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El producto no se ha eliminado porque no se encuentra en la sección indicada",
					HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> updateProducto(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd, @RequestBody Producto producto) {
		if (productoRepo.get(seccionRepo.get(idSec)).getId().equals(idProd)) {
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

	// FALTA
	@PostMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> createProducto(@PathVariable("idSec") String idSec, @RequestBody Producto producto) {

		/*
		 * Producto verdura = new Producto("6", "Verdura");
		 * productoRepo.put(fruta.getId(), fruta); Seccion fruteria = new
		 * Seccion("3","Fruteria", Arrays.asList(productoRepo.get("6"),
		 * productoRepo.get("7")));
		 */

		productoRepo.put(producto.getId(), producto);

		return new ResponseEntity<>("El producto se ha creado correctamente (NO COMPLETO)", HttpStatus.OK);
	}

	// FALTA
	@GetMapping("/secciones/{idSec}/productos")
	public ResponseEntity<Object> getProductos(@PathVariable("idSec") String idSec) {
		Map<String, Producto> productosSeccion = new HashMap<>();
		for (int i = 1; i <= productoRepo.size(); i++) {
			/*
			 * if () {
			 * 
			 * }
			 */
		}
		return new ResponseEntity<>("Los productos pueden ser mostrados (NO COMPLETO)", HttpStatus.OK);
		// return new ResponseEntity<>(productosSeccion.values(),HttpStatus.OK);
	}

	// FALTA
	@GetMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> getProductoById(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd) {
		if (productoRepo.get(seccionRepo.get(idSec)).getId().equals(idProd)) {
			// DEVOLVER LA ID DEL PRODUCTO
			// return new ResponseEntity<>(productoRepo.get)
			return new ResponseEntity<>("AQUÍ DEBERÍA DEVOLVER EL PRODUCTO", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					"El producto no puede ser mostrado porque no se encuentra en la sección indicada",
					HttpStatus.NOT_FOUND);
		}
	}
}
