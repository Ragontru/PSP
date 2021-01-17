package tema1;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {
		
		// se comprueba si recibe un par�metro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}

		/* Process ProcessBuilder.start(). 
		 * Inicia un nuevo proceso utilizando los atributos indicados en el objeto. 
		 * El nuevo proceso ejecuta el comando y los argumentos indicados en el 
		 * m�todo command(), ejecut�ndose en el directorio de trabajo especificado 
		 * por directory(), utilizando las variables de entorno definidas en Environment(). 
		 */
		
		// se crea el proceso y se inicia capturando las dos excepciones necesarias
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("La ejecuci�n de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException e) {
			System.err.println("Excepci�n de E/S");
			System.exit(-1);
		} catch (InterruptedException e) {
			System.err.println("El proceso hijo finaliz� de forma incorrecta");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}

	}

}
