package com.ecorzo.siabra.repository;

import org.springframework.stereotype.Repository;

import com.ecorzo.siabra.domain.Perfil;

@Repository(value = "PerfilDAO")
public class PerfilDAOHibernate extends GenericDAOHibernate<Perfil,String> implements  PerfilDAO{

}
