package Ej2;

/*
 * Ejercicio 2: Escribe una clase llamada Orden que cree dos 
 * hilos y fuerce que la escritura del segundo sea siempre 
 * anterior a la escritura por pantalla del primero.
 * 
 * Ejemplo de ejecución:
 * Hola, soy el thread número 2
 * Hola, soy el thread número 1
 */

public class Orden {
	public static void main(String[] args) {
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		h1.t.setPriority(Thread.MIN_PRIORITY);
		h2.t.setPriority(Thread.MAX_PRIORITY);
		h1.t.start();
		h2.t.start();
	}
}