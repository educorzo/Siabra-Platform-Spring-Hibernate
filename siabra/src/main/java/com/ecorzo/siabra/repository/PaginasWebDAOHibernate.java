package com.ecorzo.siabra.repository;

import org.springframework.stereotype.Repository;
import com.ecorzo.siabra.domain.PaginasWeb;

@Repository(value = "PaginasWebDAO")
public class PaginasWebDAOHibernate  extends GenericDAOHibernate<PaginasWeb,String> implements  PaginasWebDAO{

}
