package com.sv.articulos.services;

import java.util.List;

import com.sv.articulos.models.StatusModel;

public interface IStatusService extends ICrud<StatusModel, Integer> {
	List<StatusModel> findByName(String nameStatus);
}
