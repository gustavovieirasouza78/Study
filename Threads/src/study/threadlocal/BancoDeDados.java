package study.threadlocal;

public class BancoDeDados {
	
	public static void grava(){
		String usuario = Principal.usuarioCorrente.get();
		System.out.println("Thread: " + Thread.currentThread().getId() + " usuario: " + usuario);
	}

}
