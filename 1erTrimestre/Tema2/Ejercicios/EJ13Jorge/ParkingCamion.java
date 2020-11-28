package EJ13Jorge;

/*
 * Ejercicio 13: Escribe una clase llamada ParkingCamion que reciba el número de plazas de
parking, el número de coches y el número de caminos existentes en el sistema. Dicha clase debe
realizar lo mismo que la clase Parking pero debe permitir a su vez aparcar camiones. Mientras
un automóvil ocupa una plaza de aparcamiento, un camión ocupa dos plazas contiguas de
aparcamiento. Hay que tener especial cuidado con la inanición de camiones, que puede
producirse si están saliendo coches indefinidamente y asignando la nueva plaza a los coches que
esperan en vez de esperar a que haya un hueco para el camión (un camión solo podrá acceder
si hay, al menos, dos plazas contiguas de aparcamiento libre).
Ejemplo de ejecución:
ENTRADA: Coche 1 aparca en 0.
Plazas libres: 5
Parking: [1] [0] [0] [0] [0] [0]
ENTRADA: Camión 101 aparca en 1.
Plazas libres: 3
Parking: [1] [101] [101] [0] [0] [0]
ENTRADA: Coche 2 aparca en 3.
Plazas libres: 2
Parking: [1] [101] [101] [2] [0] [0]
SALIDA: Coche 1 saliendo.
Plazas libres 3.
Parking: [0] [101] [101] [2] [0] [0]

 */

import java.util.ArrayList;
import java.util.List;

public class ParkingCamion {
	static ArrayList<PlazaParking> plazasParking = new ArrayList<>();
	static int camionEsperando = 0; // Contador de camiones en espera
	static int cocheEsperando = 0; // Contador de coches en espera
	static final int MAX_CAMIONES = 3; // Número máximo de camiones en espera antes de activar la priorización
	static final int MAX_COCHES = 20; // Número máximo de coches en espera antes de activar la priorización

	public static void main(String[] args) {
		EntradaParking entrada = new EntradaParking();
		ArrayList<Coche> listaCoches = new ArrayList<>();
		ArrayList<Camion> listaCamiones = new ArrayList<>();

		int nPlazas = 6; // Número de plazas de aparcamiento disponibles
		int nCoches = 10; // Número de coches
		int nCamiones = 8; // Número de camiones

		// Se inicializan las variables nPlazas, nCoche y nCamiones si se reciben
		// valores en la llamada
		if (args.length == 3) {
			nPlazas = Integer.parseInt(args[0]);
			nCoches = Integer.parseInt(args[1]);
			nCamiones = Integer.parseInt(args[2]);
		}

		// Se crean las plazas de aparcamiento
		for (int i = 0; i < nPlazas; i++) {
			plazasParking.add(new PlazaParking(i + 1));
		}

		// Se muestra el parking
		mostrarParking();

		// Se lanzan los hilos coches
		for (int i = 0; i < nCoches; i++) {
			listaCoches.add(new Coche(i + 1, entrada));
			listaCoches.get(i).start(); // Se inicia el hilo
		}

		// Se lanzan los hilos camiones
		for (int i = 0; i < nCamiones; i++) {
			listaCamiones.add(new Camion(i + 100, entrada));
			listaCamiones.get(i).start(); // Se inicia el hilo
		}
	}

	public static synchronized void mostrarParking() {
		System.out.print("PARKING: ");
		for (int i = 0; i < plazasParking.size(); i++) {
			System.out.print(" [");
			if (plazasParking.get(i).isOcupado()) {
				if (plazasParking.get(i).getCamionAparcado() != null) {
					System.out.print(plazasParking.get(i).getCamionAparcado().getIdCamion());
				} else {
					System.out.print(plazasParking.get(i).getCocheAparcado().getIdCoche());
				}
			} else {
				System.out.print("0");
			}

			System.out.print("] ");
		}
		System.out.println("");
	}

	public static synchronized PlazaParking getPlazaCoche() {
		// Si hay más de MAX_CAMIONES esperando se prioriza la entrada de camiones
		if (camionEsperando <= MAX_CAMIONES) {
			// Se recorren las plazas de parking hasta encontrar una libre
			for (int i = 0; i < plazasParking.size(); i++) {
				if (!plazasParking.get(i).isOcupado()) {
					return plazasParking.get(i);
				}
			}
		} else {
			System.out.println("****PRIORIZACIÓN CAMIONES****: Se aplaza la entrada de coches");
		}

		// Si no hay ninguna plaza libre se retorna null
		return null;
	}

	public static synchronized List<PlazaParking> getPlazaCamion() {
		ArrayList<PlazaParking> plazas = new ArrayList<>();

		// Si hay más de MAX_COCHES esperando se prioriza la entrada de coches
		if (cocheEsperando <= MAX_COCHES) {
			// Se recorren las plazas de parking hasta encontrar dos libres
			for (int i = 0; i < plazasParking.size() - 1; i++) {
				if (!plazasParking.get(i).isOcupado() && !plazasParking.get(i + 1).isOcupado()) {
					plazas.add(plazasParking.get(i));
					plazas.add(plazasParking.get(i + 1));

					return plazas;
				}
			}
		} else {
			System.out.println("####PRIORIZACIÓN COCHES####: Se aplaza la entrada de camiones");
		}

		// Si no hay dos plazas libres se retorna null
		return null;
	}

	public static synchronized void showMessage(String s) {
		System.out.println(s);
	}

	public static int getCamionEsperando() {
		return camionEsperando;
	}

	public static void setCamionEsperando(int camionEsperando) {
		ParkingCamion.camionEsperando = camionEsperando;
	}

}
