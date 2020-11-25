package Ej12;

/*
 * Ejercicio 12: Escribe una clase llamada Parking que reciba el número de plazas de parking y el
número de coches existentes en el sistema. Se deben crear tantos threads como coches haya. El
parking dispondrá de una única entrada y una única salida. En la entrada de vehículos habrá un
dispositivo de control que permita o impida el acceso de los mismos al parking, dependiendo
del estado actual del mismo (plazas de aparcamiento disponibles). Los tiempos de espera de los
vehículos dentro del parking son aleatorios. En el momento en el que un vehículo sale del
parking, notifica al dispositivo de control el número de plaza que tenía asignada y se libera la
plaza que estuviera ocupando, quedando así estas nuevamente disponibles. Un vehículo que ha
salido del parking esperará un tiempo aleatorio para volver a entrar nuevamente en el mismo.
Por tanto, los vehículos estarán entrando y saliendo indefinidamente del parking. Es importante
que se diseñe la aplicación de tal forma que se asegure que, antes o después, un vehículo que
permanece esperando a la entrada del parking entrará en el mismo (no se debe producir
inanición).
Ejemplo de ejecución:
ENTRADA: Coche 1 aparca en 0.
Plazas libres: 5
Parking: [1] [0] [0] [0] [0] [0]
ENTRADA: Coche 2 aparca en 1.
Plazas libres: 4
Parking: [1] [2] [0] [0] [0] [0]
ENTRADA: Coche 3 aparca en 2.
Plazas libres: 3
Parking: [1] [2] [3] [0] [0] [0]
SALIDA: Coche 2 saliendo.
Plazas libres: 4
Parking: [1] [0] [3] [0] [0] [0]

 */

public class Parking {


	private int turno;
	private int siguiente;
	public int[] plazas;

	public Parking(int[] plazas) {
		this.plazas = plazas;
		this.siguiente = 1;
		this.turno = 0;
	}

	public synchronized int getTurno() {
		++this.turno;
		return this.turno;
	}

	public int getSiguiente() {
		return this.siguiente;
	}

	public synchronized void entrar(int numCoche, int turno) throws InterruptedException {
		while (compruebaParking() || turno != this.siguiente) {
			wait();
		}
		boolean asignado = false;
		for (int i = 0; !asignado && i < plazas.length; i++) {
			if (plazas[i] == 0) {
				asignado = true;
				siguiente++;
				plazas[i] = numCoche;
				System.out.println("Entrada: Coche " + numCoche + " aparca en " + i);
				System.out.println("Parking: ");
				int j;
				for (j = 0; j < plazas.length - 1; j++) {
					System.out.print("[" + plazas[j] + "] ");
				}
				System.out.println("[" + plazas[j] + "]");
			}
		}

	}

	public synchronized void salir(int numCoche) {
		for (int i = 0; i < plazas.length; i++) {
			if (plazas[i] == numCoche) {
				plazas[i] = 0;
				System.out.println("Salida: Coche " + numCoche + " sale del parking");
			}
		}
		notifyAll();
	}

	private boolean compruebaParking() {
		for (int i = 0; i < plazas.length; i++) {
			if (this.plazas[i] == 0) {
				return false;
			}
		}
		return true;
	}
}
