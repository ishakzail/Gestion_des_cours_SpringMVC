package com.este.dao;

import org.springframework.data.repository.CrudRepository;

import com.este.models.Etudiant;


public interface EtudiantDao extends CrudRepository<Etudiant, Integer>{

	public Etudiant findByEmail(String email);
}
