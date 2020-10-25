package paintball;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Menu
 *
 * Clase para hacer los distintos menus.
 *
 * @author Angel Mulero
 * @version 1.0
 */
public class Menu {

	private int opcion;
	private String[] opciones;

	// Constructor.
	public Menu(String[] opciones) {
		this.opciones = opciones;
		this.opcion = 0;
	}

	public int getOpcion() {
		Scanner teclado = new Scanner(System.in);
		boolean numOk = true;

		do {
			numOk = true;
			System.out.printf("Introduce una opcion [%d - %d]: ", 1, this.opciones.length);
			try {
				this.opcion = teclado.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("¡Sólo se admiten numeros!");
				teclado = new Scanner(System.in);
				numOk = false;
			}
		} while (!numOk || this.opcion < 1 || this.opcion > this.opciones.length);

		return this.opcion;
	}

	// Muestra la lista de opciones que tiene el menu.
	public void muestra() {
		int i;
		System.out.println("");
		System.out.println("/****************/   " + opciones[0] + "   /****************/");
		System.out.println("");
		for (i = 1; i < this.opciones.length; i++) {
			System.out.printf("(%2d) %s\n", i, opciones[i]);
		}
		System.out.printf("(%2d) Salir\n", i);
		System.out.println();
	}

	// Devuelve si la opcion es salirse (salir = la ultima opcion)
	public boolean seSale() {
		return this.opciones.length == this.opcion;
	}
}