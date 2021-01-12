package ej5;

/*
 * Ejercicio 5: Escribe un programa que cuente el número de conexiones que vaya recibiendo. 
 * Este programa dispondrá de un socket stream servidor. Cada vez que un socket cliente se 
 * conecte, este le enviará un mensaje con el número de clientes conectados hasta ahora. 
 * Así pues, el primer cliente que se conecte recibirá un 1, el segundo un 2, el tercero 
 * un 3, etc.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente5 {

	public static void main(String[] args) throws IOException {
		
		int contador=0;
		
		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();

			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");
			
			// os.write(mensaje.getBytes());
			contador++;
			os.write(contador);

			System.out.println("Mensaje enviado");

		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
