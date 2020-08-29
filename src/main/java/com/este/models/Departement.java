package com.este.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDept;
	
	private String nom;
	
	@OneToMany(mappedBy="departement" , fetch = FetchType.LAZY)
	private List<Professeur> profs;
	
	@OneToMany(mappedBy ="departement" , fetch =FetchType.LAZY)
	private List<Filiere> filieres;
	
	public Departement(){
		
	}
	

	public Departement(int idDept, String nom, List<Professeur> profs, List<Filiere> filieres) {
		super();
		this.idDept = idDept;
		this.nom = nom;
		this.profs = profs;
		this.filieres = filieres;
	}


	public int getIdDept() {
		return idDept;
	}

	public void setIdDept(int idDept) {
		this.idDept = idDept;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Professeur> getProfs() {
		return profs;
	}

	public void setProfs(List<Professeur> profs) {
		this.profs = profs;
	}

	
	public List<Filiere> getFilieres() {
		return filieres;
	}


	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}
	
	

	
	
	
}
