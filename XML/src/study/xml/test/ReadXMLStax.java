package study.xml.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import study.xml.model.Produto;

public class ReadXMLStax {
	

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
		
		List<Produto> produtos = new ArrayList<>();
		Produto produto = new Produto();
		
		while(eventos.hasNext()){
			XMLEvent nextEvent = eventos.nextEvent();
			
			if (nextEvent.isStartElement() && nextEvent.asStartElement().getName().getLocalPart().equals("produto")) {
				produto = new Produto();
			}else if (nextEvent.isStartElement() && nextEvent.asStartElement().getName().getLocalPart().equals("nome")) {
				nextEvent = eventos.nextEvent();
				String conteudo = nextEvent.asCharacters().getData();
				produto.setNome(conteudo);
			}else if (nextEvent.isStartElement() && nextEvent.asStartElement().getName().getLocalPart().equals("preco")) {
				nextEvent = eventos.nextEvent();
				double preco = Double.parseDouble(nextEvent.asCharacters().getData());
				produto.setPreco(preco);
			}else if (nextEvent.isEndElement() && nextEvent.asEndElement().getName().getLocalPart().equals("produto")){
				produtos.add(produto);
			}
		
		}
		
		System.out.println(produtos);
		
	}
}
