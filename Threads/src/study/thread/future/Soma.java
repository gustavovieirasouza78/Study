package study.thread.future;
import java.util.concurrent.Callable;

public class Soma implements Callable<Integer> {
	
	private NotaFiscal[] notas;
	private int inicio;
	private int termino;
		
	public Soma(NotaFiscal[] notas, int inicio, int termino) {
		this.notas = notas;
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	public Integer call() throws Exception {
		int soma = 0;
		
		for (int i = inicio; i < termino; i++) {
			soma += notas[i].getTotal();
		}
			
		return soma;
	}

}
