package espera;

/*
 * Además de la utilización de los flujos de datos se puede esperar por la finalización del proceso
 * hijo y obtener información de finalización mediante la operación wait. Dicha operación bloquea
 * al proceso padre hasta que el hijo finaliza su ejecución mediante exit. Como resultado se recibe
 * la información de finalización del proceso hijo. Dicho valor de retorno se especifica mediante un
 * número entero. El valor de retorno significa cómo resultó la ejecución. No tiene nada que ver
 * con los mensajes que se pasan padre e hijo a través de los streams. Por convención se utiliza 0
 * para indicar que el hijo ha acabado de forma correcta.
 * Mediante waitFor() de la clase Process el padre espera bloqueado hasta que el hijo finalice su
 * ejecución, volviendo inmediatamente si el hijo ha finalizado con anterioridad o si alguien le
 * interrumpe (en este caso se lanza la interrupción InterruptedException). Además se puede
 * utilizar exitValue() para obtener el valor de retorno que devolvió un proceso hijo. El proceso hijo
 * debe haber finalizado, si no, se lanza la excepción IllegalThreadStateException.
 */

import java.io.IOException;
import java.util.Arrays;

public class ProcessSynchronization {

	public static void main(String[] args) {

		try {
			Process p = new ProcessBuilder(args).start();
			int retorno = p.waitFor();
			System.out.println("Comando " + Arrays.toString(args) + " devolvió: " + retorno);
		} catch (IOException e) {
			System.out.println("Ocurrió un error ejecutando el comando. Descripción: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("El comando fue interrumpido. Descripción del error: " + e.getMessage());
			Thread.currentThread().interrupt();
		}

	}

}
