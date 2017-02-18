package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.GenericDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManger();
		manager.getTransaction().begin();
		
		GenericDAO<Conta> contaDAO = new GenericDAO<Conta>(manager, Conta.class);
		GenericDAO<Movimentacao> movimentacaoDAO = new GenericDAO<Movimentacao>(manager, Movimentacao.class);
		
		Conta conta = new Conta();
		conta.setBanco("Itau");
		conta.setNumero("0000");
		conta.setAgencia("124");
		conta.setTitular("Ronaldo");
		
		contaDAO.adiciona(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Teste");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("100"));
		
		
		
		movimentacaoDAO.adiciona(movimentacao);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Movimentação adicionada com sucesso");
	}
}
