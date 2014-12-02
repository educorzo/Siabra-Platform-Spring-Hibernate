package com.ecorzo.siabra.repository;

import org.springframework.stereotype.Repository;

import com.ecorzo.siabra.domain.User;

@Repository(value = "UserDAO")
public class UserDAOHibernate extends GenericDAOHibernate<User,String> implements  UserDAO{

}
