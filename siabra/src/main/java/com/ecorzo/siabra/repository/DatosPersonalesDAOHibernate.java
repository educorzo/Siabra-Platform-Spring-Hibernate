package com.ecorzo.siabra.repository;

import org.springframework.stereotype.Repository;

import com.ecorzo.siabra.domain.DatosPersonales;

@Repository(value = "DatosPersonalesDAO")
public class DatosPersonalesDAOHibernate extends GenericDAOHibernate<DatosPersonales,String> implements DatosPersonalesDAO{

}
