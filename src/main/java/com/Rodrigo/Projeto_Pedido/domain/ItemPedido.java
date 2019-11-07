package com.Rodrigo.Projeto_Pedido.domain;

import java.io.Serializable;

public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double precoDoProduto;
	
	public ItemPedido() {
	}

	public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double precoDoProduto) {
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.precoDoProduto = precoDoProduto;
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoDoProduto() {
		return precoDoProduto;
	}

	public void setPrecoDoProduto(Double precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
