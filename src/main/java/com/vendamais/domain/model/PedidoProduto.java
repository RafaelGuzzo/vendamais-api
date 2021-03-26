package com.vendamais.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedidoproduto")
public class PedidoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpedidoproduto")
	private Long idPedidoProduto;

	@NotNull
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idpedido")
	private Pedido pedido;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idproduto")
	private Produto produto;

	public PedidoProduto() {

	}

	public PedidoProduto(Pedido pedido, Produto produto, Long quantidade) {
		super();
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	private Long quantidade;

	public Long getIdPedidoProduto() {
		return idPedidoProduto;
	}

	public void setIdPedidoProduto(Long idPedidoProduto) {
		this.idPedidoProduto = idPedidoProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

}
