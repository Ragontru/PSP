package ej1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor {

	// D:\Raquel\Documents\GitHub\PSP\Tema3\ejercicios\ej1\TxtRecibido
	static String ruta = ".\\Tema3\\ejercicios\\ej1\\TxtRecibido";

	public static void main(String[] args) {
		try {

			System.out.println("Creando socket servidor");
			ServerSocket server = new ServerSocket();

			System.out.println("Realizando blind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			server.bind(addr);

			System.out.println("Aceptando conexiones");
			Socket newSocket = server.accept();

			System.out.println("Conexión recibida");
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();

			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			byte[] message = new byte[200];

			while (is.read(message) > -1) {
				System.out.println("Mensaje recibido: " + new String(message));
				out.println(new String(message));
			}
						
			out.close();
			bw.close();
			fw.close();
			newSocket.close();
			server.close();
			
			System.out.println("Terminado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
