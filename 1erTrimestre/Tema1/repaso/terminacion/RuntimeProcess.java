package terminacion;

/*
 * Un proceso puede terminar de forma abrupta un proceso hijo que creó. Para ello el proceso
 * padre puede ejecutar la operación destroy. Esta operación elimina el proceso hijo indicado
 * liberando sus recursos en el sistema operativo subyacente. En caso de Java, los recursos
 * correspondientes los eliminará el garbage collector cuando considere.
 * Si no se fuerza la finalización de la ejecución del proceso hijo de forma anómala, el proceso hijo
 * realizará su ejecución completa terminando y liberando sus recursos al finalizar. Esto se produce
 * cuando el hijo realiza la operación exit para finalizar su ejecución.
 */

import java.io.IOException;

public class RuntimeProcess {

	public static void main(String[] args) {

		// Se comprueba si se recibe un parámetro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.err.println(-1);
		}

		// Se crea el proceso y posteriormente se destruye
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args);
			p.destroy();
		} catch (IOException e) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		}

	}

}
