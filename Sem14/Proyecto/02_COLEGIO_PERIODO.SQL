/*
Empresa        :  EGCC
Software       :  Planificación del Periodo
DBMS           :  MySQL Server
Base de Datos  :  COLEGIO
Modulo         :  PLANIFICACION
Script         :  Crea la Base de Datos
Responsable    :  Ing. Eric Gustavo Coronel Castillo
Telefono       :  (511) 9966-64457
Email          :  gcoronelc@gmail.com
Sitio Web      :  http://www.desarrollasoftware.com
Blog           :  http://gcoronelc.blogspot.com
*/

-- ===========================
-- CREACION DE TABLAS
-- ===========================

CREATE TABLE NIVEL
(
	IDNIVEL              INTEGER NOT NULL,
	NOMBRE               VARCHAR(50) NOT NULL,
	CONSTRAINT PK_NIVEL PRIMARY KEY (IDNIVEL)
);



CREATE TABLE GRADO
(
	IDNIVEL              INTEGER NOT NULL,
	IDGRADO              INTEGER NOT NULL,	
	NOMBRE               VARCHAR(50) NOT NULL,
	CONSTRAINT PK_GRADO PRIMARY KEY (IDNIVEL,IDGRADO),
	FOREIGN KEY FK_GRADO_NIVEL (IDNIVEL) REFERENCES NIVEL (IDNIVEL)
);



CREATE TABLE AULA
(
	IDAULA               INTEGER AUTO_INCREMENT,
	NOMBRE               VARCHAR(50) NOT NULL,
	PISO                 INTEGER NOT NULL,
	NUMERO               INTEGER NOT NULL,
	CAPACIDAD            INTEGER NOT NULL,
	CONSTRAINT PK_AULA PRIMARY KEY (IDAULA)
);



CREATE TABLE PERIODO
(
	PERIODO              INTEGER NOT NULL,
	NOMBRE               VARCHAR(200) NOT NULL,
	INGRESO              NUMERIC(12,2) NOT NULL,
	MATRICULA            NUMERIC(12,2) NOT NULL,
	CUOTA_NEW            NUMERIC(12,2) NULL,
	CUOTA_OLD            NUMERIC(12,2) NOT NULL,
	MORA                 NUMERIC(12,2) NOT NULL,
	HINGRESO             VARCHAR(10) NOT NULL,
	HSALIDA              VARCHAR(10) NOT NULL,
	CONSTRAINT PK_PERIODO PRIMARY KEY (PERIODO)
);



CREATE TABLE SECCION
(
	IDSECCION            INTEGER AUTO_INCREMENT,
	IDNIVEL              INTEGER NOT NULL,
	IDGRADO              INTEGER NOT NULL,	
	IDAULA               INTEGER NOT NULL,
	PERIODO              INTEGER NOT NULL,
	CONSTRAINT PK_SECCION PRIMARY KEY (IDSECCION),
	FOREIGN KEY FK_SECCION_GRADO (IDNIVEL, IDGRADO) REFERENCES GRADO (IDNIVEL, IDGRADO),
	FOREIGN KEY FK_SECCION_AULA (IDAULA) REFERENCES AULA (IDAULA),
	FOREIGN KEY FK_SECCION_PERIODO (PERIODO) REFERENCES PERIODO (PERIODO)
);


-- ===========================
-- DATOS
-- ===========================

-- NIVELES

INSERT INTO NIVEL VALUES
(1, 'NIVEL PRIMARIO'),
(2, 'NIVEL SECUNDARIO');

-- GRADOS

INSERT INTO GRADO VALUES
(1,1,'GRADO 1'),
(1,2,'GRADO 2'),
(1,3,'GRADO 3'),
(1,4,'GRADO 4'),
(1,5,'GRADO 5'),
(1,6,'GRADO 6'),
(2,1,'GRADO 1'),
(2,2,'GRADO 2'),
(2,3,'GRADO 3'),
(2,4,'GRADO 4'),
(2,5,'GRADO 5');


-- AULAS

INSERT INTO AULA VALUES
(1,'AULA 101',1,101,20),
(2,'AULA 102',1,102,20),
(3,'AULA 103',1,103,20),
(4,'AULA 104',1,104,20),
(5,'AULA 105',1,105,20),
(6,'AULA 106',1,106,20),
(7,'AULA 107',1,107,20),
(8,'AULA 201',2,201,30),
(9,'AULA 202',2,202,30),
(10,'AULA 203',2,203,30),
(11,'AULA 204',2,204,30),
(12,'AULA 205',2,205,30),
(13,'AULA 206',2,206,30),
(14,'AULA 207',2,207,30);

-- PERIODOS

INSERT INTO PERIODO VALUES
(2014,'AÑO DEL LOGRO',1200.0, 1000.0, 700.0, 500.0, 1, '7:45H','15:15H'),
(2015,'AÑO DEL LA CONSOLIDACION',1400.0, 1200.0, 800.0, 700.0, 1, '7:45H','15:15H');


-- SECCIONES

INSERT INTO SECCION(IDSECCION,IDNIVEL,IDGRADO,IDAULA,PERIODO) VALUES 
(1,1,1,1,2014),
(2,1,2,2,2014),
(3,1,3,3,2014),
(4,1,1,1,2015),
(5,1,2,2,2015),
(6,1,3,3,2015),
(7,1,4,4,2015);



