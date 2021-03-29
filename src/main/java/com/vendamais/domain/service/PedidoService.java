package com.vendamais.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendamais.api.dto.PedidoInput;
import com.vendamais.api.dto.PedidoModel;
import com.vendamais.api.dto.PedidoProdutoModel;
import com.vendamais.api.dto.PedidoResumoModel;
import com.vendamais.domain.exception.EntidadeNaoEncontradaException;
import com.vendamais.domain.exception.NegocioException;
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
		Pedido pedido = pedidoRepository.findById(idpedido)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Pedido não encontrado!"));
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

	public PedidoModel atualziarOuSalvaPedido(PedidoInput pedidoInput) {

		Pedido pedido = modelMapper.map(pedidoInput, Pedido.class);

		if (pedido.getIdPedido() == null) {
			pedido.setSituacao(SituacaoPedido.ABERTO);
		} else {
			Pedido pedidoSalvoNoBanco = pedidoRepository.findById(pedido.getIdPedido())
					.orElseThrow(() -> new EntidadeNaoEncontradaException("Pedido não encontrado!"));

			if (pedidoSalvoNoBanco.pedidoFinalizado()) {
				throw new NegocioException("Não é permitido alterar pedido Já Finalizado!");
			}

			pedido.getCliente().setIdcliente(pedidoSalvoNoBanco.getCliente().getIdCliente());
			pedido.setSituacao(pedidoSalvoNoBanco.getSituacao());
		}

		pedido.setCliente(clienteRepository.save(pedido.getCliente()));

		if (pedido.getNumero() == null) {
			pedido.setNumero(pedidoRepository.proximoNumeroPedido());
		}

		pedido = pedidoRepository.save(pedido);

		PedidoModel model = modelMapper.map(pedido, PedidoModel.class);

		for (PedidoProdutoModel pedidoProdutoModel : pedidoInput.getProdutos()) {

			model.getProdutos().add(savePedidoProduto(pedidoProdutoModel, pedido));
		}

		return model;
	}

	public PedidoModel finalizar(PedidoInput pedidoInput) {

		PedidoModel model = atualziarOuSalvaPedido(pedidoInput);

		Pedido pedido = modelMapper.map(model, Pedido.class);

		pedido.finalizar();
		pedido = pedidoRepository.save(pedido);

		model.setSituacao(pedido.getSituacao());

		return model;
	}

	public void deletePedidoProduto(Long idpedidoproduto) {
		PedidoProduto pedidoProduto = pedidoProdutoRepository.findById(idpedidoproduto)
				.orElseThrow(() -> new NegocioException("Vinculo do produto com o pedido não encontrado!"));
		pedidoProdutoRepository.delete(pedidoProduto);

	}

	public List<PedidoResumoModel> resumoPedidos() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoResumoModel> pedidosRetorno = new ArrayList<>();

		for (Pedido pedido : pedidos) {

			pedidosRetorno.add(pedidoResumoModel(pedido));
		}

		return pedidosRetorno;
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

	private PedidoResumoModel pedidoResumoModel(Pedido pedido) {
		PedidoResumoModel model = modelMapper.map(pedido, PedidoResumoModel.class);
		List<PedidoProduto> produtos = pedidoProdutoRepository.findByPedido(pedido);
		model.setCnpj(pedido.getCliente().getCnpj());
		model.setRazaoSocial(pedido.getCliente().getRazaoSocial());
		model.setQtdProdutos(produtos.size());
		int qtdItens = 0;
		Double totalPedido = 0.0;

		for (PedidoProduto produto : produtos) {
			qtdItens += produto.getQuantidade();
			totalPedido += (produto.getQuantidade() * produto.getProduto().getPreco());
		}

		model.setQtdItens(qtdItens);
		model.setTotalPedido(totalPedido);

		return model;
	}

}
