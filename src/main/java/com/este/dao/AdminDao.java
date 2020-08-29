package com.este.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.este.models.Admin;

@Repository("adminRepository")
public interface AdminDao extends CrudRepository<Admin, Integer>{

	public Admin findByEmail(String email);
	
	
}
