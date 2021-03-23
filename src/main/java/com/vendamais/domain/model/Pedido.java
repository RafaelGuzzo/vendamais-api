package com.vendamais.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	private Long numero;
	private OffsetDateTime dataPedido;

	@ManyToOne
	private Cliente cliente;

	@OneToMany
	@JoinTable(
			name = "PedidoProduto", 
			joinColumns = @JoinColumn(name = "idpedido"), 
			inverseJoinColumns = @JoinColumn(name = "idproduto"))
	private List<Produto> produtos;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdpedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
