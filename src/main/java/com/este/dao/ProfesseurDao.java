package com.este.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.este.models.Cour;
import com.este.models.Professeur;

public interface ProfesseurDao extends CrudRepository<Professeur, Integer>{

	public Professeur findByEmail(String email);
	
	
}
