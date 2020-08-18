package com.este.models;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="filiere")
public class Filiere implements Serializable{

	@Id
	@GeneratedValue
	private Long IdFil;
	
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="idDept")
	private Departement departement;
	
	@OneToMany(mappedBy="filiere")
	private List<Etudiant> etudiants;
	
	@ManyToMany
	@JoinTable(name = "T_Profs_Filiere_Associations",
            joinColumns = @JoinColumn( name = "idFil" ),
            inverseJoinColumns = @JoinColumn( name = "idProf" ))
	private List<Professeur> profs;
	
	
	public Filiere() {
		
	}
	
	public Filiere(Long idFil, String nom, Departement departement, List<Professeur> profs) {
		super();
		IdFil = idFil;
		this.nom = nom;
		this.departement = departement;
		this.profs = profs;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Long getIdFil() {
		return IdFil;
	}

	public void setIdFil(Long idFil) {
		IdFil = idFil;
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
