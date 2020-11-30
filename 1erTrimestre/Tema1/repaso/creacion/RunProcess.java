package creacion;

/*
 * La clase que representa un proceso en Java es la clase Process. Los m�todos de
 * ProcessBuilder.start() y Runtime.exec() crean un proceso nativo en el sistema 
 * operativa subyacente donde se est� ejecutando la JVM y devuelven un objeto Java 
 * de la clase Process que puede ser utilizado para controlar dicho proceso.
 * 
 * 	� Process ProcessBuilder.start(). 
 * 		Inicia un nuevo proceso utilizando los atributos indicados en el objeto. El 
 * 		nuevo proceso ejecuta el comando y los argumentos indicados en el m�todo 
 * 		command(), ejecut�ndose en el directorio de trabajo especificado por 
 * 		directory(), utilizando las variables de entorno definidas en Environment().
 * 
 * 	� Process Runtime.exec(String[] cmdarray, String[] envp, File dir). Ejecuta el 
 * 		commando especificado y argumentos en cmdarray en un proceso hijo 
 * 		independiente con el entorno envp y el directorio de trabajo especificado en dir.
 * 
 * Ambos m�todos comprueban que el comando a ejecuta es un comando o ejecutable v�lido en
 * el sistema operativo subyacente sobre el que se ejecuta la JVM. El ejecutable se ha podido
 * obtener mediante la compilaci�n de c�digo en cualquier lenguaje de programaci�n. Al final,
 * crear un nuevo proceso depende del sistema operativo en concreto que est� ejecutando por
 * debajo de la JVM. En este sentido, pueden ocurrir m�ltiples problemas, como:
 * 		- No encuentra el ejecutable debido a la ruta indicada.
 * 		- No tener permisos de ejecuci�n.
 * 		- No ser un ejecutable v�lido en el sistema.
 * En la mayor�a de los casos, se lanza una excepci�n dependiente del sistema en concreto, pero
 * siempre ser� una subclase de IOException.
 */

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {

		// Se comprueba si se recibe un par�metro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.err.println(-1);
		}

		// Se crea el proceso y se inicia capturando las dos excepciones necesarias
		ProcessBuilder pb = new ProcessBuilder(args);

		try {
			Process p = pb.start();
			int retorno = p.waitFor();
			System.out.println("La ejecuci�n de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException e) {
			System.err.println("Excepci�n de E/S");
			System.err.println(-1);
		} catch (InterruptedException e) {
			System.err.println("El proceso hijo finaliz� de forma incorrecta");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}

}
