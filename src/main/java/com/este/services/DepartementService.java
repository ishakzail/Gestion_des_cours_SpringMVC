package com.este.services;

import java.util.List;

import com.este.models.Departement;

public interface DepartementService {

	
	public Departement save(Departement entity);
	
	public Departement update(Departement entity);
	
	public List<Departement> selectAll();
	
	public List<Departement> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public Departement getById(Long id);
	
	public Departement findOne(String paramName , Object paramValue);
	
	public Departement findOne(String[] paramName , Object[] paramValue);
}
