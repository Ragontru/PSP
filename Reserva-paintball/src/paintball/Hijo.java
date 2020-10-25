package paintball;

import java.util.ArrayList;
import java.util.Scanner;

public class Hijo {

	public static void main(String[] args) {

		ArrayList<Paintball> lista = new ArrayList<>();
		String respuesta = "";

		Scanner teclado = new Scanner(System.in);

		Menu menu = new Menu(new String[] { "Bienvenido a la central de reservas. ¿En qué puedo ayudarle?",
				"Reservar paintball", "Consultar reservas" });
		while (!menu.seSale()) {
			menu.muestra();
			switch (menu.getOpcion()) {
			case 1:
				reserva(lista);
				break;
			case 2:
				consulta(lista);
				break;
			}
		}

		if (menu.seSale()) {
			System.out.println("Gracias por su visita.");
		}

	}

	// Método para reservar una partida de paintball
	public static void reserva(ArrayList<Paintball> lista) {

		String usuario, tipo;
		int jugadores = 0;
		boolean jugbool = false;

		Scanner tecl = new Scanner(System.in);
		
		for (int i = 0; i < lista.size(); i++) {
			Menu tipos = new Menu(new String[] { "Perfecto, tenemos disponibles speedball, indoor y extremo. ¿Cuál desea?",
					"Speedball", "Indoor", "Extremo" });

			while (!tipos.seSale() || jugbool) {
				tipos.muestra();
				switch (tipos.getOpcion()) {
				case 1, 2:
					while (jugadores < 1) {
						System.out.println("¿Cuántos jugadores sois?");
						jugadores = tecl.nextInt();
					}
					if (jugadores < 1) {
						jugbool = true;
					}
					break;
				case 3:
					while (jugadores < 6 || jugadores > 30) {
						System.out.println("Esta modalidad suele jugarse en equipos de 3 a 15 jugadores, ¿cuántos sois?");
						jugadores = tecl.nextInt();
					}
					if (jugadores < 6 || jugadores > 30) {
						jugbool = true;
					}
					break;

				default:
					System.out.println("No entiendo el mensaje");
					break;
				}
			}

			if(jugbool==true) {
				lista.get(i).setUsuario(i,usuario);
				lista.get(i).setTipo(i,tipo);
				lista.get(i).setJugadores(i,jugadores);
				System.out.println("Se ha realizado la reserva correctamente. Gracias.");
			}
		}
	}

	public static void consulta(ArrayList<Paintball> lista) {
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).muestraDatos();
		}
	}

}

/*
 * String respuesta = null; String fallo = "No entiendo el mensaje"; Scanner
 * teclado = new Scanner(System.in);
 * 
 * System.out.
 * println("Bienvenido a la central de reservas. ¿En qué puedo ayudarle?");
 * 
 */