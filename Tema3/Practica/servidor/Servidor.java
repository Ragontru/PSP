package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import buzon.Buzon;

public class Servidor {

	public static void main(String[] args) {

		try {
			Buzon buzon = new Buzon();

			System.out.println("Creando socket SERVIDOR");
			ServerSocket server = new ServerSocket();

			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

			while (true) {
				try {
					// Aceptar conexiones
					System.out.println("Aceptando conexiones");
					Socket newSocket = server.accept();

					System.out.println("Conexión recibida");
					InputStream is = newSocket.getInputStream();
					DataInputStream dis = new DataInputStream(is);
					
					OutputStream os = newSocket.getOutputStream();
					DataOutputStream dos=new DataOutputStream(os);
					
					Thread hilo = new Conexion(newSocket, dis, dos, buzon);
					hilo.start();
				} catch (Exception e) {
					newSocket.close();
					e.printStackTrace();
				}
				
			}
			
			System.out.println("Cerrando el socket SERVIDOR");
			server.close();

			System.out.println("Terminado");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
