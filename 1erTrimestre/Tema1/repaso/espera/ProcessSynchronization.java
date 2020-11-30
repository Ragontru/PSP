package espera;

/*
 * Adem�s de la utilizaci�n de los flujos de datos se puede esperar por la finalizaci�n del proceso
 * hijo y obtener informaci�n de finalizaci�n mediante la operaci�n wait. Dicha operaci�n bloquea
 * al proceso padre hasta que el hijo finaliza su ejecuci�n mediante exit. Como resultado se recibe
 * la informaci�n de finalizaci�n del proceso hijo. Dicho valor de retorno se especifica mediante un
 * n�mero entero. El valor de retorno significa c�mo result� la ejecuci�n. No tiene nada que ver
 * con los mensajes que se pasan padre e hijo a trav�s de los streams. Por convenci�n se utiliza 0
 * para indicar que el hijo ha acabado de forma correcta.
 * Mediante waitFor() de la clase Process el padre espera bloqueado hasta que el hijo finalice su
 * ejecuci�n, volviendo inmediatamente si el hijo ha finalizado con anterioridad o si alguien le
 * interrumpe (en este caso se lanza la interrupci�n InterruptedException). Adem�s se puede
 * utilizar exitValue() para obtener el valor de retorno que devolvi� un proceso hijo. El proceso hijo
 * debe haber finalizado, si no, se lanza la excepci�n IllegalThreadStateException.
 */

import java.io.IOException;
import java.util.Arrays;

public class ProcessSynchronization {

	public static void main(String[] args) {

		try {
			Process p = new ProcessBuilder(args).start();
			int retorno = p.waitFor();
			System.out.println("Comando " + Arrays.toString(args) + " devolvi�: " + retorno);
		} catch (IOException e) {
			System.out.println("Ocurri� un error ejecutando el comando. Descripci�n: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("El comando fue interrumpido. Descripci�n del error: " + e.getMessage());
			Thread.currentThread().interrupt();
		}

	}

}
