package com.este.models;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="filiere")
public class Filiere implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFil;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="idDept")
	private Departement departement;
	
	@OneToMany(mappedBy="filiere")
	private List<Etudiant> etudiants;
	
	@OneToMany(mappedBy="filiere")
	private List<Professeur> professeurs;
	
	
	public Filiere() {
		
	}


	public Filiere(int idFil, String nom, Departement departement, List<Etudiant> etudiants,
			List<Professeur> professeurs) {
		super();
		this.idFil = idFil;
		this.nom = nom;
		this.departement = departement;
		this.etudiants = etudiants;
		this.professeurs = professeurs;
	}


	public int getIdFil() {
		return idFil;
	}


	public void setIdFil(int idFil) {
		this.idFil = idFil;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	public List<Professeur> getProfesseurs() {
		return professeurs;
	}


	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	
	
	

	
}
