package study.xml.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.stream.Stream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertToHtml {

	public static void main(String[] args) throws FileNotFoundException, TransformerFactoryConfigurationError, TransformerException {
		//need xls
		
		InputStream xsl = new FileInputStream("src/xmlTOhtml.xsl");
		StreamSource xlsSource = new StreamSource(xsl);
		
		InputStream dados = new FileInputStream("src/vendas.xml");
		StreamSource xmlSource = new StreamSource(dados);
 		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(xlsSource);
		
		StreamResult saida = new StreamResult("src/vendas.html");
		transformer.transform(xmlSource, saida);
		
		System.out.println("The End!");
	}

}
