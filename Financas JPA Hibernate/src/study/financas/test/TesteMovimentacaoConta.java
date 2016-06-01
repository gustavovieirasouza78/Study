package study.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import study.financas.model.Conta;
import study.financas.model.Movimentacao;
import study.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = manager.find(Conta.class, 1);
		
		System.out.println("Numero de movimentações: " + conta.getMovimentacoes().size());
		
		//Query query = manager.createQuery("select c from Conta c");
		// se não usar join fetch, ira trabalhar lazy, ou seja, realizar 1 para N em SQL
		
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = query.getResultList();
		
		for (Conta conta2 : contas) {
			System.out.println("Conta: " + conta2.getId() + " movimentações: " + conta2.getMovimentacoes().size());
		}
		
		//Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
		//System.out.println("Titular da conta: " + movimentacao.getConta().getTitular());
		
	}

}
