package com.este.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.este.dao.FichierDao;
import com.este.models.Fichier;


@Transactional
@Service("fichierService")
public class FichierServiceImpl implements FichierService{

	
	@Autowired
	private FichierDao fichierDao; 
	

	@Override
	public Iterable<Fichier> selectAll() {
		return fichierDao.findAll();
	}

	@Override
	public Fichier save(Fichier cour) {
		return fichierDao.save(cour);
	}

	@Override
	public void delete(int id) {
		fichierDao.deleteById(id);
		
	}

	@Override
	public Fichier find(int id) {
		return fichierDao.findById(id).get();
	}


}
