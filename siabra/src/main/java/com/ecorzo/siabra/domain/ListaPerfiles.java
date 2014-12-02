package com.ecorzo.siabra.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ListaPerfiles")
public class ListaPerfiles implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "username")
	private String username;
	// CAMBIAR TIPO DE CASCADE//
	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
	private Set<Perfil> listaPerfiles;

	public Set<Perfil> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(Set<Perfil> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}
}
