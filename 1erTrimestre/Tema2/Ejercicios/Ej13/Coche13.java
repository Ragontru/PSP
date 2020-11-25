package Ej13;

import java.util.Random;

public class Coche13 implements Runnable {

	Thread t;
	private Parking13 park;
	private int numCoche;
	private int turno;
	private Random rnd = new Random();
	private String tipoV = "coche";

	public Coche13(int num, Parking13 park) {
		this.park = park;
		this.numCoche = num;
		this.t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(rnd.nextInt(500));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		cogerTurno();
		try {
			entrarAlParking();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(rnd.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		salirDelParking();
	}

	private void entrarAlParking() throws InterruptedException {
		park.entrarCoche(this.numCoche, this.turno, this.tipoV);
	}

	private void salirDelParking() {
		park.salirCoche(this.numCoche);
	}

	private void cogerTurno() {
		this.turno = park.getTurnoCoche();
		System.out.println("Coche n�mero " + this.numCoche + " cogiendo el turno " + this.turno);
	}

}
