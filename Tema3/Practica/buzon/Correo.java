package buzon;

public class Correo {

	String emisor;
	String receptor;
	String mensaje;

	public Correo(String emisor, String receptor, String mensaje) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.mensaje = mensaje;
	}

	public void mostrarCorreo() {
		System.out.println("Emisor: "+this.emisor+" - Mensaje:" + this.mensaje);
	}

	public String getEmisor() {
		return emisor;
	}
	
	public String getReceptor() {
		return receptor;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
