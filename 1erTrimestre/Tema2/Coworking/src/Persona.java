package src;

import java.util.Random;

public class Persona implements Runnable {

	private PC pc;
	private Tarjeta tarIzq;
	private Tarjeta tarDer;
	private int idPersona;
	Thread hilo;
	Random r = new Random(); // Aleatorio usado para los sleep

	// Constructor
	public Persona(int id, PC pc, Tarjeta tarIzquierda, Tarjeta tarDerecha) {

		this.idPersona = id;
		this.tarIzq = tarIzquierda;
		this.tarDer = tarDerecha;
		this.pc = pc;
		hilo = new Thread(this);
		hilo.start();

	}

	@Override
	public void run() {

		try {
			// Tiempo que pasa una persona pensando una nueva idea
			Coworking.showMessage("("+idPersona+".1) La persona F" + idPersona + " está pensando en una nueva idea");
			Thread.sleep(r.nextInt(1000));

			Coworking.showMessage("----------------------------------------");
			Coworking.showMessage("("+idPersona+".2) Persona F" + idPersona + " cogiendo tarjetas ");
			cogerTarjetas();

			Coworking.showMessage("("+idPersona+".3) Persona F" + idPersona + " intentando entrar al pc");
			pc.usandoPc(idPersona);
			Thread.sleep(r.nextInt(500));

			this.pc.saliendoPc(idPersona);
			Coworking.showMessage("("+idPersona+".6) La persona F" + idPersona + " soltando las tarjetas");
			this.soltarTarjetas();

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	// Método para coger ambas tarjetas
	private void cogerTarjetas() throws InterruptedException {

		boolean tarIzqCogida = false;
		boolean tarDerCogida = false;

		while (!(tarDerCogida && tarIzqCogida)) {
			tarIzqCogida = tarIzq.cogerTarjeta();
			tarDerCogida = tarDer.cogerTarjeta();

			if (tarIzqCogida && !tarDerCogida) {
				tarDerCogida = tarDer.cogerTarjeta();
				if (!tarDerCogida) {
					tarIzq.dejarTarjeta();
					tarIzqCogida = false;
				}
			} else if (tarDerCogida && !tarIzqCogida) {
				tarIzqCogida = tarIzq.cogerTarjeta();
				if (!tarIzqCogida) {
					tarDer.dejarTarjeta();
					tarDerCogida = false;
				}
			}
		}

		Coworking.showMessage("INFO: La persona F" + idPersona + " ha cogido las dos tarjetas");

	}

	// Método para soltar ambas tarjetas
	private void soltarTarjetas() {

		tarIzq.dejarTarjeta();
		tarDer.dejarTarjeta();
	}

	public PC getPc() {
		return pc;
	}

	public void setPc(PC pc) {
		this.pc = pc;
	}

	public Tarjeta getTarIzq() {
		return tarIzq;
	}

	public void setTarIzq(Tarjeta tarIzq) {
		this.tarIzq = tarIzq;
	}

	public Tarjeta getTarDer() {
		return tarDer;
	}

	public void setTarDer(Tarjeta tarDer) {
		this.tarDer = tarDer;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}
