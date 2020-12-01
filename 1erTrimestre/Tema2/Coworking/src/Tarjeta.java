package src;

public class Tarjeta {

	private int idTarjeta;
	private boolean estado;

	// Constructor
	public Tarjeta(int idTarjeta) {

		this.idTarjeta = idTarjeta;
		this.estado = false;

	}

	// Método que una persona coge una tarjeta. Devuelve true si la coge
	public boolean cogerTarjeta() throws InterruptedException {

		synchronized (this) {
			while (this.estado) {
				this.wait(200);
				if (this.estado) {
					return false;
				}
			}

			this.setEstado(true);
			return true;

		}
	}

	// Método que suelta una tarjeta y lo notifica
	public void dejarTarjeta() {

		synchronized (this) {
			this.setEstado(false);
			this.notifyAll();
		}
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta() {
		this.idTarjeta = idTarjeta;
	}

}
