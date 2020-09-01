package com.este.service;

import java.util.List;

import com.este.models.Cour;
import com.este.models.Professeur;

public interface CourService {

	public List<Cour> selectAll(Professeur prof);
	
	public Cour save(Cour cour);
	
	public void delete(int id);
	
	public Cour find(int id);
	
	
	
	
	
}
