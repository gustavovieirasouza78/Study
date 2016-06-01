package study.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import study.financas.model.Conta;
import study.financas.model.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
		// TODO Auto-generated constructor stub
	}

	public Double mediaDAContaPeloTipo(Conta conta, TipoMovimentacao tipoMovimentacao) {
		TypedQuery<Double> query = manager.createQuery("select avg (m.valor) from Movimentacao m where m.conta=:pConta"
				+ " and m.tipoMovimentacao = :pTipo", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipoMovimentacao);
		
		Double media = query.getSingleResult();
		
		return media;
	}

}
