package com.este.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.este.dao.FiliereDao;
import com.este.models.Filiere;


@Transactional
public class FiliereServiceImpl implements FiliereService{
	
	private FiliereDao dao;
	
	public void setDao(FiliereDao dao) {
		this.dao = dao;
	}

	@Override
	public Filiere save(Filiere entity) {
		return dao.save(entity);
	}

	@Override
	public Filiere update(Filiere entity) {
		return dao.update(entity);
	}

	@Override
	public List<Filiere> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Filiere> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Filiere getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Filiere findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Filiere findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
