package Ej3;

/*
 * Ejercicio 3: En el siguiente ejemplo se utiliza un único 
 * semáforo con valor 1 para crear una sección crítica.
 * 
 * Sin la utilización del semáforo, o configurando el semáforo 
 * para que el acceso sea para más de un hilo, el resultado del 
 * acumulador depende de la ejecución en concreto que realicen 
 * los hijos, pudiéndose obtener resultados erróneos en algunas 
 * ocasiones. Comprueba que esto sucede modificando la 
 * configuración del semáforo y analiza a qué se debe.
 */

import java.util.concurrent.Semaphore;

public class SeccionCriticaSemaforos {
	private static Sumador sumadores[];
	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		int nSum = Integer.parseInt(args[0]);
		sumadores = new Sumador[nSum];
		for (int i = 0; i < nSum; i++) {
			sumadores[i] = new Sumador(1000, i, semaphore);
			sumadores[i].start();
		}
		for (int i = 0; i < nSum; i++) {
			try {
				sumadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Acumulador " + Acumula.acumulador);
	}

}