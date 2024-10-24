package com.sv.articulos.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.articulos.models.ItemModel;
import com.sv.articulos.repository.IGenericRepo;
import com.sv.articulos.repository.IItemRepository;
import com.sv.articulos.services.IItemService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ItemServiceImpl extends CrudImpl<ItemModel, Integer> implements IItemService{

	private final IItemRepository repo; 
	
	@Override
	protected IGenericRepo<ItemModel, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<ItemModel> findAllById(List<ItemModel> items) {
		// TODO Auto-generated method stub
		List<Integer> ids = items.stream().map( item -> item.getId()).toList();
		return repo.findAllById(ids);
	}
	

	@Override
	public List<ItemModel> saveAll(List<ItemModel> items) {
		return repo.saveAll(items);
	}
	
	

}
