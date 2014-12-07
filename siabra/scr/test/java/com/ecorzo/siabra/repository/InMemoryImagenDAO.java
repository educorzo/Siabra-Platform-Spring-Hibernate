package com.ecorzo.siabra.repository;

import java.util.List;

import com.ecorzo.siabra.domain.Imagen;

public class InMemoryImagenDAO implements ImagenDAO {
	List<Imagen> lista;

	public void setListaImagen(List<Imagen> lista) {
		this.lista = lista;
	}

	@Override
	public Imagen get(String id) throws BussinessException {
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
	public List<Imagen> findAll() throws BussinessException {
		return lista;
	}
	
	@Override
	public Imagen create() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Imagen entity) throws BussinessException {
		// TODO Auto-generated method stub
		
	}
}
