package br.com.alura.templatemethod.exercicio;

import br.com.alura.chain.Orcamento;
import br.com.alura.templatemethod.Imposto;

public class CalculadoraDeImpostos {

	public double calculaImposto(Orcamento orcamento, Imposto imposto) {
		return imposto.calculaImposto(orcamento);
	}
}
