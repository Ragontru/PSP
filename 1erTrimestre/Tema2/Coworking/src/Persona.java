package src;

import java.util.Random;

public class Persona extends Thread {

	Random r = new Random(); // Aleatorio usado para los sleep
	private PC pc;
	private Tarjeta tarIzq;
	private Tarjeta tarDer;
	private int idPersona;

	public Persona(int id, PC pc, Tarjeta tarIzquierda, Tarjeta tarDerecha) {

		this.setIdPersona(idPersona);
		this.setPc(pc);
		this.setTarIzq(tarIzquierda);
		this.setTarDer(tarDerecha);

	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public void run() {
		try {
			// Tiempo que pasa una persona pensando una nueva idea
			Coworking.showMessage("INFO: La persona "+this.getIdPersona()+" está pensando en una nueva idea");
			Thread.sleep(r.nextInt(10)*1_000L);
			

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
