package br.com.alura.strategy;

public class RealizadorDeInvestimentos {

	public void calculaInvestimento(Conta conta, Investimento investimento) {
		double valorCalculado = investimento.calculaInvestimento(conta);
		
		valorCalculado = valorCalculado * 0.75;
		
		conta.deposita(valorCalculado);
	}

}
