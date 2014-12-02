package com.ecorzo.siabra.service;

import java.io.Serializable;

import com.ecorzo.siabra.domain.User;

public interface UsuarioManager extends Serializable {
	
	public boolean comprobarUsuario(User usuario);
	public boolean guardarUsuario(User usuario);
	public User getUsuario(String username);
}
