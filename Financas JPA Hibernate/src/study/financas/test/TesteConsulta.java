package study.financas.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import study.financas.model.Conta;
import study.financas.model.Movimentacao;
import study.financas.model.TipoMovimentacao;
import study.financas.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//JPQL
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
				+ " and m.tipoMovimentacao = :pTipo"
				+ " order by m.valor desc");
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.toString());
		}
	}

}
