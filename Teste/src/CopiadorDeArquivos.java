
public class CopiadorDeArquivos implements Runnable {
	public void run(){
		for (int i=0; i<10000; i++){
			System.out.println("Copiador de Arquivos");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
