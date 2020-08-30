package com.este.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.este.dao.CourDao;
import com.este.models.Cour;

@Transactional
@Service("courService")
public class CourServiceImpl implements CourService{

	
	@Autowired
	private CourDao courDao; 
	
	@Override
	public Iterable<Cour> selectAll() {
		return courDao.findAll();
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
