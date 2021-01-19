package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import buzon.Buzon;
import buzon.Correo;

public class Conexion extends Thread {

	private Socket newSocket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Correo receptor;
	private ArrayList<Correo> correo;
	private String usuario, mensaje;
	int opcion;

	// Constructor
	public Conexion(Socket newSocket) {
		this.newSocket = newSocket;
		this.ois = ois;
		this.oos = oos;
		this.correo = new ArrayList<Correo>();
	}
	
	@Override
	public void run() {
		try {
			oos.writeUTF("Usuario:");
			this.usuario = this.ois.readUTF();
			
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
					oos.writeUTF("Opción inválida");
					break;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.ois.close();
			this.oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 
	private void escribirCorreo(String usuario) {
		Mensaje m2=new Mensaje(this.nombreCliente.getMensaje()+ " ,a quien quieres enviarle un mensaje?");
		salida.writeObject(m2);
		Mensaje destinatario=(Mensaje) entrada.readObject();
		this.destinatario=destinatario.mensaje;	
	}

	// 
	public void mirarBuzon() {
		try {
			oos.writeUTF("EN CONSTRUCCIÓN");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 
	public void leerCorreo(Correo correo) {
		try {
			oos.writeUTF("EN CONSTRUCCIÓN");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
