package comunicacion;

/*
 * . Esta accesión se gestiona a través de:
 * 		• La entrada estándar (stdin): lugar de donde el proceso lee los 
 * 		datos de entrada que requiere para su ejecución. No se refiere a 
 * 		los parámetros de ejecución del programa. Normalmente suele ser 
 * 		el teclado, pero podría recibirlos de un fichero, de la tarjeta de
 * 		red o hasta de otro proceso, entre otros sitios. La lectura de 
 * 		datos a lo largo de un programa (por ejemplo, mediante scanf en C) 
 * 		leerá los datos de su entrada estándar.		
 * 		• La salida estándar (stdout): sitio donde el proceso escribe los 
 * 		resultados que obtiene. Normalmente es la pantalla, aunque podría 
 * 		ser, entre otros, la impresora o hasta otro proceso que necesite 
 * 		esos datos como entrada. La escritura de datos que se realice en
 * 		un programa (por ejemplo, mediante printf en C o System.out.println 
 * 		en Java) se produce por la salida estándar.
 * 		• La salida de error (stderr): sitio donde el proceso envía los 
 * 		mensajes de error. Habitualmente es el mismo que la salida estándar, 
 * 		pero puede especificarse que sea otro lugar, por ejemplo, un fichero 
 * 		para identificar más fácilmente los errores que ocurren durante la ejecución.
 * 
 * El proceso hijo creado de la clase Process no tiene interfaz de comunicación, 
 * por lo que el usuario no puede comunicarse en él directamente. Todas sus salidas 
 * y entradas de información (stdin, stdout y stderr) se redirigen al proceso padre 
 * a través de los siguientes flujos de datos o streams:
 * 		• OutputStream: flujo de salida del proceso hijo. El stream está conectado 
 * 		por un pipe a la entrada estándar (stdin) del proceso hijo.
 * 		• InputStream: flujo de entrada del proceso hijo. El stream está conectado 
 * 		por un pipe a la salida estándar (stdout) el proceso hijo.
 * 		• ErrorStream: flujo de error del proceso hijo. El stream está conectado 
 * 		por un pipe a la salida de error (stderr) del proceso hijo. Sin embargo, 
 * 		hay que saber que, por defecto, para la JVM, stderr está conectado al mismo 
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
