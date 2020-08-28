package com.este.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.este.dao.ProfesseurDao;
import com.este.models.Professeur;

@Transactional
@Service("professeurService")
public class ProfesseurServiceImpl implements ProfesseurService{

	

	@Autowired
	private ProfesseurDao professeurDao; 
	

	@Override
	public Iterable<Professeur> selectAll() {
		return professeurDao.findAll();
	}

	@Override
	public Professeur save(Professeur professeur) {
		return professeurDao.save(professeur);
	}

	@Override
	public void delete(int id) {
		professeurDao.deleteById(id);
		
	}

	@Override
	public Professeur find(int id) {
		return professeurDao.findById(id).get();
	}
}
