package com.ecorzo.siabra.service;

import java.io.Serializable;

import com.ecorzo.siabra.domain.Imagen;

public interface ImagenManager extends Serializable{
	public Imagen getImagen(String username);
	public boolean guardarImagen(Imagen imagen);
	public boolean comprobarImagen(Imagen imagen);
	public String enviarAVuforia(Imagen imagen);
}
