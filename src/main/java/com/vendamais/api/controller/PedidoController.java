package com.vendamais.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendamais.domain.model.Pedido;
import com.vendamais.domain.repository.PedidoRepository;
import com.vendamais.domain.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	@PostMapping
	public Pedido adicionarPedido(@RequestBody Pedido pedido) {
		return pedidoService.cadastraPedido(pedido);
	}

	@DeleteMapping("/{idpedido}")
	public void removerPedido(@PathVariable Long idpedido) {
		pedidoRepository.deleteById(idpedido);
	}


}
