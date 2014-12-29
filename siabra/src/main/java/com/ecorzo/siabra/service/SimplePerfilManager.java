package com.ecorzo.siabra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecorzo.siabra.domain.Perfil;
import com.ecorzo.siabra.repository.BussinessException;
import com.ecorzo.siabra.repository.PerfilDAO;

@Component
public class SimplePerfilManager implements PerfilManager {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerfilDAO perfilDAO;
	
	@Override
	public Perfil getPerfil(String username) {
		Perfil perfil = new Perfil();
		try{
			perfil=perfilDAO.get(username);
			return perfil;
		}catch(BussinessException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean guardarPerfil(Perfil perfil) {
		if(comprobarPerfil(perfil)){
			try{
				perfilDAO.saveOrUpdate(perfil);
				return true;
			}catch(BussinessException e){
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean comprobarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean eliminarPerfil(String username){
		try {
			perfilDAO.delete(username);
			return true;
		} catch (BussinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void setPerfilDAO(PerfilDAO perfilDAO){
		this.perfilDAO=perfilDAO;
	}

}
