package com.este.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.este.dao.FichierDao;
import com.este.models.Fichier;

@Transactional
@Service("fichierService")
public class FichierServiceImpl implements FichierService{

	
	@Autowired
	private FichierDao fichierDao; 

	
	@Override
	public void delete(int id) {
		fichierDao.deleteById(id);
		
	}


	@Override
	public Iterable<Fichier> getFichiers() {
		return fichierDao.findAll();
	}






	@Override
	public Fichier save(Fichier fichier) {
		return fichierDao.save(fichier);
	}

	

}
