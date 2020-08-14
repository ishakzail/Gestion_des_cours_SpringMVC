package com.este.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.este.dao.ProfesseurDao;
import com.este.models.Professeur;

@Transactional
public class ProfesseurServiceImpl implements ProfesseurService{

	private ProfesseurDao dao;
	
	
	public void setDao(ProfesseurDao dao) {
		this.dao = dao;
	}

	@Override
	public Professeur save(Professeur entity) {
		return dao.save(entity);
	}

	@Override
	public Professeur update(Professeur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Professeur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Professeur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Professeur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Professeur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Professeur findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}


}
