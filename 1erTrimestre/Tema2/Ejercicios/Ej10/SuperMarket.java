package Ej10;

/*
 * Ejercicio 10: Escribe una clase llamada SuperMarket que implemente el funcionamiento de N
cajas de un supermercado. Los M clientes del supermercado estar�n un tiempo aleatorio
comprando y con posterioridad seleccionar�n de forma aleatoria en qu� caja posicionarse para
situarse en su cola correspondiente. Cuando les toque el turno ser�n atendidos procediendo al
pago correspondiente e ingresando en la variable Resultados del supermercado. Se deben crear
tantos threads como clientes haya y los par�metros M y N se deben pasar como argumentos al
programa. Para simplificar la implementaci�n, el valor de pago de cada cliente puede ser
aleatorio en el momento de su pago.
 */

import java.util.ArrayList;
import java.util.Random;

public class SuperMarket {
	//Lista de cajas del supermercado
	static ArrayList<Caja10> cajas = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		//Lista de clientes qeu comprar�n en el supermercado
		Cliente10[] clientes = new Cliente10[5];
		
		//Se inicializan 2 cajas
		for (int i = 0; i < 2; i++) {
			cajas.add(new Caja10(i + 1));
		}

		//Se inicializan 5 clientes
		for (int i = 0; i < 5; i++) {
			clientes[i] = new Cliente10(i + 1);
		}

		//Se espera la finalizaci�n de todos los clientes
		for (int i = 0; i < clientes.length; i++) {
			clientes[i].getThread().join();
		}
		
		//Se meustra la cuenta de resultados
		System.out.println(Resultado10.resultado);
	}

	//M�todo para la asignaci�n aleatoria de una caja a un cliente
	public static Caja10 asignarCaja() {
		Random r = new Random();
		int random = r.nextInt(cajas.size());
		//Se incrementa la variable turno para llevar la cola ordenada de clientes
		cajas.get(random).incrementarTurno();
		return cajas.get(random);
	}

}
