package com.practica.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.practica.xml.concesionario.Coche;

@Component
public class CocheRepository {
	private static final Map<String, Coche> coches = new HashMap<>();

	@PostConstruct
	public void initData() {

		Coche coche = new Coche();
		coche.setModelo("595 Cabrio 2016");
		coche.setPotencia(145);
		coche.setMarca("Abarth");
		coches.put(coche.getModelo(), coche);

		coche = new Coche();
		coche.setModelo("Mégane RS 2017");
		coche.setPotencia(280);
		coche.setMarca("Renault");
		coches.put(coche.getModelo(), coche);

		coche = new Coche();
		coche.setModelo("QX70 2008");
		coche.setPotencia(238);
		coche.setMarca("Infiniti");
		coches.put(coche.getModelo(), coche);

		coche = new Coche();
		coche.setModelo("Mustang Shelby 2020");
		coche.setPotencia(760);
		coche.setMarca("Ford");
		coches.put(coche.getModelo(), coche);
	}

	public Coche findCocheModelo(String modelo) {
		Assert.notNull(modelo, "El modelo no puede ser nulo");
		return coches.get(modelo);
	}

	public Coche findCocheMarca(String marca) {
		Assert.notNull(marca, "La marca no puede ser nula");
		return coches.get(marca);
	}
	
}
