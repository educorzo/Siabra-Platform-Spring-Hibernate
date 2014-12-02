package com.ecorzo.siabra.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String username;
	@Column(name= "codigo")
	private String codigo;
	@Column(name="permisos")
	private String permisos;
	@Column(name="descripcion")
	private String descripcion;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPermisos() {
		return permisos;
	}

	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
