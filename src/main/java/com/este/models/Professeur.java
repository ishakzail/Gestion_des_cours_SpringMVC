package com.este.models;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name= "professeur")
public class Professeur implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idProf;
	
	private String nom;
	
	private String prenom;
	
	private String email; 
	
	private String motdepass;
	
	@OneToMany(mappedBy = "prof")
	private List<Cour> cours;
	
	@ManyToOne
	@JoinColumn(name="idDept")
	private Departement departement;
	
	@ManyToMany
	@JoinTable(name = "T_Profs_Filiere_Associations",
            joinColumns = @JoinColumn( name = "idProf" ),
            inverseJoinColumns = @JoinColumn( name = "idFil" ))
	private List<Filiere> filieres ;
	
	public Professeur() {
		
	}

	
	public Professeur(Long idProf, String nom, String prenom, String email, String motdepass, List<Cour> cours,
			Departement departement, List<Filiere> filieres) {
		super();
		this.idProf = idProf;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepass = motdepass;
		this.cours = cours;
		this.departement = departement;
		this.filieres = filieres;
	}


	public Long getIdProf() {
		return idProf;
	}

	public void setIdProf(Long idProf) {
		this.idProf = idProf;
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

	public List<Cour> getCours() {
		return cours;
	}

	public void setCours(List<Cour> cours) {
		this.cours = cours;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	
	
	

	

}
