package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.usuario.AutotizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

@WebService
public class EstoqueWS {

	private ItemDao  dao = new ItemDao();
	
	@WebMethod(operationName="todosOsItens")
	@WebResult(name="itens")
	public List<Item> getItens(@WebParam(name="filtros") Filtros filtros){
		System.out.println("Chamando getItens()...");
		System.out.println("Filtros: " + filtros);
		List<Filtro> lista = filtros.getLista();
		System.out.println(lista);
		List<Item> todosItens = dao.todosItens(lista);
		return todosItens;
	}
	
	@WebMethod(operationName="cadastrarItem")
	@WebResult(name="item")	
	public Item cadastrarItem(@WebParam(name = "token", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutotizacaoException{
		
		System.out.println("Cadastrando Item..." + item + " token: " + token);
		
		boolean ehValido = new TokenDao().ehValido(token);
		
		if(!ehValido){
			throw new AutotizacaoException("Autorização falhou!");
		}
		
        new ItemValidador(item).validate();
		
		this.dao.cadastrar(item);	
		return item;
	}
	
}
