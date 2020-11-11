package Ej9;

public class Corredor extends Thread {
	private Relevo rel;
	private int num;

	public Corredor(Relevo rel, int numCorredor) {
		this.rel = rel;
		this.num = numCorredor;
	}

	public void run() {
		try {
			cogerRelevo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		darRelevo();
	}

	public synchronized void cogerRelevo() throws InterruptedException {
		rel.coger();
		System.out.println("Soy el hilo" + num + ", corriendo.");
	}

	public synchronized void darRelevo() {
		System.out.println("Terminé, pasando el relevo");
		rel.dar();
	}
}
