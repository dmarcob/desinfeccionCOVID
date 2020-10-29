-- DROP SCHEMA "web";

CREATE SCHEMA "web" AUTHORIZATION postgres;

-- "web".usuario definition

-- Drop table

-- DROP TABLE "web".usuario;

CREATE TABLE "web".usuario (
	nickname varchar(20) NOT NULL,
	pwd varchar(32) NOT NULL,
	"admin" bool NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (nickname)
);


-- "web".servicios definition

-- Drop table

-- DROP TABLE "web".servicios;

CREATE TABLE "web".servicios (
	nombre varchar(20) NOT NULL,
	descripcion varchar(2000) NOT NULL,
	precio int4 NOT NULL,
	CONSTRAINT service_pk PRIMARY KEY (nombre)
);


-- "web".perfil_usuario definition

-- Drop table

-- DROP TABLE "web".perfil_usuario;

CREATE TABLE "web".perfil_usuario (
	direccion varchar(100) NOT NULL,
	email varchar(30) NOT NULL,
	telefono varchar(9) NOT NULL,
	nombre varchar(20) NOT NULL,
	apellidos varchar(100) NOT NULL,
	nickname varchar(20) NOT NULL,
	iduser int4 NOT NULL,
	CONSTRAINT perfil_user_pk PRIMARY KEY (nickname, iduser),
	CONSTRAINT perfil_user_fk FOREIGN KEY (nickname) REFERENCES "web".usuario(nickname) ON UPDATE CASCADE ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
);


-- "web".solicitud definition

-- Drop table

-- DROP TABLE "web".solicitud;

CREATE TABLE "web".solicitud (
	direccion varchar(100) NOT NULL,
	fecha date NOT NULL,
	hora time NOT NULL,
	mensaje varchar(2000) NOT NULL,
	estado varchar(15) NOT NULL,
	idsolicitud int4 NOT NULL,
	servicio varchar(20) NOT NULL,
	usuario varchar(20) NOT NULL,
	CONSTRAINT solicitud_pk PRIMARY KEY (idsolicitud),
	CONSTRAINT solicitud_fk FOREIGN KEY (servicio) REFERENCES "web".servicios(nombre) DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT solicitud_fk_1 FOREIGN KEY (usuario) REFERENCES "web".usuario(nickname)
);


