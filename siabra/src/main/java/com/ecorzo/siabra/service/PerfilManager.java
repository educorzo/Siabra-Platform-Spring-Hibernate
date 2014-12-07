package com.ecorzo.siabra.service;

import java.io.Serializable;

import com.ecorzo.siabra.domain.Perfil;

public interface PerfilManager extends Serializable{
	public Perfil getPerfil(String username);
	public boolean guardarPerfil(Perfil perfil);
	public boolean comprobarPerfil(Perfil perfil);
}
