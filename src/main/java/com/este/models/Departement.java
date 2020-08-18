package com.este.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable{

	@Id
	@GeneratedValue
	private Long idDept;
	
	private String nom;
	
	@OneToMany(mappedBy="departement")
	private List<Professeur> profs;
	
	@OneToMany(mappedBy ="departement")
	private List<Filiere> filieres;
	
	public Departement(){
		
	}
	

	public Departement(Long idDept, String nom, List<Professeur> profs, List<Filiere> filieres) {
		super();
		this.idDept = idDept;
		this.nom = nom;
		this.profs = profs;
		this.filieres = filieres;
	}


	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
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

	
	
	
}
