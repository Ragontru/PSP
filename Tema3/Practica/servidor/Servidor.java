package servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			System.out.println("Creando socket SERVIDOR");
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			servidor.bind(addr);
			
			// Aceptar conexiones
			
			servidor.close();
			System.out.println("SERVIDOR cerrado");
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
