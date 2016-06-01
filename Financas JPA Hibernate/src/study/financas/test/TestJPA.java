package study.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import study.financas.model.Conta;
import study.financas.util.JPAUtil;

public class TestJPA {

	public static void main(String[] args) {
	
		insertContas();
		
		findConta();
		
	}

	private static void findConta() {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		//conta agora está managed
		
		System.out.println(conta.toString());
		
		conta.setBanco("341 Itau");
		//por isso, o update será automático (apenas se necessário)
		
		//apaga a conta
		manager.remove(conta);
		
		System.out.println(conta.toString());
		
		manager.getTransaction().commit();
		
		manager.close();
	}

	private static void insertContas() {
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setTitular("Gustavo Souza");
		conta.setAgencia("0001");
		conta.setBanco("341 - Itau");
		conta.setNumero("123456");		
		Conta conta2 = new Conta();
		conta2.setTitular("Damaris Moreira");
		conta2.setAgencia("0002");
		conta2.setBanco("237 - Bradesco");
		conta2.setNumero("1234567");	
		Conta conta3 = new Conta();
		conta3.setTitular("Beatrix Cristina");
		conta3.setAgencia("0003");
		conta3.setBanco("341 - Unibanco");
		conta3.setNumero("1234568");	
		Conta conta4 = new Conta();
		conta4.setTitular("Mateus Fralda");
		conta4.setAgencia("0000");
		conta4.setBanco("000 - Sem Banco");
		conta4.setNumero("1234569");	
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		
		/*depois do persist, todas as contas saem de transient para managed, ou seja, 
		 * qq alteração no objeto conta vai gerar um update, este estado dura enquanto o Entity Manager estiver aberto. 
		 * 
		 * Caso vc tenha um objeto que esteja desacoplado do BD, e precise atualizar seu valor, deve deixar o mesmo id e usar 
		 * merge. manager.merge() . Nesse caso o hibernate vai fazer um select para verificar o que precisa ser alterado e logo depois um insert,
		 * caso necessário
		 */
		
		manager.getTransaction().commit();
		
		double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
		
		manager.close();
	}

}
