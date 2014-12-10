package com.ecorzo.siabra.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ecorzo.siabra.domain.Perfil;
import com.ecorzo.siabra.repository.InMemoryPerfilDAO;
import com.ecorzo.siabra.repository.PerfilDAO;

public class SimplePerfilManagerTest {
	 private SimplePerfilManager perfilManager;
	 private List<Perfil> listaPerfiles;
	 
	@Before
	public void setUp(){
		listaPerfiles = new ArrayList<Perfil>();
		perfilManager= new SimplePerfilManager();
		Perfil perfil= new Perfil();
		perfil.setUsername("pepe");
		perfil.setPermisos("11111111111111111");
		perfil.setDescripcion("Hola que tal");
		perfil.setCodigo("12345");
		listaPerfiles.add(perfil);
		perfil= new Perfil();
		perfil.setUsername("lola");
		perfil.setPermisos("00000000000000000");
		perfil.setDescripcion("Muy bien");
		perfil.setCodigo("54321");
		listaPerfiles.add(perfil);
		PerfilDAO perfilDAO= new InMemoryPerfilDAO();
		((InMemoryPerfilDAO) perfilDAO).setLista(listaPerfiles);
		perfilManager.setPerfilDAO(perfilDAO);
	}
	
	@Test
	public void testWithoutPerfiles(){
		perfilManager= new SimplePerfilManager();
		perfilManager.setPerfilDAO(new InMemoryPerfilDAO());
		assertNull(perfilManager.getPerfil(""));
	}
	
	@Test
	public void testGetPerfil() {
		Perfil perfil =perfilManager.getPerfil("pepe");
		assertEquals(perfil.getUsername(),"pepe");
		assertEquals(perfil.getCodigo(),"12345");
		assertEquals(perfil.getDescripcion(),"Hola que tal");
		assertEquals(perfil.getPermisos(),"11111111111111111");
		perfil=perfilManager.getPerfil("lola");
		assertEquals(perfil.getUsername(),"lola");
		assertEquals(perfil.getCodigo(),"54321");
		assertEquals(perfil.getDescripcion(),"Muy bien");
		assertEquals(perfil.getPermisos(),"00000000000000000");
	}

}
