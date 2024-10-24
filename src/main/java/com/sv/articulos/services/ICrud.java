package com.sv.articulos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICrud<T,ID> {
	T save(T t);
	T update(T t , ID id);
	List<T> findAll();
	Page<T> findAllPageable(Pageable pageable);
	Optional<T> findById(ID id);
	Boolean delete(ID id);
	
	
}
