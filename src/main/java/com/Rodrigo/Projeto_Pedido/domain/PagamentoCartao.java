package com.Rodrigo.Projeto_Pedido.domain;

import javax.persistence.Entity;

import com.Rodrigo.Projeto_Pedido.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer parcelas;
	
	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, 
			Integer parcelas) {
		super(id, estado, pedido);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
}
