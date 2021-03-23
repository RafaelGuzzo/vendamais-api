package com.vendamais.domain.model;

public class PedidoProduto {

	private Long idPedidoProduto;
	private Pedido idPedido;
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
