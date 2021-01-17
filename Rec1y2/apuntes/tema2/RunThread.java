package tema2;

public class RunThread {

	public static void main(String[] args) {
		
		new HelloThreadRunnable();
		System.out.println("Hola desde el hilo principal");
		System.out.println("Proceso acabado\n");
		
		new HelloThreadThread().start();
		System.out.println("Hola desde el hilo principal");


	}

}
