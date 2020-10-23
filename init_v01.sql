-- DROP SCHEMA "WEB";

CREATE SCHEMA "WEB" AUTHORIZATION postgres;

-- DROP TYPE "WEB"."_USER";

CREATE TYPE "WEB"."_USER" (
	INPUT = array_in,
	OUTPUT = array_out,
	RECEIVE = array_recv,
	SEND = array_send,
	ANALYZE = array_typanalyze,
	ALIGNMENT = 8,
	STORAGE = any,
	CATEGORY = A,
	ELEMENT = "WEB".usuario,
	DELIMITER = ',');
-- "WEB".usuario definition

-- Drop table

-- DROP TABLE "WEB".usuario;

CREATE TABLE "WEB".usuario (
	nickname varchar(20) NOT NULL,
	pwd varchar(32) NOT NULL,
	"admin" bool NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (nickname)
);


-- "WEB".servicios definition

-- Drop table

-- DROP TABLE "WEB".servicios;

CREATE TABLE "WEB".servicios (
	nombre varchar(20) NOT NULL,
	descripcion varchar(2000) NOT NULL,
	precio int4 NOT NULL,
	CONSTRAINT service_pk PRIMARY KEY (nombre)
);


-- "WEB".perfil_usuario definition

-- Drop table

-- DROP TABLE "WEB".perfil_usuario;

CREATE TABLE "WEB".perfil_usuario (
	direccion varchar(100) NOT NULL,
	email varchar(30) NOT NULL,
	telefono varchar(9) NOT NULL,
	nombre varchar(20) NOT NULL,
	apellidos varchar(100) NOT NULL,
	nickname varchar(20) NOT NULL,
	iduser int4 NOT NULL,
	CONSTRAINT perfil_user_pk PRIMARY KEY (nickname, iduser),
	CONSTRAINT perfil_user_fk FOREIGN KEY (nickname) REFERENCES "WEB".usuario(nickname) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
);


-- "WEB".solicitud definition

-- Drop table

-- DROP TABLE "WEB".solicitud;

CREATE TABLE "WEB".solicitud (
	direccion varchar(100) NOT NULL,
	fecha date NOT NULL,
	hora time NOT NULL,
	mensaje varchar(2000) NOT NULL,
	estado varchar(15) NOT NULL,
	idsolicitud int4 NOT NULL,
	servicio varchar(20) NOT NULL,
	usuario varchar(20) NOT NULL,
	CONSTRAINT solicitud_pk PRIMARY KEY (idsolicitud),
	CONSTRAINT solicitud_fk FOREIGN KEY (servicio) REFERENCES "WEB".servicios(nombre) DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT solicitud_fk_1 FOREIGN KEY (usuario) REFERENCES "WEB".usuario(nickname)
);


