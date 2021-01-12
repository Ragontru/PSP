package servidor;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import buzon.Buzon;
import buzon.Correo;

public class Conexion extends Thread {

	private Socket newSocket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Buzon buzon;
	private String usuario;
	int opcion;

	// Constructor
	public Conexion(Socket newSocket, DataInputStream dis, DataOutputStream dos, Buzon buzon) {
		this.newSocket = newSocket;
		this.dis = dis;
		this.dos = dos;
		this.buzon = buzon;
	}
	
	@Override
	public void run() {
		try {
			dos.writeUTF("Usuario: ");
			this.usuario = this.dis.readUTF();
			
			String[] opciones = {"¿Qué desea hacer?","Mirar buzón","Escribir correo"};
			Menu menu = new Menu(opciones);
			while (!menu.seSale()) {
				menu.muestra();
				opcion = menu.getOpcion();
				
				switch (opcion) {
				case 1:
					mirarBuzon();
					break;
				case 2:
					escribirCorreo(usuario);
					break;
				default:
					dos.writeUTF("Opción inválida");
					break;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.dis.close();
			this.dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void escribirCorreo(String usuario) {
		// TODO Auto-generated method stub
		
	}

	// 
	public void mirarBuzon() {
		
		Correo correo = Buzon.busqueda(usuario);
		
		if (correo!=null) {
			leerCorreo(correo);
			Buzon.borrarCorreo(correo);
		}else {
			try {
				dos.writeUTF("No hay correo");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 
	public void leerCorreo(Correo correo) {
		String mensaje ="";
		mensaje="--- Mensaje de: "+correo.getRemitente()+" para "+correo.getMensaje();
		
		try {
			dos.write(mensaje.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
