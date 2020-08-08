package com.este.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "professeur")
public class Professeur {
	
	@Id
	@GeneratedValue
	private Long idProf;
	
	private String nom;
	
	private String prenom;
	
	private String email; 
	
	private String motdepass;
	
	private String departement;
	
	private String filiere;
	
	@OneToMany(mappedBy = "prof")
	private List<Cour> cours;
	
	public Professeur() {
	}

	public Long getIdProf() {
		return idProf;
	}

	public void setIdProf(Long id) {
		this.idProf = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepass() {
		return motdepass;
	}

	public void setMotdepass(String motdepass) {
		this.motdepass = motdepass;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	
	

}
