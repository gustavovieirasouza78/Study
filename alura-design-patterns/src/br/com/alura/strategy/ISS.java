package br.com.alura.strategy;

public class ISS implements Imposto {

	public double calculaImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
	
}
