package study.thread.exception;

public class Principal {

	public static void main(String[] args) {
		
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread arg0, Throwable arg1) {
				System.out.println("Erro captudo: " + arg1.getMessage());
				
			}
		};

		Thread t1 = new Thread(new ContadorComPossivelErro(1));
		t1.setUncaughtExceptionHandler(handler);
		Thread t2 = new Thread(new ContadorComPossivelErro(2));
		t2.setUncaughtExceptionHandler(handler);
		Thread t3 = new Thread(new ContadorComPossivelErro(3,4));
		t3.setUncaughtExceptionHandler(handler);
		Thread t4 = new Thread(new ContadorComPossivelErro(4));
		t4.setUncaughtExceptionHandler(handler);
		Thread t5 = new Thread(new ContadorComPossivelErro(5,8));
		t5.setUncaughtExceptionHandler(handler);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
	}

}
