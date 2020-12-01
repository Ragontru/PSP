package src;

/*
 * Cinco personas (F0, F1, F2, F3 y F4) comparten un espacio de coworking en el que 
 * pasan gran parte de su día trabajando en sus proyectos profesionales. Comparten 
 * una mesa circular rodeada de 5 sillas, perteneciente cada una de ellas a una 
 * persona. En el centro de la mesa hay un ordenador y la mesa dispone de 5 tarjetas 
 * de acceso (0, 1, 2, 3 y 4) para poder usar el mencionado ordenador. Cuando una de 
 * las personas está pensando nuevas ideas, no interactúa con el resto de personas. 
 * Pero cuando una persona necesita usar el ordenador intenta coger las dos tarjetas 
 * que tiene a cada lado, necesarias para poder acceder y usar el equipo informático.
 * 
 * Cada persona tan solo puede coger una tarjeta en cada momento, y no puede coger 
 * una tarjeta que ya haya cogido su “vecino” de mesa. Si una persona consigue coger 
 * las dos tarjetas comienza a usar el ordenador. Cuando termina de usarlo, los deja 
 * en su sitio y se retira a pensar nuevas ideas.
 * 
 * Implementa una solución que garantice el uso concurrente del ordenador y no 
 * provoque inanición en ninguna de las personas del coworking.
 * Entrega
 * Debes generar un fichero PDF donde incluyas la ruta de GitHub donde se encuentra 
 * el proyecto Java que resuelve el enunciado anterior, y justifiques la solución 
 * realizada a nivel de diseño de clases, objetos y su interacción.
 * 
 */

public class Coworking {

	public static void main(String[] args) {

		PC pc = new PC();
		Tarjeta[] tarjetas = new Tarjeta[5];
		Persona[] personas = new Persona[5];

		// Se crean las tarjetas
		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);
		}

		// Se crean las personas
		for (int i = 0; i < personas.length-1; i++) {
			personas[i] = new Persona(i, pc, tarjetas[i], tarjetas[i+1]);
		}
		
		// La última posición debe recibir un trato aparte ya que toma la última y la primera tarjeta
		personas[4] = new Persona(4,pc,tarjetas[4],tarjetas[0]);
		
	}

	public static void showMessage(String mensaje) {
		System.out.println(mensaje);
	}

}
