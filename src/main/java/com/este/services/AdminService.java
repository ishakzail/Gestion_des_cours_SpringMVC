package com.este.services;

import java.util.List;


import com.este.models.Admin;

public interface AdminService{
	
	public Admin save(Admin entity);
	
	public Admin update(Admin entity);
	
	public List<Admin> selectAll();
	
	public List<Admin> selectAll(String sortField , String sort);
	
	
	public Admin getById(Long id);
	
	public Admin findOne(String paramName , Object paramValue);

	
	
	

}
