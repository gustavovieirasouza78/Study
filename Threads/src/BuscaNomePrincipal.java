
public class BuscaNomePrincipal {

	public static void main(String[] args) {
		String procurado = "Da";
		BuscaNome b1 = new BuscaNome("autores.txt", procurado);
		BuscaNome b2 = new BuscaNome("autores2.txt", procurado);
		BuscaNome b3 = new BuscaNome("autores3.txt", procurado);

		Thread t1 = new Thread(b1);	
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);
		
		t1.start();		
		t2.start();
		t3.start();
	}

}
