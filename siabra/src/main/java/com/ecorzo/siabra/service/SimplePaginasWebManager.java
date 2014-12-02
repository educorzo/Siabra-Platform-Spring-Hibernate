package com.ecorzo.siabra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ecorzo.siabra.domain.PaginasWeb;
import com.ecorzo.siabra.repository.BussinessException;
import com.ecorzo.siabra.repository.PaginasWebDAO;

@Component
public class SimplePaginasWebManager implements PaginasWebManager {
	private static final long serialVersionUID = 1L;
	@Autowired
	PaginasWebDAO paginasDAO;
	
	public boolean comprobarPaginasWeb(PaginasWeb paginas) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean guardarPaginasWeb(PaginasWeb paginas) {
		if(comprobarPaginasWeb(paginas)){
			try{
				paginasDAO.saveOrUpdate(paginas);
				return true;
			}catch(BussinessException e){
				e.printStackTrace();
			}	
		}
		return false;
	}

	@Override
	public PaginasWeb getPaginasWeb(String username) {
		PaginasWeb paginas= new PaginasWeb();
		try{
			paginas=paginasDAO.get(username);
		}catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paginas;
	}

}
