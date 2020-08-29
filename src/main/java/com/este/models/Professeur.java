package com.este.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "professeur")
public class Professeur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProf;
	
	private String nom;
	
	private String prenom;
	
	private String email; 
	
	private String motdepass;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role_prof;
	
	@OneToMany(mappedBy = "prof" , fetch = FetchType.LAZY)
	private List<Cour> cours;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDept")
	private Departement departement;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idFil")
	private Filiere filiere ;
	
	public Professeur() {
		
	}

	

	public Professeur(int idProf, String nom, String prenom, String email, String motdepass, Role role_prof,
			List<Cour> cours, Departement departement, Filiere filiere) {
		super();
		this.idProf = idProf;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepass = motdepass;
		this.role_prof = role_prof;
		this.cours = cours;
		this.departement = departement;
		this.filiere = filiere;
	}



	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
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

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Role getRole_prof() {
		return role_prof;
	}

	public void setRole_prof(Role role_prof) {
		this.role_prof = role_prof;
	}
	
	
	
	

	
	
	

	

}
