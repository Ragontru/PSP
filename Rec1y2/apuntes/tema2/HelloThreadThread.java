package tema2;

public class HelloThreadThread extends Thread{

	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado Thread");
	}
	
}
