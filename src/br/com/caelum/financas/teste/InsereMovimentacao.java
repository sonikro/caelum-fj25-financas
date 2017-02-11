package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class InsereMovimentacao {
	public static void main(String[] args) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Teste");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("100"));
		
		EntityManager manager = new JPAUtil().getEntityManger();
		
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		System.out.println("Movimentação adicionada com sucesso");
		
	}
}
