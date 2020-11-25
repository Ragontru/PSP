package Ej11;

/*
 * Ejercicio 11: Escribe una clase llamada ModernSuperMarket que implemente el funcionamiento
de N cajas de supermercado. Los mismos M clientes del supermercado realizarán el mismo
proceso que en el ejercicio anterior, situándose cuando han realizado la compra, en este caso,
en una única cola. Cuando cualquier caja esté disponible, el primero de la cola será atendido en
la caja correspondiente. Calcula el tiempo medio de espera por cliente y compáralo con el
tiempo medio que se obtendría en el ejercicio anterior. ¿Cuál de las dos alternativas es más
eficiente? ¿Cuál elegirías si tú tuvieras un supermercado? Razona la respuesta.
 */

import java.util.ArrayList;

public class ModernSuperMarket {
	static ArrayList<Caja11> cajas = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		Cliente11[] clientes = new Cliente11[5];
		for (int i = 0; i < 2; i++) {
			cajas.add(new Caja11(i + 1));
		}

		for (int i = 0; i < 5; i++) {
			clientes[i] = new Cliente11(i + 1);
		}
		Thread.sleep(1000);
		System.out.println(Resultado11.resultado);
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].t.join();
		}
	}

	public synchronized static Caja11 asignarCaja(int turno) throws InterruptedException {
		boolean asignada = false;
		while (!asignada || Caja11.siguiente != turno)
			for (int i = 0; i < cajas.size() && !asignada; i++) {
				if (!cajas.get(i).isOcupado()) {
					asignada = true;
					cajas.get(i).setOcupado(true);
					Caja11.siguiente++;
					return cajas.get(i);
				}
			}
		return null;
	}
}
