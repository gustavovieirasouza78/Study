package study.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import study.financas.model.Conta;
import study.financas.model.TipoMovimentacao;
import study.financas.util.JPAUtil;


public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		//JPQL
		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		Double media = query.getSingleResult();
		
		System.out.println("Media: "+media);
	}

}
