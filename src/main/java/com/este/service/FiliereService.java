package com.este.service;

import com.este.models.Filiere;

public interface FiliereService {
	
	public Iterable<Filiere> selectAll();
	
	public Filiere save(Filiere filiere);
	
	public void delete(int id);
	
	public Filiere find(int id);

}
