package terminacion;

/*
 * Un proceso puede terminar de forma abrupta un proceso hijo que cre�. Para ello el proceso
 * padre puede ejecutar la operaci�n destroy. Esta operaci�n elimina el proceso hijo indicado
 * liberando sus recursos en el sistema operativo subyacente. En caso de Java, los recursos
 * correspondientes los eliminar� el garbage collector cuando considere.
 * Si no se fuerza la finalizaci�n de la ejecuci�n del proceso hijo de forma an�mala, el proceso hijo
 * realizar� su ejecuci�n completa terminando y liberando sus recursos al finalizar. Esto se produce
 * cuando el hijo realiza la operaci�n exit para finalizar su ejecuci�n.
 */

import java.io.IOException;

public class RuntimeProcess {

	public static void main(String[] args) {

		// Se comprueba si se recibe un par�metro que indique el programa a ejecutar
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
			System.err.println("Excepci�n de E/S");
			System.exit(-1);
		}

	}

}
