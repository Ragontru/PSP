package ej5;

/*
 * Ejercicio 5: Escribe una clase llamada Ejecuta que reciba como argumentos el comando y las
 * opciones del comando que se quiere ejecutar. El programa debe crear un proceso hijo que
 * ejecute el comando con las opciones correspondientes mostrando un mensaje de error en el
 * caso de que no se realizase correctamente la ejecución. El padre debe esperar a que el hijo
 * termine de informar si se produjo algún anomalía en la ejecución del hijo.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EjecutaPadre {

	public static void main(String[] args) throws IOException {

		Process process = Runtime.getRuntime().exec("javac -cp src ejercicios/ej5/EjecutaHijo.java");
		Process pr = Runtime.getRuntime().exec("java -cp src ejercicios/ej5/EjecutaHijo");
		InputStream is = pr.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

}
