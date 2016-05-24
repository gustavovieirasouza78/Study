package study.threadlocal;

import java.awt.geom.RectangularShape;

public class ProcessamentoUsuario implements Runnable {

	private String usuario;
	
	
	public ProcessamentoUsuario(String usuario) {
		super();
		this.usuario = usuario;
	}


	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getId() + " usuário: " + usuario);
		Principal.usuarioCorrente.set(usuario);
		System.out.println("Thread: " + Thread.currentThread().getId() + " colocado na ThreadLocal");
		RegraDeNegocio.executa();
	}

}
