package study.thread.truncate;

public class Incremento {
	
	private int valor;

	public Incremento(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	public void dobrar(){
		valor = valor *2;
	}

}
