package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

/*
public String busca(@QueryParam("id") long id){
Query Parameter, para a chamada http://www.localhost:8080/carrinhos?id=1

path paramenter
Path parameter, para chamadas http://www.localhost:8080/carrinhos/1 (Best Choice)

*/

@Path("carrinhos")
public class CarrinhoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	// @Produces(MediaType.APPLICATION_JSON)
	public Carrinho busca(@PathParam("id") long id) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho;
		// return carrinho.toJson();
	}
	// curl -v http://localhost:8080/carrinhos/1

	@POST
	// @Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(Carrinho carrinho) {
		//Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);

		URI create = URI.create("/carrinhos/" + carrinho.getId());
		return Response.created(create).build(); // 201 (OK é 200)
	}

	/*
	 * Passando o Content-Type para o Consumes C:\Users\Gustavo>curl -v -H
	 * "Content-Type: application/xml" -d "<br.com.alura.lo ja.modelo.Carrinho>
	 * <produtos> <br.com.alura.loja.modelo.Produto> <prec o>4000.0</preco>
	 * <id>6237</id> <nome>Videogame 4</nome> <quantida de>1</quantidade>
	 * </br.com.alura.loja.modelo.Produto> </produtos> <rua>Rua Vergueiro 3185,
	 * 8 andar</rua> <cidade>São Paulo</cidade> <id>1</id></br.com.al
	 * ura.loja.modelo.Carrinho>" http://localhost:8080/carrinhos
	 * 
	 * C:\Users\Gustavo>curl -v -d "<br.com.alura.loja.modelo.Carrinho>
	 * <produtos> <br.com.alura.loja.modelo.Produto> <preco>4000.0</preco>
	 * <id>6237</id> <nome>Videogame 4</nome> <quantidade>1</quantidade>
	 * </br.com.alura .loja.modelo.Produto> </produtos> <rua>Rua Vergueiro 3185,
	 * 8 andar</rua> <cid ade>São Paulo</cidade>
	 * <id>1</id></br.com.alura.loja.modelo.Carrinho>" http://l
	 * ocalhost:8080/carrinhos
	 */

	@Path("{id}/produtos/{produtoId}")
	@DELETE
	public Response removeProduto(@PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}

	/*
	 * C:\Users\Gustavo>curl -v -X "DELETE"
	 * http://localhost:8080/carrinhos/1/produtos/ 6237
	 * 
	 */
	@Path("{id}/produtos/{produtoId}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId) {

		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.troca(produto);
		URI create = URI.create("/carrinhos/" + carrinho.getId());
		return Response.created(create).build(); // 201 (OK é 200)
	}
	/*
	 * 
	 * C:\Users\Gustavo>curl -v -X "PUT" -H "Content-Type: application/xml" -d
	 * "<br.com
	 * .alura.loja.modelo.Produto><preco>60.0</preco><id>3467</id><nome>Jogo de
	 * esporte
	 * </nome><quantidade>1</quantidade></br.com.alura.loja.modelo.Produto>"
	 * http://loc alhost:8080/carrinhos/1/produtos/3467
	 * 
	 */

	@Path("{id}/produtos/{produtoId}/quantidade/")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response alteraProdutoQtde(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId) {

		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(conteudo);
		carrinho.trocaQuantidade(produto);
		URI create = URI.create("/carrinhos/" + carrinho.getId());
		return Response.created(create).build(); // 201 (OK é 200)
	}
/*
	C:\Users\Gustavo>curl -v -X "PUT" -H "Content-Type: application/xml" -d "<br.com
	.alura.loja.modelo.Produto><preco>60.0</preco><id>3467</id><nome>Jogo de esporte
	</nome><quantidade>100</quantidade></br.com.alura.loja.modelo.Produto>" http://l
	ocalhost:8080/carrinhos/1/produtos/3467/quantidade
*/
}
