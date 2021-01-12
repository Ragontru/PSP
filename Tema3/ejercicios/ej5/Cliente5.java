package ej5;

/*
 * Ejercicio 5: Escribe un programa que cuente el n�mero de conexiones que vaya recibiendo. 
 * Este programa dispondr� de un socket stream servidor. Cada vez que un socket cliente se 
 * conecte, este le enviar� un mensaje con el n�mero de clientes conectados hasta ahora. 
 * As� pues, el primer cliente que se conecte recibir� un 1, el segundo un 2, el tercero 
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

			System.out.println("Estableciendo la conexi�n");
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
