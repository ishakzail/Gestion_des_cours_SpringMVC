package com.este.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.este.dao.EtudiantDao;
import com.este.models.Etudiant;

@Transactional
@Service("etudiantService")
public class EtudiantServiceImpl implements EtudiantService{

	
	@Autowired
	private EtudiantDao etudiantDao; 
	
	@Override
	public Iterable<Etudiant> selectAll() {
		return etudiantDao.findAll();
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		return etudiantDao.save(etudiant);
	}

	@Override
	public void delete(int id) {
		etudiantDao.deleteById(id);
		
	}

	@Override
	public Etudiant find(int id) {
		return etudiantDao.findById(id).get();
	}


}
