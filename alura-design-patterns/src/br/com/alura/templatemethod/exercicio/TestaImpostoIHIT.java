package br.com.alura.templatemethod.exercicio;

import br.com.alura.chain.Item;
import br.com.alura.chain.Orcamento;

public class TestaImpostoIHIT {

	public static void main(String[] args) {
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionaItem(new Item("Calculadora", 50));
		orcamento.adicionaItem(new Item("Lapiseira", 10));
		orcamento.adicionaItem(new Item("Calculadora", 50));
		orcamento.adicionaItem(new Item("Borracha", 50));
		
		double impostoCalculado = calculadora.calculaImposto(orcamento, new IHIT());
		
		System.out.println(impostoCalculado);
	}
}
