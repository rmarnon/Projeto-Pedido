package com.Rodrigo.Projeto_Pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rodrigo.Projeto_Pedido.domain.Produto;
import com.Rodrigo.Projeto_Pedido.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtorepository.findById(id);
		return obj.orElse(null);
	}
}
