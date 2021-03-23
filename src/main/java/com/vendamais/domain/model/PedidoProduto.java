package com.vendamais.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoProduto;
	
	@ManyToOne
	private Pedido idPedido;
	
	@ManyToOne
	private Produto idProduto;
	private Long quantidade;

	public Long getIdPedidoProduto() {
		return idPedidoProduto;
	}

	public void setIdPedidoProduto(Long idPedidoProduto) {
		this.idPedidoProduto = idPedidoProduto;
	}

	public Pedido getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

}
