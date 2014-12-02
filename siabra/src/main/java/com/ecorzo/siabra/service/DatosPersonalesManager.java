package com.ecorzo.siabra.service;

import java.io.Serializable;

import com.ecorzo.siabra.domain.DatosPersonales;

public interface DatosPersonalesManager extends Serializable{
	public boolean comprobarDatosPersonales(DatosPersonales datosPersonales);
	public boolean guardarDatosPersonales(DatosPersonales datosPersonales);
	public DatosPersonales getDatosPersonales(String username);
}
