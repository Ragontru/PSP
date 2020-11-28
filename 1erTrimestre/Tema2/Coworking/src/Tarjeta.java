package src;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Tarjeta {

	private int idTarjeta;
	private boolean estado;

	public Tarjeta(int i) {

		this.setIdTarjeta(idTarjeta);
		this.setEstado(false);

	}

	private void setEstado(boolean b) {
		this.estado = estado;
		
	}

	private void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
		
	}
	
	public void cogerTarjeta(Persona pers) throws InterruptedException{
		
		int cantidad = 0;
		
		synchronized (this) {
			while(this.estado) {
				this.wait(200);
				cantidad++;
				
				if (cantidad==2) {
					if (pers.getTarIzq().equals(this)) {
						cantidad = 0;
						pers.getTarDer().soltarTar();
					} else {
						cantidad = 0;
						pers.getTarIzq().soltarTar();
					}
				}
				
			}
		}
	}

}
