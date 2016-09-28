-- Empresa        :  Wilson Store 
-- DBMS           :  MySQL
-- Base de Datos  :  Wilson Store
-- Script         :  Crea la base de datos y sus respectivos objetos
-- Programado por :  
--estefani villalva vivar
--de la cruz walter





CREATE DATABASE 
IF NOT EXISTS Wilson Store;



USE Wilson Store;


DROP TABLE IF EXISTS promociones;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS usuario;
CREATE TABLE Promociones (
       IdPromocion          tinyint unsigned AUTO_INCREMENT,
       MontoMin             numeric(10,2) NOT NULL,
       MontoMax             numeric(10,2) NOT NULL,
       Porcentaje           tinyint unsigned NOT NULL,
       CONSTRAINT pkPromocion PRIMARY KEY(IdPromocion)
) ENGINE = INNODB;


CREATE TABLE Producto (
       IdProducto           char(8) NOT NULL,
       IdCategoria          tinyint unsigned NOT NULL,
       NomArticulo          varchar(50) NOT NULL,
       PreArticulo          numeric(10,2) NOT NULL,
       CONSTRAINT pkproducto PRIMARY KEY(IdProducto),
       CONSTRAINT fkProductoCategoria
            FOREIGN KEY(IdCategoria)
            REFERENCES Categoria(IdCategoria)
) ENGINE = INNODB;


CREATE TABLE Categoria (
       IdCategoria          tinyint unsigned AUTO_INCREMENT,
       NomCategoria         varchar(25) NOT NULL,
       Prefijo              char(3) NOT NULL UNIQUE,
       ConCategoria         int NOT NULL,
       CONSTRAINT pkCategoria PRIMARY KEY(IdCategoria)
) ENGINE = INNODB;

CREATE TABLE Usuario  (
       id_usuario         varchar(25) NULL,
       Clave                varchar(35) NOT NULL,
       CONSTRAINT pkUsuario PRIMARY KEY(id_usuario)
) ENGINE = INNODB;


USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'Wilson Store'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE Wilson Store;

USE MYSQL;
GRANT ALL PRIVILEGES ON *.* TO 'Wilson Store'@'localhost' IDENTIFIED BY 'admin' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE Wilson Store;


select database() as "current databse";