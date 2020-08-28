package com.este.service;


import com.este.models.Professeur;

public interface ProfesseurService {

	public Iterable<Professeur> selectAll();
	
	public Professeur save(Professeur professeur);
	
	public void delete(int id);
	
	public Professeur find(int id);
}
