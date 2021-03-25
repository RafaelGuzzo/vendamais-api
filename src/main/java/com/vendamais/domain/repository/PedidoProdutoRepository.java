package com.vendamais.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendamais.domain.model.Pedido;
import com.vendamais.domain.model.PedidoProduto;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

	List<PedidoProduto> findByPedido(Pedido idpedido);

}
