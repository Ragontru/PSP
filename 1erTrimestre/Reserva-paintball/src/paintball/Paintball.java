package paintball;

public class Paintball {

	private String usuario, tipo, dia, horario;
	private int jugadores;

	// M�todo constructor
	public Paintball(String id) {
		this.usuario = usuario;
		this.tipo = tipo;
		this.jugadores = jugadores;
	}

	// M�todo que muestra datos
	public void muestraDatos() {
		System.out.println("------Partida: " + this.getUsuario() + "------");
		System.out.println("-- Tipo de partida: " + this.getTipo() + " N� de jugadores: " + this.getJugadores());
		System.out.println("-----------------------------------------------------------------");

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getJugadores() {
		return jugadores;
	}

	public void setJugadores(int jugadores) {
		this.jugadores = jugadores;
	}
}
