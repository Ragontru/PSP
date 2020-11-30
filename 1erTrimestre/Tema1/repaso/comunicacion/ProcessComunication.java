package comunicacion;

/*
 * . Esta accesi�n se gestiona a trav�s de:
 * 		� La entrada est�ndar (stdin): lugar de donde el proceso lee los 
 * 		datos de entrada que requiere para su ejecuci�n. No se refiere a 
 * 		los par�metros de ejecuci�n del programa. Normalmente suele ser 
 * 		el teclado, pero podr�a recibirlos de un fichero, de la tarjeta de
 * 		red o hasta de otro proceso, entre otros sitios. La lectura de 
 * 		datos a lo largo de un programa (por ejemplo, mediante scanf en C) 
 * 		leer� los datos de su entrada est�ndar.		
 * 		� La salida est�ndar (stdout): sitio donde el proceso escribe los 
 * 		resultados que obtiene. Normalmente es la pantalla, aunque podr�a 
 * 		ser, entre otros, la impresora o hasta otro proceso que necesite 
 * 		esos datos como entrada. La escritura de datos que se realice en
 * 		un programa (por ejemplo, mediante printf en C o System.out.println 
 * 		en Java) se produce por la salida est�ndar.
 * 		� La salida de error (stderr): sitio donde el proceso env�a los 
 * 		mensajes de error. Habitualmente es el mismo que la salida est�ndar, 
 * 		pero puede especificarse que sea otro lugar, por ejemplo, un fichero 
 * 		para identificar m�s f�cilmente los errores que ocurren durante la ejecuci�n.
 * 
 * El proceso hijo creado de la clase Process no tiene interfaz de comunicaci�n, 
 * por lo que el usuario no puede comunicarse en �l directamente. Todas sus salidas 
 * y entradas de informaci�n (stdin, stdout y stderr) se redirigen al proceso padre 
 * a trav�s de los siguientes flujos de datos o streams:
 * 		� OutputStream: flujo de salida del proceso hijo. El stream est� conectado 
 * 		por un pipe a la entrada est�ndar (stdin) del proceso hijo.
 * 		� InputStream: flujo de entrada del proceso hijo. El stream est� conectado 
 * 		por un pipe a la salida est�ndar (stdout) el proceso hijo.
 * 		� ErrorStream: flujo de error del proceso hijo. El stream est� conectado 
 * 		por un pipe a la salida de error (stderr) del proceso hijo. Sin embargo, 
 * 		hay que saber que, por defecto, para la JVM, stderr est� conectado al mismo 
 * 		sitio que stdout.
 *  
 * Utilizando los streams, el proceso padre puede enviarle datos al proceso hijo 
 * y recibir los resultados de salida que este genere comprobando los errores.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessComunication {

	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder(args).start();
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		System.out.println("Salida del proceso " + Arrays.toString(args) + ":");

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

	}

}
