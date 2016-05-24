
public class InserirElementosPrincipal {

	public static void main(String[] args) throws InterruptedException {

		Thread[] threads = new Thread[10];
		
		for (int i = 1; i <= 10; i++) {
			threads[i-1] = new Thread(new InserirElementos(i));
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}	
		
		
		
		synchronized (Armazenamento.instancia){
			if(Armazenamento.instancia.getContador() < 100){
				Armazenamento.instancia.wait();
			}

			String[] lista = Armazenamento.instancia.recuperaLista();
			for (int i = 0; i < lista.length; i++) {
				System.out.println(lista[i]);
			}
		}
		
		System.out.println("Fim do processamento");		

	}

}
