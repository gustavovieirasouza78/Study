package study.thread.truncate;

public class Leilao {
	private int valorCorrente;

	public Leilao(int lanceinicial) {
		this.valorCorrente = lanceinicial;
	}

	public int getValorCorrente() {
		return valorCorrente;
	}
	
	public void darLance(int incremento) {
		valorCorrente = valorCorrente + incremento;
	}
	
	
}
