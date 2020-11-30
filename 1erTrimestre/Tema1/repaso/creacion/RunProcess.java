package creacion;

/*
 * La clase que representa un proceso en Java es la clase Process. Los métodos de
 * ProcessBuilder.start() y Runtime.exec() crean un proceso nativo en el sistema 
 * operativa subyacente donde se está ejecutando la JVM y devuelven un objeto Java 
 * de la clase Process que puede ser utilizado para controlar dicho proceso.
 * 
 * 	• Process ProcessBuilder.start(). 
 * 		Inicia un nuevo proceso utilizando los atributos indicados en el objeto. El 
 * 		nuevo proceso ejecuta el comando y los argumentos indicados en el método 
 * 		command(), ejecutándose en el directorio de trabajo especificado por 
 * 		directory(), utilizando las variables de entorno definidas en Environment().
 * 
 * 	• Process Runtime.exec(String[] cmdarray, String[] envp, File dir). Ejecuta el 
 * 		commando especificado y argumentos en cmdarray en un proceso hijo 
 * 		independiente con el entorno envp y el directorio de trabajo especificado en dir.
 * 
 * Ambos métodos comprueban que el comando a ejecuta es un comando o ejecutable válido en
 * el sistema operativo subyacente sobre el que se ejecuta la JVM. El ejecutable se ha podido
 * obtener mediante la compilación de código en cualquier lenguaje de programación. Al final,
 * crear un nuevo proceso depende del sistema operativo en concreto que esté ejecutando por
 * debajo de la JVM. En este sentido, pueden ocurrir múltiples problemas, como:
 * 		- No encuentra el ejecutable debido a la ruta indicada.
 * 		- No tener permisos de ejecución.
 * 		- No ser un ejecutable válido en el sistema.
 * En la mayoría de los casos, se lanza una excepción dependiente del sistema en concreto, pero
 * siempre será una subclase de IOException.
 */

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {

		// Se comprueba si se recibe un parámetro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.err.println(-1);
		}

		// Se crea el proceso y se inicia capturando las dos excepciones necesarias
		ProcessBuilder pb = new ProcessBuilder(args);

		try {
			Process p = pb.start();
			int retorno = p.waitFor();
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException e) {
			System.err.println("Excepción de E/S");
			System.err.println(-1);
		} catch (InterruptedException e) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}

}
