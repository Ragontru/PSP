package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Emisor {

	// D:\Raquel\Documents\GitHub\PSP\Tema3\ejercicios\ej1\TxtEnviado
	static String ruta = "D:\\Raquel\\Documents\\GitHub\\PSP\\Tema3\\ejercicios\\ej1\\TxtEnviado";

	public static void main(String[] args) {

		try {
			File file = new File(ruta);

			FileReader fr;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();
			
			System.out.println("Enviando mensaje");
			while (br.ready()) {
				String linea = br.readLine();
				System.out.println(linea);
				os.write(linea.getBytes());
			}
			
/*			finally {
				if (os != null) {
					os.close();
					br.close();
					System.out.println("Mensaje enviado");
				}

			}*/
			
			System.out.println("Mensaje enviado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}