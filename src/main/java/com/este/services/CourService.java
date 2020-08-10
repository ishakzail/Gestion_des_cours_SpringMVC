package com.este.services;

import java.util.List;

import com.este.models.Cour;

public interface CourService {
	
	public Cour save(Cour entity);
	
	public Cour update(Cour entity);
	
	public List<Cour> selectAll();
	
	public List<Cour> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public Cour getById(Long id);
	
	public Cour findOne(String paramName , Object paramValue);
	
	public Cour findOne(String[] paramName , Object[] paramValue);

}
