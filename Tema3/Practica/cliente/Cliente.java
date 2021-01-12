package cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {

		boolean conectado = true;

		try {
			System.out.println("Creando socket CLIENTE");
			Socket clienteSocket = new Socket();

			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
			String mensaje;
			Scanner teclado = new Scanner(System.in);

			while (conectado) {
				mensaje = teclado.next();
				os.write(mensaje.getBytes());

				if (mensaje.equals("FIN")) {
					conectado = false;
				}

			}

			System.out.println("Mensaje enviado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
