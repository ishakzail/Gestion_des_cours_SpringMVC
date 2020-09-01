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

import com.este.dao.EtudiantDao;
import com.este.models.Etudiant;


@Transactional
@Service("etudiantService")
public class EtudiantServiceImpl implements EtudiantService{

	
	@Autowired
	private EtudiantDao etudiantDao; 
	
	@Override
	public Iterable<Etudiant> selectAll() {
		return etudiantDao.findAll();
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		return etudiantDao.save(etudiant);
	}

	@Override
	public void delete(int id) {
		etudiantDao.deleteById(id);
		
	}

	@Override
	public Etudiant find(int id) {
		return etudiantDao.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Etudiant etudiant = etudiantDao.findByEmail(email);
		if(etudiant == null) {
			throw new UsernameNotFoundException("Eamil n'existe :" + email);
		}
		List<GrantedAuthority> grantedAutorities = new ArrayList<GrantedAuthority>();
		grantedAutorities.add(new SimpleGrantedAuthority(etudiant.getRole_etudiant().getNom_role())); 
			
		return new User(etudiant.getEmail() ,etudiant.getMotdepass(),grantedAutorities );
	}

	@Override
	public Etudiant getByEmail(String email) {
		return etudiantDao.findByEmail(email);
	}


}
