package tema2;

public class Priority {

	public static void main(String[] args) {
		
		CounterThread thread1 = new CounterThread("thread1");
		thread1.setPriority(10);
		CounterThread thread2 = new CounterThread("thread2");
		thread2.setPriority(10);
		
		thread1.start();
		thread2.start();
		
	}

}
