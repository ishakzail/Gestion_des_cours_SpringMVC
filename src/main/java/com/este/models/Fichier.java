package com.este.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name ="fichier")
public class Fichier implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFic ;
	
	@Lob
	private byte[] data;
	
	private String nom;
	
	private String type;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idCour")
	private Cour cour;

	
	public Fichier() {
		super();
	}
	
	public Fichier(byte[] data, String nom) {
		super();
		this.data = data;
		this.nom = nom;
	}



	public Fichier(byte[] data, String nom, Cour cour , String type) {
		super();
		this.data = data;
		this.nom = nom;
		this.cour = cour;
		this.type = type;
	}

	public int getIdFic() {
		return idFic;
	}

	public void setIdFic(int idFic) {
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


	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

	
}
