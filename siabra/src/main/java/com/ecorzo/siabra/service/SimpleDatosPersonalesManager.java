package com.ecorzo.siabra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecorzo.siabra.domain.DatosPersonales;
import com.ecorzo.siabra.repository.BussinessException;
import com.ecorzo.siabra.repository.DatosPersonalesDAO;

@Component
public class SimpleDatosPersonalesManager implements DatosPersonalesManager {

	private static final long serialVersionUID = 1L;
	@Autowired
	DatosPersonalesDAO datosPersonalesDAO;
	
	public boolean comprobarDatosPersonales(DatosPersonales datosPersonales){
		return true;
	}
	public DatosPersonales getDatosPersonales(String username){
		DatosPersonales datos= new DatosPersonales();
		try{
			datos=datosPersonalesDAO.get(username);
		}catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datos;
	}
	
	public boolean guardarDatosPersonales(DatosPersonales datosPersonales){
		if (comprobarDatosPersonales(datosPersonales)) {
			
			try {
				 datosPersonalesDAO.saveOrUpdate(datosPersonales);
				return true;
			} catch (BussinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
