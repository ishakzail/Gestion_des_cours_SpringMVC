package com.este.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.este.dao.DepartementDao;
import com.este.models.Departement;

@Transactional
@Service("departementService")
public class DepartementServiceImpl implements DepartementService{

	@Autowired
	private DepartementDao departementDao;
	
	@Override
	public Iterable<Departement> selectAll() {
		return departementDao.findAll();
	}

	@Override
	public Departement save(Departement departement) {
		return departementDao.save(departement);
	}

	@Override
	public void delete(int id) {
		departementDao.deleteById(id);
	}

	@Override
	public Departement find(int id) {
		return departementDao.findById(id).get();
	}

}
