package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {

	private HttpServer server;
	
	@Before
	public void starServer() {
		server = Servidor.startServer();
	}
	
	@After
	public void stopSever(){
		server.stop();
	}
	
	@Test
	public void testConectionServerProjeto() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos/1").request().get(String.class);
		Assert.assertTrue(conteudo.contains("<nome>Minha loja"));
	}
	
	@Test
	public void testInserirProjeto() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		
		Projeto projeto = new Projeto(17l, "Prato do Dia", 2016);
        String xml = projeto.toXML();
        
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/projetos").request().post(entity);
        Assert.assertEquals(201, response.getStatus());
        
        String headerString = response.getHeaderString("Location");
        String conteudo = client.target(headerString).request().get(String.class);      
        Assert.assertTrue(conteudo.contains("Prato do Dia"));  

	}	
}

