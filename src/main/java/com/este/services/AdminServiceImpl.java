package com.este.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



import com.este.dao.AdminDao;

import com.este.models.Admin;

@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao dao;
	
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public Admin save(Admin entity) {
		return dao.save(entity);
	}

	@Override
	public Admin update(Admin entity) {
		return dao.update(entity);
	}

	@Override
	public List<Admin> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Admin> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}


	@Override
	public Admin getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Admin findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

}
