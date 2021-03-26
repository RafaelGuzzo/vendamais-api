package com.vendamais.api.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vendamais.domain.model.Cliente;

public class PedidoInput {
	private Long numero;
	private OffsetDateTime dataPedido;
	private Cliente cliente;
	private List<PedidoProdutoInput> produtos = new ArrayList<>();

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoProdutoInput> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<PedidoProdutoInput> produtos) {
		this.produtos = produtos;
	}

}
