package Exercise02__Wait_Notisy_MechanismDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer_Consumer_Demo {
	public static void main(String[] args) {
		System.out.println("Press Control-C to stop.");
		ExecutorService service = Executors.newFixedThreadPool(3);
		MyQeue q = new MyQeue();
		new Producer(q);
		new Consumer(q);
	}
}
