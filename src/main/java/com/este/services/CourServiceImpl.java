package com.este.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.este.dao.CourDao;
import com.este.models.Cour;

/* l'annotation Transactional pour les transactions avec la base de donnée */

@Transactional
public class CourServiceImpl implements CourService{

	private CourDao dao;
	
	public void setDao(CourDao dao) {
		this.dao = dao;
	}

	@Override
	public Cour save(Cour entity) {
		return dao.save(entity);
	}

	@Override
	public Cour update(Cour entity) {
		return dao.update(entity);
	}

	@Override
	public List<Cour> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Cour> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Cour getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Cour findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Cour findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
