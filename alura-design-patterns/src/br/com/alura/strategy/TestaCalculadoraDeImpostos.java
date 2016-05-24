package br.com.alura.strategy;

public class TestaCalculadoraDeImpostos {

	public static void main(String[] args) {
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		double valorICMS = calculadora.calculaImposto(new Orcamento(100), new ICMS());
		double valorISS = calculadora.calculaImposto(new Orcamento(100), new ISS());
		
		System.out.println(valorICMS);
		System.out.println(valorISS);
	}
	
}
