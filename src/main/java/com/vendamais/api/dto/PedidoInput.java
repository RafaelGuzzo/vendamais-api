package com.vendamais.api.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vendamais.domain.model.Cliente;

public class PedidoInput {
	private Long numero;
	private OffsetDateTime datapedido;
	private Cliente cliente;
	private List<PedidoProdutoModel> produtos = new ArrayList<>();

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public OffsetDateTime getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(OffsetDateTime datapedido) {
		this.datapedido = datapedido;
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
