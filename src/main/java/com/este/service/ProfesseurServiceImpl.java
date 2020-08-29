package com.este.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.este.dao.ProfesseurDao;

import com.este.models.Professeur;

@Transactional
@Service("professeurService")
public class ProfesseurServiceImpl implements ProfesseurService{

	

	@Autowired
	private ProfesseurDao professeurDao; 
	

	@Override
	public Iterable<Professeur> selectAll() {
		return professeurDao.findAll();
	}

	@Override
	public Professeur save(Professeur professeur) {
		return professeurDao.save(professeur);
	}

	@Override
	public void delete(int id) {
		professeurDao.deleteById(id);
		
	}

	@Override
	public Professeur find(int id) {
		return professeurDao.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Professeur professeur = professeurDao.findByEmail(email);
		if(professeur == null) {
			throw new UsernameNotFoundException("Eamil n'existe :" + email);
		}
		List<GrantedAuthority> grantedAutorities = new ArrayList<GrantedAuthority>();
		grantedAutorities.add(new SimpleGrantedAuthority(professeur.getRole_prof().getNom_role())); 
			
		return new User(professeur.getEmail(),professeur.getMotdepass(),grantedAutorities );
	}
}
