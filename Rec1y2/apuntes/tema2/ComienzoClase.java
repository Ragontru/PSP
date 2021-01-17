package tema2;

public class ComienzoClase {

	public static void main(String[] args) {
		// Objeto compartido
		Bienvenida b = new Bienvenida();

		int nAlumnos = Integer.parseInt(args[0]);
		for (int i = 0; i < nAlumnos; i++) {
			new Alumno(b).start();
		}

		Profesor profesor = new Profesor("Jorge Rodríguez", b);
		profesor.start();

	}

}
