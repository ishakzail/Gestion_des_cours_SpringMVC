package com.este.dao;

import java.util.List;

public interface GenericDao<E> {
	
	public E save(E entity);
	
	public E update(E entity);
	
	public List<E> selectAll();
	
	public List<E> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public E getById(Long id);
	
	public E findOne(String paramName , Object paramValue);
	
	public E findOne(String[] paramName , Object[] paramValue);
	
	
	
}
