package com.sv.articulos.controllers.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sv.articulos.controllers.ICategoryController;
import com.sv.articulos.models.CategoryModel;
import com.sv.articulos.services.ICategoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryControllerImpl implements ICategoryController{
	
	
	private final ICategoryService service;
	
	@Override
	public CategoryModel save(CategoryModel t) {
		// TODO Auto-generated method stub
		return service.save(t);
	}

	@Override
	public CategoryModel update(CategoryModel t, Integer id) {
		// TODO Auto-generated method stub
		return service.update(t,id);
	}

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public Page<CategoryModel> findAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return service.findAllPageable(pageable);
	}

	@Override
	public CategoryModel findById(Integer id) {
		// TODO Auto-generated method stub
		return service.findById(id).orElse(null);
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return service.delete(id);
	}

}
