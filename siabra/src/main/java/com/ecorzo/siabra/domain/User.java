package com.ecorzo.siabra.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
@Entity
@Table(name="User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Email
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private Boolean enabled;

	@Column(name="role")
	private String role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private DatosPersonales datosPersonales;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private PaginasWeb paginasWeb;
	/*
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Perfil perfil;
	*/
	public User(){
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean valor) {
		this.enabled = valor;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}
	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	
}