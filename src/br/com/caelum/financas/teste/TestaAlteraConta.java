package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManger();
		
		GenericDAO<Conta> dao = new GenericDAO<Conta>(manager, Conta.class);
		
		manager.getTransaction().begin();
		Conta conta = dao.busca(2);
		
		conta.setTitular("Ronaldo");
		
		
		manager.getTransaction().commit();
		
		manager.close();
		
		System.out.println("Conta alterada com sucesso");
		
	}
}
