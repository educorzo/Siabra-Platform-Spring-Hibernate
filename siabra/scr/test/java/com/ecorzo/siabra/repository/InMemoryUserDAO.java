package com.ecorzo.siabra.repository;
import java.util.List;

import com.ecorzo.siabra.domain.User;

public class InMemoryUserDAO implements UserDAO{
	private User usuario;
	
	public  void setUsuario(User user){
		usuario=user;
	}
	
	@Override
	public User create() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(User entity) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String id) throws BussinessException {
		return usuario;
	}

	@Override
	public void delete(String id) throws BussinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() throws BussinessException {
		// TODO Auto-generated method stub
		return null;
	}


	 
}
