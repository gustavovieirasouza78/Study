package study.soap.ws.client;

import java.util.List;

public class TestaServicoWeb {

	public static void main(String[] args) {
		
		EstoqueWS client = new EstoqueWS_Service().getEstoqueWSImplPort();
		
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo(TipoItem.CELULAR);
		filtros.getFiltro().add(filtro);
		
		List<Item> todosOsItens = client.todosOsItens(filtros );
		
		System.out.println(todosOsItens);
	}

}
