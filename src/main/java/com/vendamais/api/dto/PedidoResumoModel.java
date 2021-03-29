package com.vendamais.api.dto;

import java.time.OffsetDateTime;

import com.vendamais.domain.model.SituacaoPedido;

public class PedidoResumoModel {
	private Long idpedido;
	private Long numero;
	private OffsetDateTime dataPedido;
	private SituacaoPedido situacao;
	private String razaoSocial;
	private String cnpj;
	private Integer qtdProdutos;
	private Integer qtdItens;
	private Double totalPedido;
	
	public PedidoResumoModel() {
		
	}

	public PedidoResumoModel(Long idpedido, Long numero, OffsetDateTime dataPedido, SituacaoPedido situacao,
			String razaoSocial, String cnpj, Integer qtdProdutos, Integer qtdItens, Double totalPedido) {
		super();
		this.idpedido = idpedido;
		this.numero = numero;
		this.dataPedido = dataPedido;
		this.situacao = situacao;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.qtdProdutos = qtdProdutos;
		this.qtdItens = qtdItens;
		this.totalPedido = totalPedido;
	}

	public Long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

}
