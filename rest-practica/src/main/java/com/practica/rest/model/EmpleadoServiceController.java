package com.practica.rest.model;

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

@RestController
public class EmpleadoServiceController {

	// Servicio de los empleados
	private static Map<String, Empleado> empleadoRepo = new HashMap<>();
	static {

		Empleado e1 = new Empleado("1", "Carlos");
		Empleado e2 = new Empleado("2", "Luis");
		Empleado e3 = new Empleado("3", "David");

		empleadoRepo.put(e1.getId(), e1);
		empleadoRepo.put(e2.getId(), e2);
		empleadoRepo.put(e3.getId(), e3);

	}

	// Controladores de los empleados
	/**
	 * Método que elimina un empleado
	 * 
	 * @param idEmp
	 * @return Empleado eliminado correctamente
	 */
	@DeleteMapping("/empleados/{idEmp}")
	public ResponseEntity<Object> deleteEmpleado(@PathVariable("idEmp") String idEmp) {
		empleadoRepo.remove(idEmp);
		return new ResponseEntity<>("El empleado ha sido eliminado correctamente", HttpStatus.OK);
	}

	/**
	 * Método que modifica los datos del empleado especificado
	 * 
	 * @param idEmp
	 * @param emp
	 * @return Empleado modificado correctamente
	 */
	@PutMapping("/empleados/{idEmp}")
	public ResponseEntity<Object> updateEmpleado(@PathVariable("idEmp") String idEmp, @RequestBody Empleado emp) {
		empleadoRepo.remove(idEmp);
		emp.setId(idEmp);
		empleadoRepo.put(idEmp, emp);
		return new ResponseEntity<>("El empleado ha sido modificado correctamente", HttpStatus.OK);
	}

	/**
	 * Método que crea un empleado nuevo
	 * 
	 * @param emp
	 * @return Empleado creado correctamente
	 */
	@PostMapping("/empleados")
	public ResponseEntity<Object> createEmpleado(@RequestBody Empleado emp) {
		empleadoRepo.put(emp.getId(), emp);
		return new ResponseEntity<>("El empleado ha sido creado correctamente", HttpStatus.CREATED);
	}

	/**
	 * Método que devuelve los datos de todos los empleados
	 * 
	 * @return Datos de todos los empleados
	 */
	@GetMapping("/empleados")
	public ResponseEntity<Object> getEmpleado() {
		return new ResponseEntity<>(empleadoRepo.values(), HttpStatus.OK);
	}

	/**
	 * Método que devuelve los datos del empleado en concreto
	 * 
	 * @param idEmp
	 * @return Datos del empleado específico
	 */
	@GetMapping("/empleados/{idEmp}")
	public ResponseEntity<Object> getEmpleadoById(@PathVariable("idEmp") String idEmp) {
		return new ResponseEntity<>(empleadoRepo.get(idEmp), HttpStatus.OK);
	}

}
