package com.vendamais.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vendamais.domain.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	@Query(value = "select nextval('numeropedido_sequence')", nativeQuery = true)
	Long proximoNumeroPedido();
}
