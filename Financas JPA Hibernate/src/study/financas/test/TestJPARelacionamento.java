package study.financas.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import study.financas.model.Conta;
import study.financas.model.Movimentacao;
import study.financas.model.TipoMovimentacao;
import study.financas.util.JPAUtil;

public class TestJPARelacionamento {

	public static void main(String[] args) {
	
		inserirMovimentacao();
	
	}


	private static void inserirMovimentacao() {
		double inicio = System.currentTimeMillis();
		
		Conta c1 = new Conta();
		c1.setTitular("Gustavo Souza");
		c1.setAgencia("0001");
		c1.setBanco("341 - Itau");
		c1.setNumero("123456");			
		Movimentacao m11 = new Movimentacao();
		m11.setData(Calendar.getInstance());
		m11.setDescricao("Conta de Luz");
		m11.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m11.setValor(new BigDecimal("250.96"));
		m11.setConta(c1);
		Movimentacao m12 = new Movimentacao();
		m12.setData(Calendar.getInstance());
		m12.setDescricao("Salario");
		m12.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		m12.setValor(new BigDecimal("1233.96"));		
		m12.setConta(c1);
		
		Conta c2 = new Conta();
		c2.setTitular("Gustavo Souza");
		c2.setAgencia("0001");
		c2.setBanco("341 - Itau");
		c2.setNumero("123456");			
		Movimentacao m21 = new Movimentacao();
		m21.setData(Calendar.getInstance());
		m21.setDescricao("Conta de Luz");
		m21.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m21.setValor(new BigDecimal("250.96"));
		m21.setConta(c2);
		Movimentacao m22 = new Movimentacao();
		m22.setData(Calendar.getInstance());
		m22.setDescricao("Salario");
		m22.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		m22.setValor(new BigDecimal("1233.96"));		
		m22.setConta(c2);
		
		Conta c3 = new Conta();
		c3.setTitular("Gustavo Souza");
		c3.setAgencia("0001");
		c3.setBanco("341 - Itau");
		c3.setNumero("123456");			
		Movimentacao m31 = new Movimentacao();
		m31.setData(Calendar.getInstance());
		m31.setDescricao("Conta de Agua");
		m31.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		m31.setValor(new BigDecimal("52.96"));
		m31.setConta(c3);
		Movimentacao m32 = new Movimentacao();
		m32.setData(Calendar.getInstance());
		m32.setDescricao("Salario");
		m32.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		m32.setValor(new BigDecimal("10000.96"));		
		m32.setConta(c3);
		
				
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(c1);
		manager.persist(m11);
		manager.persist(m12);
		
		manager.persist(c2);
		manager.persist(m21);
		manager.persist(m22);
		
		manager.persist(c3);
		manager.persist(m31);
		manager.persist(m32);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
