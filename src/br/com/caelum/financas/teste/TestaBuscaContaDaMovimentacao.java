package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManger();
		GenericDAO<Movimentacao> movimentacaoDAO = new GenericDAO<Movimentacao>(manager, Conta.class);
		
		Movimentacao movimentacao = movimentacaoDAO.busca(new Integer(7));
		System.out.println(movimentacao.getConta());
		
		manager.close();
		
	}
}
