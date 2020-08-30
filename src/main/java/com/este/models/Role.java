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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;
	
	private String nom_role;
	
	@OneToOne(mappedBy="role_admin")
	private Admin admin;
	
	@OneToMany(mappedBy = "role_prof" , fetch =FetchType.LAZY)
	private List<Professeur> professeur;
	
	@OneToOne(mappedBy="role_etudiant")
	private Etudiant etudiant;
	
	public Role(int role_id) {
		super();
		this.role_id = role_id;
	}
	
	public Role() {
		
	}
	
	public Role(int role_id, String nom_role, Admin admin, List<Professeur> professeur, Etudiant etudiant) {
		super();
		this.role_id = role_id;
		this.nom_role = nom_role;
		this.admin = admin;
		this.professeur = professeur;
		this.etudiant = etudiant;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getNom_role() {
		return nom_role;
	}

	public void setNom_role(String nom_role) {
		this.nom_role = nom_role;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public List<Professeur> getProfesseur() {
		return professeur;
	}

	public void setProfesseur(List<Professeur> professeur) {
		this.professeur = professeur;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	
	
	
}
