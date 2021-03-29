package com.vendamais.api.dto;

import javax.validation.constraints.NotNull;

import com.vendamais.domain.model.SituacaoPedido;

public class PedidoModel extends  PedidoInput{

	@NotNull
	private SituacaoPedido situacao;
	 
	
	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}

}
