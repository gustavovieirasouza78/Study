package study.xml.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import study.xml.model.Produto;
import study.xml.model.Venda;

public class MapXML {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
		xmlParaObjeto(jaxbContext);
		
		objetoParaXML(jaxbContext);
	}

	private static void objetoParaXML(JAXBContext jaxbContext) throws JAXBException {
		Marshaller createMarshaller = jaxbContext.createMarshaller();
		
		Venda venda = new Venda();
		venda.setFormaDePagamento("Dinheiro");
		Produto p1 = new Produto("Coxinha", 5.50);
		Produto p2 = new Produto("Coca", 3.50);
		venda.adicionaProduto(p1);
		venda.adicionaProduto(p2);
		
		createMarshaller.marshal(venda, new File("src/vendasGerado.xml"));
		
	}

	private static void xmlParaObjeto(JAXBContext jaxbContext) throws JAXBException {
		Unmarshaller createUnmarshaller = jaxbContext.createUnmarshaller();
		Venda venda = (Venda) createUnmarshaller.unmarshal(new File("src/vendas.xml"));

		System.out.println(venda);

	}
}
