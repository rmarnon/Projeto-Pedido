package com.Rodrigo.Projeto_Pedido;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Rodrigo.Projeto_Pedido.domain.Categoria;
import com.Rodrigo.Projeto_Pedido.domain.Cidade;
import com.Rodrigo.Projeto_Pedido.domain.Estado;
import com.Rodrigo.Projeto_Pedido.domain.Produto;
import com.Rodrigo.Projeto_Pedido.repositories.CategoriaRepository;
import com.Rodrigo.Projeto_Pedido.repositories.CidadeRepository;
import com.Rodrigo.Projeto_Pedido.repositories.EstadoRepository;
import com.Rodrigo.Projeto_Pedido.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Eletronico");
		Categoria cat3 = new Categoria(null, "Games");
		
		Produto p1 = new Produto(null, "Monitor", 500.00);
		Produto p2 = new Produto(null, "Mouse", 50.00);
		Produto p3 = new Produto(null, "Xbox", 1200.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat3.getProdutos().add(p3);
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat2, cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado es1 = new Estado(null, "Minas Gerais");
		Estado es2 = new Estado(null, "Parana");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", es1);
		Cidade c2 = new Cidade(null, "Maringa", es2);
		
		es1.getCidades().add(c1);
		es2.getCidades().add(c2);
		
		estadoRepository.saveAll(Arrays.asList(es1, es2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
	}

}
