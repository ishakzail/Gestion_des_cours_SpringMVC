package com.este.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.este.models.Cour;
import com.este.models.Professeur;

@Repository("courRepository")
public interface CourDao extends CrudRepository<Cour, Integer>{
	List<Cour> findByProf(Professeur prof);
}
