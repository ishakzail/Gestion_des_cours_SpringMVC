package com.este.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="etudiant")
public class Etudiant implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEtud;
	
	private String nom;
	
	private String prenom;
	
	private String email; 
	
	private String motdepass;
	
	@ManyToOne
	@JoinColumn(name="idFil")
	private Filiere filiere;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role_etudiant;
	
	

	public Etudiant(){
	}


	public Etudiant(int idEtud, String nom, String prenom, String email, String motdepass, Filiere filiere,
			Role role_etudiant) {
		super();
		this.idEtud = idEtud;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepass = motdepass;
		this.filiere = filiere;
		this.role_etudiant = role_etudiant;
	}


	public int getIdEtud() {
		return idEtud;
	}

	public void setIdEtud(int idEtud) {
		this.idEtud = idEtud;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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



	public Filiere getFiliere() {
		return filiere;
	}



	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}



	public Role getRole_etudiant() {
		return role_etudiant;
	}



	public void setRole_etudiant(Role role_etudiant) {
		this.role_etudiant = role_etudiant;
	}
	
	
	
	
}
