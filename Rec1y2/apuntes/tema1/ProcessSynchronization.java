package tema1;

import java.io.IOException;
import java.util.Arrays;

public class ProcessSynchronization {

	public static void main(String[] args) {
		
		/* Mediante waitFor() de la clase Process el padre espera bloqueado hasta que el hijo finalice su
		 * ejecuci�n, volviendo inmediatamente si el hijo ha finalizado con anterioridad o si alguien le
		 * interrumpe (en este caso se lanza la interrupci�n InterruptedException). Adem�s se puede
		 * utilizar exitValue() para obtener el valor de retorno que devolvi� un proceso hijo. El proceso hijo
		 * debe haber finalizado, si no, se lanza la excepci�n IllegalThreadStateException. 
		 */
		
		try {
			Process process = new ProcessBuilder(args).start();
			int retorno = process.waitFor();
			System.out.println("Comando "+Arrays.toString(args)+" devolvi�: "+retorno );
		} catch (IOException e) {
			System.out.println("Ocurri� un error ejecutando el comando. Descripci�n: "+e.getMessage());
		} catch (InterruptedException e) {
			System.err.println("El comando fue interrumpido. Descripci�n del error: "+e.getMessage());
			Thread.currentThread().interrupt();
		}

	}

}
