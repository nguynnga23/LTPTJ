package Exercise01;

//1. The first approach for creating threads is implement Runnable interface (recommended)
public class YourTask1 implements Runnable {

	private String taskName;
	private int counter;
	
	
	public YourTask1(String taskName, int counter) {
		this.taskName = taskName;
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i = 0; i < counter; i++) {
			System.out.println("taskName" + "#" + taskName + "#" + i);
		}
	}
	
	public static void main(String[] args) {
		Runnable r1 = new YourTask1("Print Task", 20);
		Runnable r2 = new YourTask1("Distribute Task", 23);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}


