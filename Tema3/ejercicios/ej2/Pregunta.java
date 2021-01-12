package ej2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Pregunta {

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();

			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
			byte[] buf;
			String mensaje = "";
			System.out.println(mensaje);

			while (true) {
				Scanner teclado = new Scanner(System.in);
				buf = new byte[40];
				mensaje = teclado.nextLine();
				System.out.println(mensaje + ".");
				System.out.println(new String(buf));
				mensaje = " " + mensaje;
				os.write(mensaje.getBytes());

				System.out.println("Mensaje enviado");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
