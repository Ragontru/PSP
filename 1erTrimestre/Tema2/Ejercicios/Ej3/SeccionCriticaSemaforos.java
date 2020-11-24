package Ej3;

/*
 * Ejercicio 3: En el siguiente ejemplo se utiliza un �nico 
 * sem�foro con valor 1 para crear una secci�n cr�tica.
 * 
 * Sin la utilizaci�n del sem�foro, o configurando el sem�foro 
 * para que el acceso sea para m�s de un hilo, el resultado del 
 * acumulador depende de la ejecuci�n en concreto que realicen 
 * los hijos, pudi�ndose obtener resultados err�neos en algunas 
 * ocasiones. Comprueba que esto sucede modificando la 
 * configuraci�n del sem�foro y analiza a qu� se debe.
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