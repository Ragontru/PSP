package com.practica.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.practica.xml.concesionario.CocheDetailsRequest;
import com.practica.xml.concesionario.CocheDetailsResponse;
 
@Endpoint
public class CocheEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.practica.com/xml/concesionario";
 
    private CocheRepository CocheRepository;
 
    @Autowired
    public CocheEndpoint(CocheRepository CocheRepository) {
        this.CocheRepository = CocheRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CocheDetailsRequest")
    @ResponsePayload
    public CocheDetailsResponse getCoche(@RequestPayload CocheDetailsRequest request) {
        CocheDetailsResponse response = new CocheDetailsResponse();
        response.setCoche(CocheRepository.findCoche(request.getModelo()));
 
        return response;
    }
}