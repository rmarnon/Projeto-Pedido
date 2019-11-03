package com.Rodrigo.Projeto_Pedido.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rodrigo.Projeto_Pedido.domain.Categoria;
import com.Rodrigo.Projeto_Pedido.repositories.CategoriaRepository;
import com.Rodrigo.Projeto_Pedido.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! id: " + id 
				+ ", Tipo: " + Categoria.class.getName()));
	}
	
}
