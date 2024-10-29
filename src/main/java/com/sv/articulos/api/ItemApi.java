package com.sv.articulos.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.articulos.controllers.IItemController;
import com.sv.articulos.controllers.impl.ItemWebSocketController;
import com.sv.articulos.models.ItemModel;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemApi {
	
	private final IItemController facade;
	
	  
    private final ItemWebSocketController webSocketController;
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemModel> getAccountantById(@PathVariable("id") Integer idItem){
		ResponseEntity<ItemModel> response = null;
		response = new ResponseEntity<ItemModel>( facade.findById(idItem) , HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/")
	public ResponseEntity<Page<ItemModel>> findAllPageable(@RequestParam(name = "size" , defaultValue = "25") int size ,
			@RequestParam(name = "page" , defaultValue = "0") int page){
		ResponseEntity<Page<ItemModel>> response = null;
		Pageable pageable = PageRequest.of(page, size , Sort.by(Sort.Direction.ASC,"id"));
		Page<ItemModel> listProfiles  = facade.findAllPageable(pageable);
		response = new ResponseEntity<Page<ItemModel>>(listProfiles, HttpStatus.OK);
		return response;
	}
	
		
	@PostMapping("/")
	public ResponseEntity<ItemModel> save(@RequestBody ItemModel model){
		ResponseEntity<ItemModel> response = null;
		ItemModel savedItem = facade.save(model);
		webSocketController.notifyItemCreated(savedItem);
		response = new ResponseEntity<ItemModel>(savedItem, HttpStatus.CREATED);
		return response;
	}
	
	@PostMapping("/testws")
	public ResponseEntity<ItemModel> testws(@RequestBody ItemModel model){
		ResponseEntity<ItemModel> response = null;
		//ItemModel savedItem = facade.save(model);
		webSocketController.notifyItemCreated(model);
		response = new ResponseEntity<ItemModel>(model, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemModel> update(@RequestBody ItemModel model , @PathVariable("id") Integer idItem){
		ResponseEntity<ItemModel> response = null;
		ItemModel updatedItem = facade.update(model , idItem);
		webSocketController.notifyItemCreated(updatedItem);
		response = new ResponseEntity<ItemModel>( updatedItem, HttpStatus.OK);
		return response;
	}
	
	@PatchMapping("/status")
	public ResponseEntity<Boolean> updateStatus(@RequestBody List<ItemModel> items ){
		ResponseEntity<Boolean> response = null;
		response = new ResponseEntity<Boolean >(facade.updateStatusItems(items), HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete( @PathVariable("id") Integer idItem){
		ResponseEntity<Boolean> response = null;
		response = new ResponseEntity<Boolean >(facade.delete(idItem), HttpStatus.OK);
		return response;
	}
}
