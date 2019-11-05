package com.Rodrigo.Projeto_Pedido;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Rodrigo.Projeto_Pedido.domain.Categoria;
import com.Rodrigo.Projeto_Pedido.domain.Cidade;
import com.Rodrigo.Projeto_Pedido.domain.Cliente;
import com.Rodrigo.Projeto_Pedido.domain.Endereco;
import com.Rodrigo.Projeto_Pedido.domain.Estado;
import com.Rodrigo.Projeto_Pedido.domain.Pagamento;
import com.Rodrigo.Projeto_Pedido.domain.PagamentoBoleto;
import com.Rodrigo.Projeto_Pedido.domain.PagamentoCartao;
import com.Rodrigo.Projeto_Pedido.domain.Pedido;
import com.Rodrigo.Projeto_Pedido.domain.Produto;
import com.Rodrigo.Projeto_Pedido.domain.enums.EstadoPagamento;
import com.Rodrigo.Projeto_Pedido.domain.enums.TipoCliente;
import com.Rodrigo.Projeto_Pedido.repositories.CategoriaRepository;
import com.Rodrigo.Projeto_Pedido.repositories.CidadeRepository;
import com.Rodrigo.Projeto_Pedido.repositories.ClienteRepository;
import com.Rodrigo.Projeto_Pedido.repositories.EnderecoRepository;
import com.Rodrigo.Projeto_Pedido.repositories.EstadoRepository;
import com.Rodrigo.Projeto_Pedido.repositories.PagamentoRepository;
import com.Rodrigo.Projeto_Pedido.repositories.PedidoReppository;
import com.Rodrigo.Projeto_Pedido.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoPedidoApplication implements CommandLineRunner{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;	
	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private CidadeRepository cidadeRepository;	
	@Autowired
	private EnderecoRepository enderecoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoReppository pedidorepository;
	
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
		
		//-----------------------------------------------------------------
		
		Estado es1 = new Estado(null, "Minas Gerais");
		Estado es2 = new Estado(null, "Parana");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", es1);
		Cidade c2 = new Cidade(null, "Maringa", es2);
		
		es1.getCidades().add(c1);
		es2.getCidades().add(c2);
		
		estadoRepository.saveAll(Arrays.asList(es1, es2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
		//-----------------------------------------------------------------
		
		Cliente cli1 = new Cliente(null, "Rodrigo Marnon", "rmarnon@yahoo", 
				"123456789-0", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("32245897", "999877654"));
		
		Endereco end1 = new Endereco(null, "Rua Tadeu Shalkoski", "1489", "Casa", 
				"Jardim Botanico", "87060-538", c2, cli1);		
		Endereco end2 = new Endereco(null, "Av Savassi", "885", "Sobrado", 
				"Ouro Preto", "38974-544", c1, cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		//-----------------------------------------------------------------
		
		Pedido pe1 = new Pedido(null, sdf.parse("05/11/2019 04:08:00"), cli1, end2);
		Pedido pe2 = new Pedido(null, sdf.parse("01/11/2019 20:19:10"), cli1, end1);
		
		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, pe1, 5);
		pe1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, pe2, 
				sdf.parse("28/10/2019 00:00:00"), null);
		pe2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(pe1, pe2));
		
		pedidorepository.saveAll(Arrays.asList(pe1, pe2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
	}

}
