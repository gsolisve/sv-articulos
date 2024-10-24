package com.sv.articulos.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.articulos.controllers.ICategoryController;
import com.sv.articulos.models.CategoryModel;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryApi {
	
	private final ICategoryController facade;
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryModel> getAccountantById(@PathVariable("id") Integer idItem){
		ResponseEntity<CategoryModel> response = null;
		response = new ResponseEntity<CategoryModel>( facade.findById(idItem) , HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/")
	public ResponseEntity<Page<CategoryModel>> findAllPageable(@RequestParam(name = "size" , defaultValue = "25") int size ,
			@RequestParam(name = "page" , defaultValue = "0") int page){
		ResponseEntity<Page<CategoryModel>> response = null;
		Pageable pageable = PageRequest.of(page, size);
		Page<CategoryModel> listProfiles  = facade.findAllPageable(pageable);
		response = new ResponseEntity<Page<CategoryModel>>(listProfiles, HttpStatus.OK);
		return response;
	}
	
		
	@PostMapping("/")
	public ResponseEntity<CategoryModel> save(@RequestBody CategoryModel model){
		ResponseEntity<CategoryModel> response = null;
		response = new ResponseEntity<CategoryModel>(facade.save(model), HttpStatus.CREATED);
		return response;
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryModel> save(@RequestBody CategoryModel model , @PathVariable("id") Integer idItem){
		ResponseEntity<CategoryModel> response = null;
		response = new ResponseEntity<CategoryModel>(facade.update(model , idItem), HttpStatus.CREATED);
		return response;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete( @PathVariable("id") Integer idCategory){
		ResponseEntity<Boolean> response = null;
		response = new ResponseEntity<Boolean >(facade.delete(idCategory), HttpStatus.OK);
		return response;
	}
	
	
}
