
public class ThreadsTest {

	public static void main(String[] args) throws InterruptedException {
		
		Conta c1 = new Conta(0565);
		c1.setSaldo(500.0);
		FazDeposito acao = new FazDeposito(c1);
		Thread tc1 = new Thread(acao);
		Thread tc2 = new Thread(acao);
		tc1.start();
		tc2.start();
		
		tc1.join();
		tc2.join();
		
		System.out.println(c1.getSaldo());
		
		
		BarradeProgresso barra = new BarradeProgresso();
		Thread t1 = new Thread(barra);
		t1.start();
		
		CopiadorDeArquivos cp = new CopiadorDeArquivos();
		Thread t2 = new Thread(cp);
		t2.start();

	}

}
