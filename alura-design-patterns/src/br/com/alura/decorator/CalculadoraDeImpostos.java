package br.com.alura.decorator;

import br.com.alura.chain.Orcamento;

public class CalculadoraDeImpostos {

	public double calculaImposto(Orcamento orcamento, Imposto imposto) {
		return imposto.calculaImposto(orcamento);
	}
	
}
