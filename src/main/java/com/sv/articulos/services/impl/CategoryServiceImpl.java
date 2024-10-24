package com.sv.articulos.services.impl;

import org.springframework.stereotype.Service;

import com.sv.articulos.models.CategoryModel;
import com.sv.articulos.repository.ICategoryRepository;
import com.sv.articulos.repository.IGenericRepo;
import com.sv.articulos.services.ICategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CrudImpl<CategoryModel, Integer> implements ICategoryService{

	private final ICategoryRepository repo; 
	
	@Override
	protected IGenericRepo<CategoryModel, Integer> getRepo() {
		return repo;
	}
	
	

}
