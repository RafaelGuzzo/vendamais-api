package com.vendamais.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendamais.api.dto.PedidoModel;
import com.vendamais.api.dto.PedidoProdutoModel;
import com.vendamais.domain.model.Pedido;
import com.vendamais.domain.model.PedidoProduto;
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

	@Autowired
	private ModelMapper modelMapper;

	public List<PedidoModel> listarTodosPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoModel> pedidosRetorno = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			PedidoModel model = modelMapper.map(pedido, PedidoModel.class);
			model.setProdutos(toCollectionModel(pedidoProdutoRepository.findByPedido(pedido)));
			pedidosRetorno.add(model);
		}

		return pedidosRetorno;
	}

	/*
	 * public Pedido cadastraPedido(Pedido pedido) { if (!pedido.temProdutos()) {
	 * return null; }
	 * 
	 * List<PedidoProduto> produtos = new ArrayList<>(); Cliente cliente =
	 * clienteRepository.save(pedido.getCliente());
	 * 
	 * for (PedidoProduto pedidoproduto : pedido.getProdutos()) { Produto produto =
	 * produtoRepository.save(pedidoproduto.getProduto());
	 * pedidoproduto.setProduto(produto); pedidoproduto.setPedido(pedido);
	 * produtos.add(pedidoproduto); }
	 * 
	 * pedido.setCliente(cliente); pedido.setProdutos(produtos);
	 * 
	 * return pedidoRepository.save(pedido); }
	 */

	private PedidoProdutoModel toPedidoProdutoModel(PedidoProduto pedidoProduto) {
		return modelMapper.map(pedidoProduto, PedidoProdutoModel.class);
	}

	private List<PedidoProdutoModel> toCollectionModel(List<PedidoProduto> pedidoProdutos) {
		return pedidoProdutos.stream().map(pedidoProduto -> toPedidoProdutoModel(pedidoProduto))
				.collect(Collectors.toList());
	}

}
