package com.vendamais.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.vendamais.domain.exception.NegocioException;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpedido")
	private Long idPedido;

	@NotNull
	private Long numero;

	@Enumerated(EnumType.STRING)
	private SituacaoPedido situacao;

	@NotNull
	@Column(name = "datapedido")
	private OffsetDateTime dataPedido;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

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

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

	public boolean pedidoFinalizado() {
		return SituacaoPedido.FINALIZADO.equals(getSituacao());
	}

	public void finalizar() {
		if (pedidoFinalizado()) {
			throw new NegocioException("Pedido não pode ser finalizado! Situação:" + getSituacao());
		}

		setSituacao(SituacaoPedido.FINALIZADO);
	}

}
