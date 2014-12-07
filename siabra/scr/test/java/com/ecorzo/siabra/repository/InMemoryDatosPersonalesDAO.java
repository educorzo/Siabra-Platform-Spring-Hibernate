package com.ecorzo.siabra.repository;

import java.util.List;

import com.ecorzo.siabra.domain.DatosPersonales;

public class InMemoryDatosPersonalesDAO implements DatosPersonalesDAO {
	private List<DatosPersonales> lista;

	public void setListaDatosPersonales(List<DatosPersonales> lista) {
		this.lista = lista;
	}

	@Override
	public DatosPersonales create() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(DatosPersonales entity) throws BussinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public DatosPersonales get(String id) throws BussinessException {
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
		if (lista != null) {
			while (lista.get(i).getUsername() != id && i < lista.size()) {
				i++;
			}
			lista.remove(i);
		}
	}

	@Override
	public List<DatosPersonales> findAll() throws BussinessException {
		// TODO Auto-generated method stub
		return lista;
	}

}
