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
import com.vendamais.domain.model.Produto;
import com.vendamais.domain.model.SituacaoPedido;
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

	public PedidoModel buscaUmPedido(Long idpedido) {
		Pedido pedido = pedidoRepository.findById(idpedido).orElseThrow();
		return pedidoModel(pedido);
	}

	public List<PedidoModel> listarTodosPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoModel> pedidosRetorno = new ArrayList<>();

		for (Pedido pedido : pedidos) {

			pedidosRetorno.add(pedidoModel(pedido));
		}

		return pedidosRetorno;
	}

	public PedidoModel atualziarOuSalvaPedido(PedidoModel pedidoModel) {

		if (pedidoModel.getNumero() == null) {
			pedidoModel.setNumero(pedidoRepository.proximoNumeroPedido());
		}

		Pedido pedido = modelMapper.map(pedidoModel, Pedido.class);

		pedido.setCliente(clienteRepository.save(pedido.getCliente()));

		pedido = pedidoRepository.save(pedido);

		PedidoModel model = modelMapper.map(pedido, PedidoModel.class);

		for (PedidoProdutoModel pedidoProdutoModel : pedidoModel.getProdutos()) {

			model.getProdutos().add(savePedidoProduto(pedidoProdutoModel, pedido));
		}

		return model;
	}

	public PedidoModel finalizar(PedidoModel pedidoModel) {
		pedidoModel.setSituacao(SituacaoPedido.FINALIZADO);

		return atualziarOuSalvaPedido(pedidoModel);
	}

	public void deletePedidoProduto(Long idpedidoproduto) {
		pedidoProdutoRepository.deleteById(idpedidoproduto);

	}

	private PedidoProdutoModel savePedidoProduto(PedidoProdutoModel pedidoProdutoModel, Pedido pedido) {
		Produto produto = modelMapper.map(pedidoProdutoModel, Produto.class);
		produto.setIdproduto(pedidoProdutoModel.getProdutoId());
		produto = produtoRepository.save(produto);

		PedidoProduto pedidoProduto = new PedidoProduto(pedido, produto, pedidoProdutoModel.getQuantidade());
		pedidoProduto.setIdPedidoProduto(pedidoProdutoModel.getIdpedidoproduto());

		pedidoProduto = pedidoProdutoRepository.save(pedidoProduto);
		return toPedidoProdutoModel(pedidoProduto);
	}

	private PedidoProdutoModel toPedidoProdutoModel(PedidoProduto pedidoProduto) {
		PedidoProdutoModel pedidoProdutoModel = modelMapper.map(pedidoProduto, PedidoProdutoModel.class);

		if (pedidoProduto.getQuantidade() >= 0 && pedidoProduto.getProduto().getPreco() >= 0) {
			pedidoProdutoModel.setTotalProduto(pedidoProduto.getQuantidade() * pedidoProduto.getProduto().getPreco());
		}

		return pedidoProdutoModel;
	}

	private List<PedidoProdutoModel> toCollectionModel(List<PedidoProduto> pedidoProdutos) {
		return pedidoProdutos.stream().map(pedidoProduto -> toPedidoProdutoModel(pedidoProduto))
				.collect(Collectors.toList());
	}

	private PedidoModel pedidoModel(Pedido pedido) {
		PedidoModel model = modelMapper.map(pedido, PedidoModel.class);
		model.setProdutos(toCollectionModel(pedidoProdutoRepository.findByPedido(pedido)));
		return model;
	}

}
