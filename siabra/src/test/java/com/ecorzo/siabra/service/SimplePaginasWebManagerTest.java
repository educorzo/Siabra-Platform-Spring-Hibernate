package com.ecorzo.siabra.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ecorzo.siabra.domain.PaginasWeb;
import com.ecorzo.siabra.repository.InMemoryPaginasWebDAO;
import com.ecorzo.siabra.repository.PaginasWebDAO;

public class SimplePaginasWebManagerTest {
	private SimplePaginasWebManager paginasManager;
	private List<PaginasWeb> listaPaginas;
	
	@Before
    public void setUp() throws Exception {
		paginasManager= new SimplePaginasWebManager();
		PaginasWeb paginas= new PaginasWeb();
		listaPaginas = new ArrayList(); 
		paginas.setFacebook("http://www.facebook.com/pepe");
		paginas.setLinkedin("http://www.linkedin.es/pepe");
		paginas.setUsername("pepe");
		listaPaginas.add(paginas);
		paginas=new PaginasWeb();
		paginas.setFacebook("http://www.facebook.com/lola");
		paginas.setLinkedin("http://www.linkedin.es/lola");
		paginas.setUsername("lola");
		listaPaginas.add(paginas);
		PaginasWebDAO paginasDAO= new InMemoryPaginasWebDAO();
		((InMemoryPaginasWebDAO) paginasDAO).setListaPaginasWeb(listaPaginas);
		paginasManager.setPaginasWebDAO(paginasDAO);
	}
	
	@Test
	public void testGetPaginasWeb() {
		PaginasWeb pepePaginas= paginasManager.getPaginasWeb("pepe");
		assertNotNull(pepePaginas);
		assertEquals(pepePaginas.getUsername(),"pepe");
		assertEquals(pepePaginas.getFacebook(),"http://www.facebook.com/pepe");
		PaginasWeb lolaPaginas= paginasManager.getPaginasWeb("lola");
		assertNotNull(lolaPaginas);
		assertEquals(lolaPaginas.getUsername(),"lola");
	}
	
	@Test
	public void testPaginasWithNoPaginas(){
		paginasManager=new SimplePaginasWebManager();
		paginasManager.setPaginasWebDAO(new InMemoryPaginasWebDAO());
		assertNull(paginasManager.getPaginasWeb(""));
	}

}
