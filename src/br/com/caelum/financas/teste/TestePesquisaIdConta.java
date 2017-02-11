package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestePesquisaIdConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManger();
		GenericDAO<Conta> dao = new GenericDAO<Conta>(manager);
		
		Conta conta = dao.busca(1);
		System.out.println("Titular:"+conta.getTitular());
		
		manager.close();
	}
}
