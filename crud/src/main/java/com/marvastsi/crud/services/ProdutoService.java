package com.marvastsi.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.marvastsi.crud.data.vo.ProdutoVO;
import com.marvastsi.crud.entity.Produto;
import com.marvastsi.crud.exception.ResourceNotFoundException;
import com.marvastsi.crud.message.ProdutoSendMessage;
import com.marvastsi.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final ProdutoSendMessage produtoSendMessage;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository, ProdutoSendMessage produtoSendMessage) {
		this.produtoRepository = produtoRepository;
		this.produtoSendMessage = produtoSendMessage;
	}

	public ProdutoVO create(ProdutoVO produtoVO) {
		ProdutoVO prodVoRetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		produtoSendMessage.sendMessage(prodVoRetorno);
		return prodVoRetorno;
	}

	public Page<ProdutoVO> findAll(Pageable pageable) {
		var page = produtoRepository.findAll(pageable);
		return page.map(this::convertToProdutoVO);
	}

	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

	public ProdutoVO findById(long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ProdutoVO.create(entity);
	}

	public ProdutoVO update(ProdutoVO produtoVO) {
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());
		if (optionalProduto.isEmpty()) {
			new ResourceNotFoundException("No records found for this ID");
		}

		return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
	}

	public void delete(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		produtoRepository.delete(entity);
	}

}
