package com.practica.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.practica.xml.concesionario.CocheMarcaDetailsRequest;
import com.practica.xml.concesionario.CocheMarcaDetailsResponse;
import com.practica.xml.concesionario.CocheModeloDetailsRequest;
import com.practica.xml.concesionario.CocheModeloDetailsResponse;
import com.practica.xml.concesionario.CochePotenciaRequest;
import com.practica.xml.concesionario.CochePotenciaResponse;

@Endpoint
public class CocheEndpoint {
	private static final String NAMESPACE_URI = "http://www.practica.com/xml/concesionario";

	private CocheRepository CocheRepository;

	@Autowired
	public CocheEndpoint(CocheRepository CocheRepository) {
		this.CocheRepository = CocheRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CocheModeloDetailsRequest")
	@ResponsePayload
	public CocheModeloDetailsResponse getCoche(@RequestPayload CocheModeloDetailsRequest request) {
		CocheModeloDetailsResponse response = new CocheModeloDetailsResponse();
		response.setCoche(CocheRepository.findCocheModelo(request.getModelo()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CocheMarcaDetailsRequest")
	@ResponsePayload
	public CocheMarcaDetailsResponse getCoche(@RequestPayload CocheMarcaDetailsRequest request) {
		CocheMarcaDetailsResponse response = new CocheMarcaDetailsResponse();
		response.setCoche(CocheRepository.findCocheMarca(request.getMarca()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CochePotenciaRequest")
	@ResponsePayload
	public CochePotenciaResponse getCoche(@RequestPayload CochePotenciaRequest request) {
		CochePotenciaResponse response = new CochePotenciaResponse();
		response.setPotencia(CocheRepository.findCocheModelo(request.getModelo()).getPotencia());

		return response;
	}
}
