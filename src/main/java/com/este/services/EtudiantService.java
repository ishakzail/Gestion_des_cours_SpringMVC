package com.este.services;

import java.util.List;

import com.este.models.Etudiant;

public interface EtudiantService {
	
	public Etudiant save(Etudiant entity);
	
	public Etudiant update(Etudiant entity);
	
	public List<Etudiant> selectAll();
	
	public List<Etudiant> selectAll(String sortField , String sort);
	
	public void remove(Long id);
	
	public Etudiant getById(Long id);
	
	public Etudiant findOne(String paramName , Object paramValue);
	
	public Etudiant findOne(String[] paramName , Object[] paramValue);


}
