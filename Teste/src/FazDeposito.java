
public class FazDeposito implements Runnable{
	
	private Conta conta;
	public FazDeposito(Conta c1) {
		this.conta = c1;
	}

	@Override
	public void run() {
		conta.deposita(100.0);	
	}

}
