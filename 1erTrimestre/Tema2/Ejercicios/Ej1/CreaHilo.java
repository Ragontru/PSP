package Ej1;

/*
 * Ejercicio 1: Crea un hilo que realice el c�lculo de los 
 * primeros N n�mero de la sucesi�n de Fibonacci. La sucesi�n de 
 * Fibonacci comienza con los n�meros 1 y 1, y el siguiente 
 * elemento es la suma de los dos elementos anteriores. As� la 
 * sucesi�n de Fibonacci ser�a 1, 1, 2, 3, 5, 8, 13, 21, 34, 55� 
 * El par�metro N ser� indicado cuando se llame al constructor de 
 * la clase Thread correspondiente.
 * 
 */
public class CreaHilo {

	public static void main(String[] args) {
		new Fibonacci(8);
	}

}
