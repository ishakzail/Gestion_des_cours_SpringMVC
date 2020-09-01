package com.este.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cour")
public class Cour implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCour;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cour")
	private List<Fichier> fichiers;
	
	private String nom;
	
	private String module;
	
	@ManyToOne
	@JoinColumn(name="idProf")
	private Professeur prof;
	
	public Cour() {
		
	}
	
	public Cour(String nom , String module , Professeur prof) {
		this.nom = nom;
		this.module = module;
		this.prof = prof;
	}

	public Cour(int idCour, List<Fichier> fichiers, String nom, String module, Professeur prof) {
		super();
		this.idCour = idCour;
		this.fichiers = fichiers;
		this.nom = nom;
		this.module = module;
		this.prof = prof;
	}
	
	
	

	public List<Fichier> getFichiers() {
		return fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public int getIdCour() {
		return idCour;
	}

	public void setIdCour(int idCour) {
		this.idCour = idCour;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	
	
}
