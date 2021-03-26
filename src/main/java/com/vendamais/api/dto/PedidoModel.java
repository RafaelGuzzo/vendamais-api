package com.vendamais.api.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vendamais.domain.model.Cliente;
import com.vendamais.domain.model.SituacaoPedido;

public class PedidoModel {

	private Long idpedido;

	private Long numero;

	@NotNull
	private SituacaoPedido situacao;

	@NotNull
	private OffsetDateTime dataPedido;

	@Valid
	@NotNull
	private Cliente cliente;

	@NotEmpty
	private List<PedidoProdutoModel> produtos = new ArrayList<>();

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

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProdutoModel> produtos) {
		this.produtos = produtos;
	}

}
