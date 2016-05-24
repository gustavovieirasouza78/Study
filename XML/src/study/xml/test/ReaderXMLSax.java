package study.xml.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import study.xml.handler.ProdutosHandler;

public class ReaderXMLSax {

	public static void main(String[] args) throws SAXException, IOException {

		XMLReader leitor = XMLReaderFactory.createXMLReader();
		
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		
		InputStream ips  = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		leitor.parse(is);
		
		System.out.println(logica.getProdutos());
		
	}

}
