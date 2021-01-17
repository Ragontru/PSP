package tema2;

public class Bienvenida {

	boolean claseComenzada;

	public Bienvenida() {
		this.claseComenzada = false;
	}

	// Hasta que el profesor no salude no empieza la clase,
	// por lo que los alumnos esperan con un wait
	public synchronized void saludarProfesor() {
		try {
			while (claseComenzada == false) {
				wait();
			}
			System.out.println("Buenos días, profesor");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	// Cuando el profesor saluda avisa a los alumnos con un notifyAll de su llegada
	public synchronized void llegadaProfesor(String nombre) {
		System.out.println("Buenos días a todxs. Soy el profesor " + nombre);
		notifyAll();
	}
}
