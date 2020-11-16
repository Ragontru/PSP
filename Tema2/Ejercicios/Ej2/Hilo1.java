package Ej2;

public class Hilo1 implements Runnable {
	public Thread t;

	public Hilo1() {
		t = new Thread(this, "Hola");
	}

	@Override
	public void run() {
		System.out.println("Hola, soy el hilo 1");
	}
}
