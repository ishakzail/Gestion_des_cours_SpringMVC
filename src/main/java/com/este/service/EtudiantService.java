package com.este.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.este.models.Etudiant;
import com.este.models.Professeur;

public interface EtudiantService extends UserDetailsService{
	
	
	public Iterable<Etudiant> selectAll();
	
	public Etudiant save(Etudiant etudiant);
	
	public void delete(int id);
	
	public Etudiant find(int id);
	
	public Etudiant getByEmail(String email);

}
