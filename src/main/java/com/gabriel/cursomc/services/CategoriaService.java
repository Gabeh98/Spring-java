package com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.cursomc.domain.Categoria;
import com.gabriel.cursomc.repositories.CategoriaRepository;
import com.gabriel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);// faz a listagem de objetos por id
		return obj.orElseThrow(() -> new ObjectNotFoundException(// Exception para quando vier o obj for nulo
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	} 

}
