package paintball;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Padre {

	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder(args);
		pb.redirectErrorStream(true);
		Process p = pb.start();

		// Salida del proceso Hijo en la entrada del proceso Padre.
		InputStream outHijo = p.getInputStream();

		// Entrada del proceso Hijo en la salida del proceso Padre.
		OutputStream inHijo = p.getOutputStream();

		byte[] buffer = new byte[3000];

		while (isAlive(p)) {
			int no = outHijo.available();
			if (no > 0) {
				int n = outHijo.read(buffer, 0, Math.min(no, buffer.length));
				System.out.println(new String(buffer, 0, n));

				int ni = System.in.available();
				if (ni > 0) {
					int num = System.in.read(buffer, 0, Math.min(ni, buffer.length));
					inHijo.write(buffer, 0, num);
					inHijo.flush();
				}

				try {
					// Se le añade una pequeña pequeña pausa para que los procesos no se solapen.
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
				}
			}

			System.out.println(p.exitValue());
		}
	}

	// Método para comprobar si el proceso Hijo ha finalizado mediante un boleano.
	public static boolean isAlive(Process p) {
		try {
			p.exitValue();
			return false;
		} catch (IllegalThreadStateException e) {
			return true;
		}
	}
}
