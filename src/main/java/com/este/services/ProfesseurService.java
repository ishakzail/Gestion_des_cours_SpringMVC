package com.este.services;

import java.util.List;

import com.este.models.Professeur;

public interface ProfesseurService {

	public Professeur save(Professeur entity);
	
	public Professeur update(Professeur entity);
	
	public List<Professeur> selectAll();
	
	public List<Professeur> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public Professeur getById(Long id);
	
	public Professeur findOne(String paramName , Object paramValue);
	
	public Professeur findOne(String[] paramName , Object[] paramValue);

}
