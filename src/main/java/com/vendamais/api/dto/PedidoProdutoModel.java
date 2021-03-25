package com.vendamais.api.dto;

public class PedidoProdutoModel extends PedidoProdutoInput {

	private Long idpedidoproduto;
	private Long produtoId;
	private Double totalProduto;

	public PedidoProdutoModel() {
		super();
	}

	public PedidoProdutoModel(Double produtoPreco) {
		this.totalProduto = produtoPreco;
	}

	public Double getTotalProduto() {
		return totalProduto;
	}

	public Long getIdpedidoproduto() {
		return idpedidoproduto;
	}

	public void setIdpedidoproduto(Long idpedidoproduto) {
		this.idpedidoproduto = idpedidoproduto;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public void setTotalProduto(Double totalProduto) {
		this.totalProduto = totalProduto;
	}

	private void calculaTotalProduto() {
		this.totalProduto = 0.0;

	}

}
