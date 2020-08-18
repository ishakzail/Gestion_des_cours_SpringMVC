package com.este.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.este.dao.DepartementDao;
import com.este.models.Departement;


@Transactional
public class DepartementServiceImpl implements DepartementService{

	private DepartementDao dao;
	
	public void setDao(DepartementDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Departement save(Departement entity) {
		return dao.save(entity);
	}

	@Override
	public Departement update(Departement entity) {
		return dao.update(entity);
	}

	@Override
	public List<Departement> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Departement> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Departement getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Departement findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Departement findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
