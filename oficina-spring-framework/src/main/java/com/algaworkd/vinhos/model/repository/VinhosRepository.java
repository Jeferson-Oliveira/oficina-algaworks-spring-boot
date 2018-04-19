package com.algaworkd.vinhos.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworkd.vinhos.model.entity.Vinho;

public interface VinhosRepository extends JpaRepository<Vinho, Long>{
	
}
