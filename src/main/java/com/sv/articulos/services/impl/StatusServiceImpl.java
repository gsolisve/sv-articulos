package com.sv.articulos.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.articulos.models.StatusModel;
import com.sv.articulos.repository.IGenericRepo;
import com.sv.articulos.repository.IStatusRepository;
import com.sv.articulos.services.IStatusService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class StatusServiceImpl extends CrudImpl<StatusModel, Integer> implements IStatusService{

	private final IStatusRepository repo; 
	
	@Override
	protected IGenericRepo<StatusModel, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<StatusModel> findByName(String nameStatus) {
		// TODO Auto-generated method stub
		return repo.findByName(nameStatus);
	}
	
	

}
