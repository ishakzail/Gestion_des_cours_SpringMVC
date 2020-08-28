package com.este.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.este.dao.FiliereDao;
import com.este.models.Filiere;

@Transactional
@Service("filiereService")
public class FiliereServiceImpl implements FiliereService{

	
	@Autowired
	private FiliereDao filiereDao; 
	

	@Override
	public Iterable<Filiere> selectAll() {
		return filiereDao.findAll();
	}

	@Override
	public Filiere save(Filiere filiere) {
		return filiereDao.save(filiere);
	}

	@Override
	public void delete(int id) {
		filiereDao.deleteById(id);
		
	}

	@Override
	public Filiere find(int id) {
		return filiereDao.findById(id).get();
	}
}
