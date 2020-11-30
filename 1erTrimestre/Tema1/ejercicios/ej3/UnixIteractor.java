package ej3;

/* Ejercicio 3: Un proceso puede esperar recibir por su entrada est�ndar los datos con los que
 * operar en un formato espec�fico. Por ejemplo, si el proceso se crea a partir de un ejecutable en
 * Unix, la comunicaci�n de datos con el mismo deber�a producirse en UTF-8. Si los datos de
 * entrada no contienen caracteres extra�os (saltos de l�nea, tildes, �, etc.), esto no suele ser
 * necesario, pero aun as� veremos c�mo puede hacerse.
 * 
 *** Ejecuta jars ***
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnixIteractor {

	public static void main(String[] command) {

		String line;

		// Preparamos el comando a ejecutar
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectErrorStream(true);

		try {
			// Se crea el nuevo proceso hijo
			Process shell = pb.start();

			// Se obtiene stdout del proceso hijo
			InputStream is = shell.getInputStream();

			// Se convierte al formato de UTF-8 al de un String de Java
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// BufferedReader br = new BufferedReader(new InputStreamReader(is, "850"));

			System.out.println("La salida del proceso hijo" + Arrays.toString(command) + ":");

			// Se muestra la salida del hijo por pantalla
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			// Cuando finaliza se cierra el descriptor de la salida del hijo
			is.close();

		} catch (IOException e) {
			System.out.println("Error ocurri� ejecutando el comando. Descripci�n: " + e.getMessage());
		}

	}

}
