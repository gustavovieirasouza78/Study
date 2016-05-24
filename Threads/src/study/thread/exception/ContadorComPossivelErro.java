package study.thread.exception;

public class ContadorComPossivelErro implements Runnable {

	private int darErro = 1;
	private int numeroThread;
	
	public ContadorComPossivelErro(int numeroThread, int darErro){
		this.numeroThread = numeroThread;
		this.darErro = darErro;
	}
	
	public ContadorComPossivelErro(int numeroThread){
		this.numeroThread = numeroThread;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if(i == darErro){
				throw new RuntimeException("Erro na thread: " + numeroThread + " ao contar: "+i );
			}
			System.out.println("Thread: "+ numeroThread + " i: " + i);
		}
	}

}
