package com.ecorzo.siabra.repository;

import java.util.List;
import com.ecorzo.siabra.domain.PaginasWeb;

public class InMemoryPaginasWebDAO implements PaginasWebDAO {
	private List<PaginasWeb> lista;

	public void setListaPaginasWeb(List<PaginasWeb> lista) {
		this.lista = lista;
	}

	@Override
	public PaginasWeb get(String id) throws BussinessException {
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
	public List<PaginasWeb> findAll() throws BussinessException {
		return lista;
	}

	@Override
	public PaginasWeb create() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(PaginasWeb entity) throws BussinessException {
		// TODO Auto-generated method stub
	}

}
