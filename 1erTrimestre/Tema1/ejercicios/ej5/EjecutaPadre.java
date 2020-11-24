package ej5;

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
