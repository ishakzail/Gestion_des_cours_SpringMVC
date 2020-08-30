package com.este.service;

import com.este.models.Cour;

public interface CourService {

	public Iterable<Cour> selectAll();
	
	public Cour save(Cour cour);
	
	public void delete(int id);
	
	public Cour find(int id);
	
	
}
