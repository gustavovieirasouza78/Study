
public class Contador implements Runnable {

	private String nome;
	
	public Contador(String nome){
		this.nome = nome;
	}
	@Override
	public void run() {
		long id = Thread.currentThread().getId();
		for (int i = 1; i <= 10; i++) {
			
			System.out.println("Thread: "+ nome + " contado: " + i + " id: " + id);
		}

	}

}
