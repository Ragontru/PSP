package Ej2;

public class Hilo2 implements Runnable {
	public Thread t;

	public Hilo2() {
		t = new Thread(this, "Hola");
	}

	@Override
	public void run() {
		System.out.println("Hola, soy el hilo 2");
	}
}
