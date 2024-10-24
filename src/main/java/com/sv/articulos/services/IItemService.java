package com.sv.articulos.services;

import java.util.List;

import com.sv.articulos.models.ItemModel;

public interface IItemService extends ICrud<ItemModel, Integer>{
	List<ItemModel> findAllById(List<ItemModel> items);
	List<ItemModel> saveAll(List<ItemModel> items);
}
