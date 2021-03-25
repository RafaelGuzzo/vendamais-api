package com.vendamais.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendamais.domain.model.Cliente;
import com.vendamais.domain.model.Pedido;
import com.vendamais.domain.model.PedidoProduto;
import com.vendamais.domain.model.Produto;
import com.vendamais.domain.repository.ClienteRepository;
import com.vendamais.domain.repository.PedidoProdutoRepository;
import com.vendamais.domain.repository.PedidoRepository;
import com.vendamais.domain.repository.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Pedido cadastraPedido(Pedido pedido) {
		if (!pedido.temProdutos()) {
			return null;
		}

		List<PedidoProduto> produtos = new ArrayList<>();
		Cliente cliente = clienteRepository.save(pedido.getCliente());

		for (PedidoProduto pedidoproduto : pedido.getProdutos()) {
			Produto produto = produtoRepository.save(pedidoproduto.getProduto());
			pedidoproduto.setProduto(produto);
			pedidoproduto.setPedido(pedido);
			produtos.add(pedidoproduto);
		}

		pedido.setCliente(cliente);
		pedido.setProdutos(produtos);

		return pedidoRepository.save(pedido);
	}
}
