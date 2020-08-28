package com.este.service;

import com.este.models.Fichier;

public interface FichierService {

	public Iterable<Fichier> selectAll();
	
	public Fichier save(Fichier fichier);
	
	public void delete(int id);
	
	public Fichier find(int id);
}
