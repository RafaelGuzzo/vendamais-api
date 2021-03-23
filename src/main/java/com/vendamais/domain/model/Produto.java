package com.vendamais.domain.model;

public class Produto {

	private Long idProduto;
	private String codigo;
	private String descricao;
	private Double preco;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdproduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
