package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService(endpointInterface="br.com.caelum.estoque.ws.EstoqueWS", serviceName="EstoqueWS")
public class EstoqueWSImpl implements EstoqueWS {

	@Override
	public List<Item> todosOsItens(Filtros filtros) {
        System.out.println("Chamando todos os Itens");
        
        Item a = new Item();
        a.setCodigo("AAA");
        a.setNome("teste");
        a.setQuantidade(10);
        a.setTipo("Celular");
        
        List<Item> itens =  new ArrayList<>();
        itens.add(a);
        
        return itens;
	}

	@Override
	public CadastrarItemResponse cadastrarItem(CadastrarItem parameters, TokenUsuario token)
			throws AutotizacaoException {
        System.out.println("Chamando cadastarItem");
        return new CadastrarItemResponse();
	}

}
