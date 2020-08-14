package com.este.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.este.dao.EtudiantDao;
import com.este.models.Etudiant;

@Transactional
public class EtudiantServiceImpl implements EtudiantService {

	private EtudiantDao dao;
	
	public void setDao(EtudiantDao dao) {
		this.dao = dao;
	}

	@Override
	public Etudiant save(Etudiant entity) {
		return dao.save(entity);
	}

	@Override
	public Etudiant update(Etudiant entity) {
		return dao.update(entity);
	}

	@Override
	public List<Etudiant> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Etudiant> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Etudiant getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Etudiant findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Etudiant findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}
}
