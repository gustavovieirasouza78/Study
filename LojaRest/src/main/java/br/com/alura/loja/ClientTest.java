package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import junit.framework.Assert;

public class ClientTest { 

	private HttpServer server;
	private Client client;
	private WebTarget target;
	
	@Before
	public void starServer() {
		server = Servidor.startServer();
		
		//Filtro de log do Jersey, para ver as interações do servidor
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		//foi criado e passado no builder newClient.
		
		this.client = ClientBuilder.newClient(config);
		target = client.target("http://localhost:8080");
	}

	
	@After
	public void stopSever(){
		Servidor.stopServer(server);
	}
	
	@Test
	public void testConectionServerClient() {
		Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
		Assert.assertEquals(carrinho.getId(), 1);
	}
	
	
	@Test
	public void testInserirCarrinho() {
		
		Carrinho carrinho = new Carrinho();
        carrinho.adiciona(new Produto(17L, "Tablet", 999, 1));
        carrinho.setRua("Rua Aclimação");
        carrinho.setCidade("Sorocaba");
        String xml = carrinho.toXML();
        
        Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        Assert.assertEquals(201, response.getStatus());
//      Assert.assertEquals("<status>sucesso</status>", response.readEntity(String.class));

        String headerString = response.getHeaderString("Location");
        Carrinho carrinhoCarregado = client.target(headerString).request().get(Carrinho.class); 
        
        //System.out.println(carrinhoCarregado.getProdutos().get(0).getId());
        Assert.assertTrue(carrinhoCarregado.getProdutos().get(0).getId()==17);
	}	
}
