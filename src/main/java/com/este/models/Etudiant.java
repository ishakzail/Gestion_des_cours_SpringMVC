package com.este.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable{

	
	@Id
	@GeneratedValue
	private Long idEtud;
	
	private String prenom;
	
	private String email; 
	
	private String motdepass;
	
	@ManyToOne
	@JoinColumn(name="idFil")
	private Filiere filiere;
	
	

	public Etudiant(){
	}
	
	public Long getIdEtud() {
		return idEtud;
	}

	public void setIdEtud(Long idEtud) {
		this.idEtud = idEtud;
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
	
	
}
