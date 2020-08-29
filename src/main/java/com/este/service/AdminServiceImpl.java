package com.este.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.este.dao.AdminDao;
import com.este.models.Admin;


@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminDao.findByEmail(email);
		if(admin == null) {
			throw new UsernameNotFoundException("Eamil n'existe :" + email);
		}
		List<GrantedAuthority> grantedAutorities = new ArrayList<GrantedAuthority>();
		grantedAutorities.add(new SimpleGrantedAuthority(admin.getRole_admin().getNom_role())); 
			
		return new User(admin.getEmail(),admin.getMotdepass(),grantedAutorities );
	}
	
	

}
