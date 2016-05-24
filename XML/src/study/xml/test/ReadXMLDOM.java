package study.xml.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import study.xml.model.Produto;

public class ReadXMLDOM{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	

		//validate with XSD
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder buider = factory.newDocumentBuilder();
		Document document = buider.parse("src/vendas.xml");
		
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		
		
		String exp = "venda/produtos/produto[contains(nome,'Livro')]";//[1] apenas segundo produto //[nome='Livro de XML']valor exato
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		
		//NodeList produtos = document.getElementsByTagName("produto"); //arquivo todo
		NodeList produtos = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
		
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element)produtos.item(i);
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome, preco);
			System.out.println(prod.toString());
		}
	}
}
