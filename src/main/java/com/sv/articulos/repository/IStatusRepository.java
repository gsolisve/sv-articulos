package com.sv.articulos.repository;

import java.util.List;

import com.sv.articulos.models.StatusModel;

public interface IStatusRepository extends IGenericRepo<StatusModel , Integer>{
	List<StatusModel>  findByName(String name);
}
