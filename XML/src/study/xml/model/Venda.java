package study.xml.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {

	private String formaDePagamento;
	
	@XmlElementWrapper(name="produtos")
	@XmlElement(name="produto")
	private List<Produto> produtos;
	
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		String retorno = "Forma de Pagamento: " + getFormaDePagamento() + "\n";
		for (Iterator iterator = produtos.iterator(); iterator.hasNext();) {
			Produto produto = (Produto) iterator.next();
			retorno = retorno + produto.toString() + "\n";
		}
		return retorno;
	}
	public void adicionaProduto(Produto produto) {
		if(this.produtos == null){
			this.produtos = new ArrayList<>();
		}
		produtos.add(produto);
		
	}

}
