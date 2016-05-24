package study.thread.truncate;

public class LanceIncremento implements Runnable {

	private Incremento incremento;
	private Leilao leilao;
	
	
	public LanceIncremento(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	@Override
	public void run() {
		
		synchronized(leilao){
			synchronized(incremento){
				System.out.println("Iniciando lance normal");
				int valorIncremento = incremento.getValor();
				leilao.darLance(valorIncremento);
			}
		}
		System.out.println("O valor do produto agora é: " + leilao.getValorCorrente());

	}
}
