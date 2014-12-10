package com.ecorzo.siabra.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Imagen")
public class Imagen implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name="target_id")
	private String target_id;
	
	@Column(name="imagen")
	private byte[] imagen;
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public String getUsername(){
		return username;
	}
	public void setTarget_id(String target_id){
		this.target_id=target_id;
	}
	
	public String getTarget_id(){
		return target_id;
	}
	
	public void setImagen(byte[] imagen){
		this.imagen=imagen.clone();
	}
	
	public byte[] getImagen(){
		return imagen;
	}
	
}
