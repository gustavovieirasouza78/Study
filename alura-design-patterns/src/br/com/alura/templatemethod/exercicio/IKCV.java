package br.com.alura.templatemethod.exercicio;

import br.com.alura.chain.Item;
import br.com.alura.chain.Orcamento;

public class IKCV extends TemplateDeImpostoCondicional {

	@Override
	public boolean taxacaoForMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500 && existeItemComValorMaiorQue100no(orcamento);
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	private boolean existeItemComValorMaiorQue100no(Orcamento orcamento) {
		for(Item item: orcamento.getItens()) {
			if (item.getValor() > 100) return true;
		}
		return false;
	}
}
