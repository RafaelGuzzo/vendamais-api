package com.vendamais.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vendamais.api.dto.PedidoInput;
import com.vendamais.api.dto.PedidoModel;
import com.vendamais.api.dto.PedidoResumoModel;
import com.vendamais.domain.model.PedidoProduto;
import com.vendamais.domain.repository.PedidoRepository;
import com.vendamais.domain.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(params = "resumo")
	public List<PedidoResumoModel> resumir(){
		return pedidoService.resumoPedidos();
	}
	
	@GetMapping
	public List<PedidoModel> listar() {
		return pedidoService.listarTodosPedidos();
	}

	@GetMapping("/{idpedido}")
	public PedidoModel buscaUmPedido(@PathVariable Long idpedido) {
		return pedidoService.buscaUmPedido(idpedido);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoModel adicionarPedido(@Valid @RequestBody PedidoInput pedidoModel) {
		return pedidoService.atualziarOuSalvaPedido(pedidoModel);
	}

	@PostMapping("/finalizar")
	public PedidoModel finalizar(@Valid @RequestBody PedidoInput pedidoModel) {
		return pedidoService.finalizar(pedidoModel);
	}

	@DeleteMapping("/{idpedido}")
	public void removerPedido(@PathVariable Long idpedido) {
		pedidoRepository.deleteById(idpedido);
	}

	@DeleteMapping("/{idpedido}/produto")
	public void removerPedidoProduto(@RequestBody PedidoProduto pedidoProduto) {
		pedidoService.deletePedidoProduto(pedidoProduto.getIdPedidoProduto());
	}

	@GetMapping("/numero-pedido")
	public Long proximoNumeroPedido() {
		return pedidoRepository.proximoNumeroPedido();
	}

}
