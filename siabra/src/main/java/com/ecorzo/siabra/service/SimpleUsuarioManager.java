package com.ecorzo.siabra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecorzo.siabra.domain.User;
import com.ecorzo.siabra.repository.BussinessException;
import com.ecorzo.siabra.repository.UserDAO;

@Component
public class SimpleUsuarioManager implements UsuarioManager {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDAO userDAO;

	public boolean comprobarUsuario(User usuario) {
		return true;
	}

	public boolean guardarUsuario(User usuario) {
		if (comprobarUsuario(usuario)) {
			usuario.setEnabled(true);
			usuario.setRole("ROLE_ADMIN");
			try {
				 userDAO.saveOrUpdate(usuario);
				return true;
			} catch (BussinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	public User getUsuario(String username){
		User usuario = new User();
		try{
			usuario=userDAO.get(username);
		}catch (BussinessException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
