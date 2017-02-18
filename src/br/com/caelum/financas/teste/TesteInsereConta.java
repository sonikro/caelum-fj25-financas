package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManger();
		
		GenericDAO<Conta> dao = new GenericDAO<Conta>(manager, Conta.class);
		
		
		Conta conta = new Conta();
		
		conta.setAgencia("8533");
		conta.setBanco("Itau");
		conta.setNumero("130624");
		conta.setTitular("Jonathan Nagayoshi");
		
		Long inicio = System.currentTimeMillis();
		
		manager.getTransaction().begin();
		
		dao.adiciona(conta);
		
		
		manager.getTransaction().commit();
		manager.close();

		Long fim = System.currentTimeMillis();
		
		System.out.println("Conta gravada com sucesso");
		System.out.println("Executado em " + (fim - inicio) + "ms");
		
	}
}
