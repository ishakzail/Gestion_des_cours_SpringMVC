package com.este.service;


import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.este.models.Cour;
import com.este.models.Professeur;

public interface ProfesseurService extends UserDetailsService{

	public Iterable<Professeur> selectAll();
	
	public Professeur save(Professeur professeur);
	
	public void delete(int id);
	
	public Professeur find(int id);
	
	
	
}
