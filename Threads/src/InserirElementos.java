
public class InserirElementos implements Runnable {

	private int numeroThreads;
	
	public InserirElementos(int numeroThreads){
		this.numeroThreads = numeroThreads;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			Armazenamento.instancia.adicionaElemento("Thread "+numeroThreads +" - " + i);
			
		}

	}

}
