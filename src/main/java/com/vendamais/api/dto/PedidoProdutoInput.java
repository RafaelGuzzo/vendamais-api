package com.vendamais.api.dto;

public class PedidoProdutoInput {
	
	private String produtoCodigo;
	private String produtoDescricao;
	private Double produtoPreco;
	private Long quantidade;

	

	public Long getQuantidade() {
		return quantidade;
	}

	public String getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(String produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public Double getProdutoPreco() {
		return produtoPreco;
	}

	public void setProdutoPreco(Double produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
}
