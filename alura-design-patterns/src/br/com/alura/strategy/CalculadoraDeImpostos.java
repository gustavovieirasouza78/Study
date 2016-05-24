package br.com.alura.strategy;

public class CalculadoraDeImpostos {

	//Aqui podemos passar varias estrategias de calculo de impostos
	public double calculaImposto(Orcamento orcamento, Imposto imposto) {
		return imposto.calculaImposto(orcamento);
	}

}
