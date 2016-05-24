import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContadorPrincipal {

	public static void main(String[] args) {
		//Thread[] threads = new Thread[100];
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			//threads[i] = new Thread(new Contador("Thread " + Integer.toString(i+1)));
			es.execute(new Contador("Thread " + Integer.toString(i+1))); // reaproveita as threads
		}

		/*
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}	
		*/
		System.out.println("Fim do processamento");
		es.shutdown();
	}

}
