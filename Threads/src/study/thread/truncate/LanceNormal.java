package study.thread.truncate;

public class LanceNormal implements Runnable {

	private Incremento incremento;
	private Leilao leilao;
	
	
	public LanceNormal(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	@Override
	public void run() {
		synchronized(leilao){
			System.out.println("Iniciando lance com incremento no leilão com valor: " + leilao.getValorCorrente());
			synchronized(incremento){
				incremento.dobrar();
				int valorIncremento = incremento.getValor();
				leilao.darLance(valorIncremento);
				System.out.println("Valor corrente do Leilão: " + leilao.getValorCorrente() + " e o incremento: " + incremento.getValor());
			}	
		}
	}

}
