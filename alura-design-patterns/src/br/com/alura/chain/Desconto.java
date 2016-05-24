package br.com.alura.chain;

public interface Desconto {

	double calculaDesconto(Orcamento orcamento);
	
	void setProximoDesconto(Desconto proximoDesconto);

}
