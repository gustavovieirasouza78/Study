package study.financas.test;

import javax.persistence.EntityManager;

import study.financas.model.Conta;
import study.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {
    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 2);

        // commit antes da altera��o
        manager.getTransaction().commit();

        // Altera��o do titular da conta
        conta.setTitular("Caelum ensino e inova��o");
        
        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
        

        manager.close();
    }
}