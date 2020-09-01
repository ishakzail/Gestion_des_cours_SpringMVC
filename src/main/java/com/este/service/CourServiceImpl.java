package com.este.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.este.dao.CourDao;
import com.este.dao.ProfesseurDao;
import com.este.models.Cour;
import com.este.models.Professeur;

@Transactional
@Service("courService")
public class CourServiceImpl implements CourService{

	@Autowired
	private ProfesseurDao professeurDao;
	
	@Autowired
	private CourDao courDao; 
	
	@Override
	public List<Cour> selectAll(Professeur prof) {
		return courDao.findByProf(prof);
	}

	@Override
	public Cour save(Cour cour) {
		return courDao.save(cour);
	}

	@Override
	public void delete(int id) {
		courDao.deleteById(id);
		
	}

	@Override
	public Cour find(int id) {
		return courDao.findById(id).get();
	}

	

	
	
	

}
