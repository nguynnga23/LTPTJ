package Exercise01;

//2. The second approach for creating a thread by extending the Thread class (not recommended)
public class YourTask2 extends Thread {

	private String taskName;
	private int counter;
	
	
	public YourTask2(String taskName, int counter) {
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
		Runnable r1 = new YourTask2("Collect Task", 20);
		Runnable r2 = new YourTask2("Process Task", 23);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}


