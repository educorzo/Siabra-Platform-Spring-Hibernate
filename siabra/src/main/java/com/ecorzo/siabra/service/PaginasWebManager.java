package com.ecorzo.siabra.service;

import java.io.Serializable;

import com.ecorzo.siabra.domain.PaginasWeb;

public interface PaginasWebManager extends Serializable{
	public boolean comprobarPaginasWeb(PaginasWeb paginas);
	public boolean guardarPaginasWeb(PaginasWeb paginas);
	public PaginasWeb getPaginasWeb(String username);

}
