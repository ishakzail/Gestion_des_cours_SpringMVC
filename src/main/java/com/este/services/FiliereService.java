package com.este.services;

import java.util.List;

import com.este.models.Filiere;

public interface FiliereService {
	
	public Filiere save(Filiere entity);
	
	public Filiere update(Filiere entity);
	
	public List<Filiere> selectAll();
	
	public List<Filiere> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public Filiere getById(Long id);
	
	public Filiere findOne(String paramName , Object paramValue);
	
	public Filiere findOne(String[] paramName , Object[] paramValue);

}
