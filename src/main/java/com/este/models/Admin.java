package com.este.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="admin")
public class Admin implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	private String email ;
	
	private String motdepass;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role_admin;
	
	public Admin(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Admin(Long id, String email, String motdepass, Role role_admin) {
		super();
		this.id = id;
		this.email = email;
		this.motdepass = motdepass;
		this.role_admin = role_admin;
	}

	public Role getRole_admin() {
		return role_admin;
	}

	public void setRole_admin(Role role_admin) {
		this.role_admin = role_admin;
	}
	
	
	
	
	
		
}
