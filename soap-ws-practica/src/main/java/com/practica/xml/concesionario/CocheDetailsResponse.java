//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.02.06 a las 11:41:32 PM CET 
//


package com.practica.xml.concesionario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Coche" type="{http://www.practica.com/xml/concesionario}Coche"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "coche"
})
@XmlRootElement(name = "CocheDetailsResponse")
public class CocheDetailsResponse {

    @XmlElement(name = "Coche", required = true)
    protected Coche coche;

    /**
     * Obtiene el valor de la propiedad coche.
     * 
     * @return
     *     possible object is
     *     {@link Coche }
     *     
     */
    public Coche getCoche() {
        return coche;
    }

    /**
     * Define el valor de la propiedad coche.
     * 
     * @param value
     *     allowed object is
     *     {@link Coche }
     *     
     */
    public void setCoche(Coche value) {
        this.coche = value;
    }

}
