package com.este.service;


import org.springframework.security.core.userdetails.UserDetailsService;


import com.este.models.Professeur;

public interface ProfesseurService extends UserDetailsService{

	public Iterable<Professeur> selectAll();
	
	public Professeur save(Professeur professeur);
	
	public void delete(int id);
	
	public Professeur find(int id);
	
	public Professeur getByEmail(String email);
	
	
	
}
