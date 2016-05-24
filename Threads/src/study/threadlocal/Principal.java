package study.threadlocal;

public class Principal {
	
	public static ThreadLocal<String> usuarioCorrente = new ThreadLocal<String>();

	public static void main(String[] args) {
		new Thread(new ProcessamentoUsuario("Gustavo")).start();
		new Thread(new ProcessamentoUsuario("Damaris")).start();
		new Thread(new ProcessamentoUsuario("Beatriz")).start();
		new Thread(new ProcessamentoUsuario("Mateus")).start();
	}

}
