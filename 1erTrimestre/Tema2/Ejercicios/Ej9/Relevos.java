package Ej9;

/*
 * Ejercicio 9: Escribe una clase llamada Relevos que simule 
 * una carrera de relevos de la siguiente forma:
 * 	� Crea 4 threads, que se quedar�n a la espera de recibir 
 * 		alguna se�al para comenzar a correr. Una vez creados 
 * 		los threads, se indicar� que comience la carrera, con 
 * 		lo que uno de los threads deber� empezar a correr.
 * 	� Cuando un thread termina de correr pone alg�n mensaje 
 * 		en pantalla y espera un par de segundos, pasando el 
 * 		testigo a otro de los hilos para que comience a correr, 
 * 		y terminando su ejecuci�n.
 * 	� Cuando el �ltimo thread termine de correr, el padre 
 * 		mostrar� un mensaje indicando que todos los hijos han 
 * 		terminado.
 * 
 * Ejemplo de ejecuci�n:
 * Todos los hilos creados.
 * Doy la salida!
 * Soy el thread 1, corriendo. . .
 * Termin�. Paso el testigo al hijo 2
 * Soy el thread 2, corriendo. . .
 * Termin�. Paso el testigo al hijo 3
 * Soy el thread 3, corriendo. . .
 * Termin�. Paso el testigo al hijo 4
 * Soy el thread 4, corriendo. . .
 * Termin�!
 * Todos los hilos terminaros.
 * 
 */

public class Relevos {

	public static void main(String[] args) throws InterruptedException {
		Relevo rel = new Relevo();
		Corredor[] corredores = new Corredor[4];
		for (int i = 0; i < corredores.length; i++) {
			corredores[i] = new Corredor(rel, i+1);
		}
		System.out.println("Todos los hilos creados");
		System.out.println("Doy la salida");
		corredores[3].start();
		corredores[2].start();
		corredores[1].start();
		corredores[0].start();
		
		for (int i = 0; i < corredores.length; i++) {
			corredores[i].join();
		}
		
		System.out.println("Todos los corredores han finalizado");
	}

}
