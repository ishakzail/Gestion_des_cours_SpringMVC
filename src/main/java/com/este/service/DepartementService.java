package com.este.service;

import com.este.models.Departement;

public interface DepartementService {
	
	public Iterable<Departement> selectAll();
	
	public Departement save(Departement product);
	
	public void delete(int id);
	
	public Departement find(int id);

}
