package com.este.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name ="fichier")
public class Fichier implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idFic ;
	
	private String nom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCour")
	private Cour cour;

	
	public Fichier() {
		super();
	}

	public Fichier(Long idFic, String nom, Cour cour) {
		super();
		this.idFic = idFic;
		this.nom = nom;
		this.cour = cour;
	}

	public Long getIdFic() {
		return idFic;
	}

	public void setIdFic(Long idFic) {
		this.idFic = idFic;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Cour getCour() {
		return cour;
	}

	public void setCour(Cour cour) {
		this.cour = cour;
	}
		

	
}
