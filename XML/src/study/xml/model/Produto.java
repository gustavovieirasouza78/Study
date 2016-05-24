package study.xml.model;

public class Produto {

	
	private String nome;
	private double preco;

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return ("Produto: " + getNome() + " Valor: " + getPreco());
	}	
	
}
