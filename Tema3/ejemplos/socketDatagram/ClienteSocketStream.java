package socketDatagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteSocketStream {

	public static void main(String[] args) throws IOException {
		
		try {
			System.out.println("Creando socket cliente");
			ServerSocket server = new ServerSocket();
			
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			server.bind(addr);
			
			System.out.println("Aceptando conexiones");
			Socket newSocket = server.accept();
			
			System.out.println("Conexion recibida");
			InputStream is=newSocket.getInputStream();
			OutputStream os=newSocket.getOutputStream();
			byte[] message = new byte[25];
			is.read(message);
			System.out.println("Mensaje recibido: "+new String(message));
			
			System.out.println();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
