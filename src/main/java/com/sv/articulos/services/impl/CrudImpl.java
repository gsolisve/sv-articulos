package com.sv.articulos.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sv.articulos.repository.IGenericRepo;
import com.sv.articulos.services.ICrud;

public abstract class CrudImpl<T , ID>  implements ICrud<T, ID>{
	Logger logger = LoggerFactory.getLogger(CrudImpl.class);
	protected abstract IGenericRepo< T, ID> getRepo();

	
	@Override
	public T save(T t) {

		return getRepo().save(t);
	}

	@Override
	public T update(T t, ID id) {

		return !getRepo().findById(id).isEmpty() ? getRepo().save(t) : null;
		//return getRepo().save(t);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}
	
	@Override
	public Page<T> findAllPageable(Pageable pageable) {
		return getRepo().findAll(pageable);
	}
	


	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return getRepo().findById(id);
	}

	@Override
	public Boolean delete(ID id) {
		// TODO Auto-generated method stub
	
		if(!getRepo().findById(id).isEmpty()) {
			getRepo().deleteById(id); 
			return true;
		}
		return false;
	}

     
}
