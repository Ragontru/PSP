package tema2;

public class CounterThread extends Thread {

	String name;

	public CounterThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			if (count == 100) {
				count = 0;
			}

			System.out.println(name + ":" + count++);
		}
	}
}
