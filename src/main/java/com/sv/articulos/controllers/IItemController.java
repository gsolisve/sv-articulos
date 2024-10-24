package com.sv.articulos.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sv.articulos.models.ItemModel;

public interface IItemController {
	ItemModel save(ItemModel t);
	ItemModel update(ItemModel t , Integer id);
	List<ItemModel> findAll();
	Page<ItemModel> findAllPageable(Pageable pageable);
	ItemModel findById(Integer id);
	Boolean delete(Integer id);
	Boolean updateStatusItems(List<ItemModel> items);
}
