package com.ecorzo.siabra.service;

import org.springframework.stereotype.Component;
import com.ecorzo.siabra.domain.Imagen;
import com.ecorzo.siabra.repository.BussinessException;
import com.ecorzo.siabra.repository.ImagenDAO;

@Component
public class SimpleImagenManager implements ImagenManager{

	private static final long serialVersionUID = 1L;
	private ImagenDAO imagenDAO;
	
	@Override
	public Imagen getImagen(String username) {
		Imagen imagen= new Imagen();
		try{
			imagen=imagenDAO.get(username);
			return imagen;
		}catch(BussinessException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardarImagen(Imagen imagen) {
		if(comprobarImagen(imagen)){
			try{
			imagenDAO.saveOrUpdate(imagen);
			return true;
			}catch(BussinessException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean comprobarImagen(Imagen imagen) {
		// Temporal
		return true;
	}
	
	public void setImagenDAO(ImagenDAO imagenDAO){
		this.imagenDAO=imagenDAO;
	}

}
