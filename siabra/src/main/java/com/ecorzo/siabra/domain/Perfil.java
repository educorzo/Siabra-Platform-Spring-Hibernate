package com.ecorzo.siabra.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<String> getPermisosArray(){
		List<String> lista= new ArrayList<String>() ;
		if(permisos.charAt(0) == '1')lista.add("id_apellidos");
		if(permisos.charAt(1) == '1')lista.add("id_comentario");
		if(permisos.charAt(2) == '1')lista.add("id_direccion");
		if(permisos.charAt(3) == '1')lista.add("id_dni");
		if(permisos.charAt(4) == '1')lista.add("id_email");
		if(permisos.charAt(5) == '1')lista.add("id_empresa");
		if(permisos.charAt(6) == '1')lista.add("id_estatus");
		if(permisos.charAt(7) == '1')lista.add("id_facebook");
		if(permisos.charAt(8) == '1')lista.add("id_linkedin");
		if(permisos.charAt(9) == '1')lista.add("id_nacimiento");
		if(permisos.charAt(10) == '1')lista.add("id_nombre");
		if(permisos.charAt(11) == '1')lista.add("id_pais");
		if(permisos.charAt(12) == '1')lista.add("id_profesion");
		if(permisos.charAt(13) == '1')lista.add("id_telefono");
		if(permisos.charAt(14) == '1')lista.add("id_twitter");
		if(permisos.charAt(15) == '1')lista.add("id_webPersonal");
		if(permisos.charAt(16) == '1')lista.add("id_webProfesional");
		return lista;
	}

}
