package com.sv.articulos.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sv.articulos.models.CategoryModel;

public interface ICategoryController {
	CategoryModel save(CategoryModel t);
	CategoryModel update(CategoryModel t , Integer id);
	List<CategoryModel> findAll();
	Page<CategoryModel> findAllPageable(Pageable pageable);
	CategoryModel findById(Integer id);
	Boolean delete(Integer id);
}
