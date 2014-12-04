CREATE DATABASE siabra;

GRANT ALL ON siabra.* TO siabrauser@'%' IDENTIFIED BY 'psiabrauser';
GRANT ALL ON siabra.* TO siabrauser@localhost IDENTIFIED BY 'psiabrauser';

USE siabra;

CREATE TABLE User (
  username varchar(255) PRIMARY KEY,
  email varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  password varchar(20)
);

CREATE TABLE DatosPersonales (
  username varchar(255) PRIMARY KEY,
  dni varchar(9),
  profesion  varchar(20),
  estatus varchar(20),
  pais varchar(20),
  empresa varchar(20),
  comentario varchar(50),
  nacimiento date(),
  permisos varchar(17)
);

CREATE TABLE PaginasWeb (
  username varchar(255) PRIMARY KEY,
  facebook varchar(90),
  linkedin  varchar(90),
  twitter varchar(90),
  webPersonal varchar(90),
  webProfesiona varchar(90)
);

CREATE TABLE Perfil (
  username VARCHAR(255) NOT NULL,
  codigo VARCHAR(10) NOT NULL,
  permisos VARCHAR(17) NULL,
  descripcion VARCHAR(200) NULL,
  PRIMARY KEY (username),
  UNIQUE INDEX codigo_UNIQUE (codigo ASC));
  
CREATE TABLE ListaPerfiles (
  idListaPerfiles INT NOT NULL,
  username VARCHAR(255) NULL,
  codigoPerfil VARCHAR(10) NULL,
  PRIMARY KEY (idListaPerfiles));
  
  
