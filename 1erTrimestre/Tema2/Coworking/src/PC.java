package src;

public class PC {

	private boolean estado;

	// Constructor
	public PC() {

		this.estado = false;

	}

	// M�todo que ocupa el ordenador. En caso de que se ocupe, pone su estado a true
	public void usandoPc(int idPersona) throws InterruptedException {

		synchronized (this) {
			while (this.estado) {
				this.wait();
			}
			Coworking.showMessage("La persona " + idPersona + " est� usando el PC");
			this.setEstado(true);
		}
	}

	// M�todo que desocupa el ordenador y lo notifica
	public void saliendoPc(int idPersona) {

		synchronized (this) {
			this.setEstado(false);
			Coworking.showMessage("La persona " + idPersona + " ha dejado de usar el PC");
			this.notifyAll();
		}
	}

	public void setEstado(boolean estado) {

		this.estado = estado;

	}

	// Comprueba el estado; devuelve true si est� ocupado 
	public boolean isEstado() {
		
		return estado;
		
	}

}