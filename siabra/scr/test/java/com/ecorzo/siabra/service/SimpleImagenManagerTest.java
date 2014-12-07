package com.ecorzo.siabra.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ecorzo.siabra.domain.Imagen;
import com.ecorzo.siabra.repository.ImagenDAO;
import com.ecorzo.siabra.repository.InMemoryImagenDAO;

public class SimpleImagenManagerTest {
	private SimpleImagenManager imagenManager;
	private List<Imagen> listaImagen;
	
	@Before
	public void setUp(){
		imagenManager= new SimpleImagenManager();
		listaImagen= new ArrayList<Imagen>();
		Imagen imagen = new Imagen();
		byte[] bImagen = new byte[3];
		bImagen[0]=(byte)1;
		bImagen[1]=2;
		imagen.setUsername("pepe");
		imagen.setTarget_id("1234");
		imagen.setImagen(bImagen);
		listaImagen.add(imagen);
		imagen = new Imagen();
		bImagen[0]=0;
		imagen.setTarget_id("4321");
		imagen.setUsername("lola");
		imagen.setImagen(bImagen);
		listaImagen.add(imagen);
		ImagenDAO imagenDAO= new InMemoryImagenDAO();
		((InMemoryImagenDAO) imagenDAO).setListaImagen(listaImagen);
		imagenManager.setImagenDAO(imagenDAO);
	}
	
	@Test
	public void testImageWithoutImages() {
		imagenManager= new SimpleImagenManager();
		imagenManager.setImagenDAO(new InMemoryImagenDAO());
		assertNull(imagenManager.getImagen(""));
	}
	
	@Test
	public void testGetImagen(){
		Imagen imagen=imagenManager.getImagen("pepe");
		assertEquals(imagen.getUsername(),"pepe");
		assertEquals(imagen.getTarget_id(),"1234");
		assertEquals(imagen.getImagen()[0],1);
		imagen=imagenManager.getImagen("lola");
		assertEquals(imagen.getUsername(),"lola");
		assertEquals(imagen.getTarget_id(),"4321");
		assertEquals(imagen.getImagen()[0],0);
	}

}
