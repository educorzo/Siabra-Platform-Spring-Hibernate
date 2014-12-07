package com.ecorzo.siabra.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ecorzo.siabra.domain.DatosPersonales;
import com.ecorzo.siabra.repository.DatosPersonalesDAO;
import com.ecorzo.siabra.repository.InMemoryDatosPersonalesDAO;

public class SimpleDatosPersonalesManagerTest {
	private SimpleDatosPersonalesManager datosManager;
	private List<DatosPersonales> listaDatos;

	@Before
	public void setUp() throws Exception {
		datosManager = new SimpleDatosPersonalesManager();
		DatosPersonales datos = new DatosPersonales();
		listaDatos = new ArrayList<DatosPersonales>();
		Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1926");
		datos.setUsername("pepe");
		datos.setNacimiento(fecha);
		datos.setComentario("hola hola");
		listaDatos.add(datos);
		fecha = new SimpleDateFormat("dd-MM-yyyy").parse("9-10-1926");
		datos = new DatosPersonales();
		datos.setUsername("lola");
		datos.setNacimiento(fecha);
		datos.setComentario("adios adios");
		listaDatos.add(datos);
		DatosPersonalesDAO datosDAO = new InMemoryDatosPersonalesDAO();
		((InMemoryDatosPersonalesDAO) datosDAO)
				.setListaDatosPersonales(listaDatos);
		datosManager.setDatosPersonalesDAO(datosDAO);
	}

	@Test
	public void testGetWithNoDatos() {
		datosManager = new SimpleDatosPersonalesManager();
		datosManager.setDatosPersonalesDAO(new InMemoryDatosPersonalesDAO());
		assertNull(datosManager.getDatosPersonales(""));
	}

	@Test
	public void testGet() throws Exception{
		DatosPersonales datos = datosManager.getDatosPersonales("pepe");
		Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse("10-10-1926");
		assertEquals(datos.getUsername(), "pepe");
		assertEquals(datos.getComentario(), "hola hola");
		assertEquals(datos.getNacimiento(), fecha);
		datos=datosManager.getDatosPersonales("lola");
		fecha = new SimpleDateFormat("dd-MM-yyyy").parse("9-10-1926");
		assertEquals(datos.getUsername(), "lola");
		assertEquals(datos.getComentario(), "adios adios");
		assertEquals(datos.getNacimiento(), fecha);
	}

}
