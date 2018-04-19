package com.algaworkd.vinhos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworkd.vinhos.model.entity.Vinho;
import com.algaworkd.vinhos.model.repository.VinhosRepository;

@Service
public class VinhosService {
	
	@Autowired
	private VinhosRepository repository;

	public void salvar(Vinho vinho) {
		getRepository().save(vinho);
	}
	
	public Vinho buscarPorId(Long id) {
		return getRepository().findById(id).get(); 
	}
	
	public List<Vinho> listarTodos() {
		return getRepository().findAll();
	}
	
	
	
	public VinhosRepository getRepository() {
		return repository;
	}
	
	public void setRepository(VinhosRepository repository) {
		this.repository = repository;
	}

}
