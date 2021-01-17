package tema2;

public class HelloThreadRunnable implements Runnable {

	Thread t;

	public HelloThreadRunnable() {
		t = new Thread(this, "Nuevo thread");
		System.out.println("Creando hilo: " + t);
		t.start(); // arranca el nuevo hilo de ejecución y ejecuta el método run
	}

	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado Runnable");
		System.out.println("Hilo finalizado");
	}
}
