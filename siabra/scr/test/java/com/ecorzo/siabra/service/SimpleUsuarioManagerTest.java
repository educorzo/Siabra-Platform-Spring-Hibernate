package com.ecorzo.siabra.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.ecorzo.siabra.domain.User;
import com.ecorzo.siabra.repository.InMemoryUserDAO;
import com.ecorzo.siabra.repository.UserDAO;

public class SimpleUsuarioManagerTest {
	private SimpleUsuarioManager usuarioManager;
	private User usuario;
	private static String EMAIL="pepe@gmail.com";
	private static String USERNAME="pepe";
	private static String PASSWORD="pepe03";
	
	@Before
	public void setUp() throws Exception {
		usuarioManager= new SimpleUsuarioManager();
		usuario= new User();
		usuario.setUsername("pepe");
		usuario.setPassword("pepe03");
		usuario.setEmail("pepe@gmail.com");
		usuario.setEnabled(true);
		usuario.setRole("ADMIN");
		UserDAO userDAO= new InMemoryUserDAO();
		((InMemoryUserDAO) userDAO).setUsuario(usuario);
		usuarioManager.setUsuarioDAO(userDAO);
	}
	
	@Test
	public void testGetUser() {
		User usuarioPrueba=usuarioManager.getUsuario("pepe");
		assertNotNull(usuarioPrueba);
		assertEquals(EMAIL,usuarioPrueba.getEmail());
		assertEquals(USERNAME,usuarioPrueba.getUsername());
		assertEquals(PASSWORD,usuarioPrueba.getPassword());
		assertEquals(true,usuarioPrueba.getEnabled());
		assertEquals("ADMIN",usuarioPrueba.getRole());
	}
	
	@Test
    public void testGetUserWithNoUsers() {
        usuarioManager = new SimpleUsuarioManager();
        usuarioManager.setUsuarioDAO(new InMemoryUserDAO());
        assertNull(usuarioManager.getUsuario(""));
    }
	@Test
	public void testGuardar(){
		assertEquals(true,usuarioManager.guardarUsuario(usuario));	
	}
	
	

}
