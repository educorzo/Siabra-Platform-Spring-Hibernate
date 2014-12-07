package com.ecorzo.siabra.repository;

import org.springframework.stereotype.Repository;

import com.ecorzo.siabra.domain.Imagen;

@Repository(value = "ImagenDAO")
public class ImagenDAOHibernate extends GenericDAOHibernate<Imagen,String> implements ImagenDAO{

}
