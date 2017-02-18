package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManger();
		
		GenericDAO<Conta> dao = new GenericDAO<Conta>(manager, Conta.class);
		
		Conta conta = dao.busca(3);
		
		manager.getTransaction().begin();
		
		dao.deleta(conta);
		
		manager.getTransaction().commit();
		
		
		/*manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();*/
		
		manager.close();
		System.out.println("Conta removida com sucesso");
	}
}
