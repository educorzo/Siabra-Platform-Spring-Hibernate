package com.ecorzo.siabra.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="DatosPersonales")
public class DatosPersonales implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="username")
	private String username;
	@Column(name="DNI")
	private String DNI;
	@Column(name="profesion")
	private String profesion;
	@Column(name="pais")
	private String pais;
	@Column(name="estatus")
	private String estatus;
	@Column(name="empresa")
	private String empresa;
	@Column(name="comentario")
	private String comentario;
	@Column(name="permisos")
	private String permisos;
	@Column(name="nacimiento")
	private Date nacimiento;
	@Column(name="telefono")
	private String telefono;
	@Column(name="direccion")
	private String direccion;
	public DatosPersonales(){
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date date) {
		this.nacimiento = date;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
