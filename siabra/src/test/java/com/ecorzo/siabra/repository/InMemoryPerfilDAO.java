package com.ecorzo.siabra.repository;

import java.util.List;

import com.ecorzo.siabra.domain.Perfil;

public class InMemoryPerfilDAO implements PerfilDAO{
	private List<Perfil> lista;
	
	public void setLista(List<Perfil> lista){
		this.lista=lista;
	}
	
	@Override
	public Perfil create() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Perfil entity) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Perfil get(String id) throws BussinessException {
		int i = 0;
		if (lista!=null) {
			while (lista.get(i).getUsername() != id && i < lista.size()) {
				i++;
			}
			return lista.get(i);
		} else {
			return null;
		}
	}

	@Override
	public void delete(String id) throws BussinessException {
		int i = 0;
		while (lista.get(i).getUsername() != id && i < lista.size()) {
			i++;
		}
		lista.remove(i);
	}

	@Override
	public List<Perfil> findAll() throws BussinessException {
		return lista;
	}

}
