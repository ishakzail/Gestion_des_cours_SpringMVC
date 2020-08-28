package com.este.service;

import com.este.models.Etudiant;

public interface EtudiantService {
	
	
	public Iterable<Etudiant> selectAll();
	
	public Etudiant save(Etudiant etudiant);
	
	public void delete(int id);
	
	public Etudiant find(int id);

}
