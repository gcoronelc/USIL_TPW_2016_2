-- Empresa        :  
-- Producto       :  

-- DBMS           :  MySQL

-- Script         :  Crea la base de datos y sus respectivos objetos



-- =============================================
-- Cargar Datos a la Base de Datos
-- =============================================

-- Base de Datos

USE VENTAS;
SET NAMES 'utf8';







-- Carga Datos a la tabla Usuario 

INSERT INTO usuario( Idusuario, clave, ,  )
	VALUES( 'estefani', 'VxuFAJXVARROc', );
	VALUES( 'pol', ' ae2b1fca515949e5d54fb22b8ed95575', );
	VALUES( 'walter', '7f84554057dd964b', );


-- Tabla CATEGORIA

Insert Into Categoria( IdCategoria, NomCategoria, Prefijo, ConCategoria ) Values( 1, 'Bebidas', 'BEB', 4 );
Insert Into Categoria( IdCategoria, NomCategoria, Prefijo, ConCategoria ) Values( 2, 'Carnes', 'CAR', 0 );
Insert Into Categoria( IdCategoria, NomCategoria, Prefijo, ConCategoria ) Values( 3, 'Pollo', 'POL', 0 );
Insert Into Categoria( IdCategoria, NomCategoria, Prefijo, ConCategoria ) Values( 4, 'Postres', 'POS', 0 );
Insert Into Categoria( IdCategoria, NomCategoria, Prefijo, ConCategoria ) Values( 5, 'Combos', 'COM', 5 );


-- Tabla producto

Insert Into producto  Values( 'BEB00001', 1, 'teclado )', 20 );
Insert Into  producto Values( 'BEB00002', 1, ' camara ', 25 );
Insert Into producto Values( 'BEB00003', 1, '  mouse ', 15);
Insert Into producto Values( 'BEB00004', 1, 'usb ', 16 );
Insert Into producto Values( 'COM00001', 5, ' pantalla para computadoras ', 9.99 );
Insert Into  producto Values( 'COM00002', 5, ' scaner ', 50.99 );
Insert Into producto Values( 'COM00003', 5, 'cpu ', 60.99 );
Insert Into producto Values( 'COM00004', 5, '  antivirus ', 28.99 );
Insert Into producto Values( 'COM00005', 5, ' impresora ', 16.99 );
Insert Into producto Values( 'COM00006', 5, '  protector de pantalla', 16.99 );







-- Tabla PROMOCION

Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 1,    0.1,    30.0,  0 );
Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 2,   30.1,    50.0,  2 );
Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 3,   50.1,   100.0,  4 );
Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 4,  100.1,   500.0,  6 );
Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 5,  500.1,  1000.0,  8 );
Insert Into Promocion(IdPromocion, MontoMin, MontoMax, Porcentaje ) Values( 6, 1000.1, 10000.0, 10 );












Contact GitHub API Training Shop Blog About
© 2016 GitHub, Inc. Terms Privacy Se