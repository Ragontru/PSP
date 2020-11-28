package src;

public class PC {

	private boolean estado;

	public PC() {
		this.setEstado(false);
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void usandoPc(int idPersona) throws InterruptedException {
		synchronized (this) {
			while (estado) {
				this.wait();
			}
			Coworking.showMessage("La persona " + idPersona + " está usando el PC");
			this.setEstado(true);
		}
	}

	public void saliendoPc(int idPersona) throws InterruptedException {
		synchronized (this) {
			this.setEstado(false);
			Coworking.showMessage("La persona " + idPersona + " ha dejado de usar el PC");
			this.notifyAll();
		}
	}
}