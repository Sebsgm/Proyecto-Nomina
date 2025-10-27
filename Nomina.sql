CREATE DATABASE Nomina;

USE Nomina;

CREATE TABLE usuario(
	id_usuario int primary key auto_increment,
    Nombre_usuario varchar(45),
    contraseña varchar(45),
    estado boolean
);

CREATE TABLE cargo(
	id_cargo int primary key,
    Nombre_cargo varchar(45)
);

INSERT INTO cargo (id_cargo, Nombre_cargo) VALUES
(1, 'Analista de Sistemas'),
(2, 'Desarrollador Full Stack'),
(3, 'Administrador de Empresas'),
(4, 'Contador'),
(5, 'Asistente Administrativo'),
(6, 'Técnico de Soporte'),
(7, 'Ingeniero de Proyectos'),
(8, 'Gerente de TI');

CREATE TABLE departamento(
	id_departamento int primary key,
    Nombre_departamento varchar(45)
);

INSERT INTO departamento (id_departamento, Nombre_departamento) VALUES
(1, 'Tecnología'),
(2, 'Finanzas'),
(3, 'Talento Humano'),
(4, 'Administración'),
(5, 'Logística'),
(6, 'Proyectos'),
(7, 'Comercial'),
(8, 'Servicio al Cliente');


CREATE TABLE tipoContrato(
	id_tipoContrato int primary key,
    tipo_contrato varchar(45)
);

INSERT INTO tipoContrato (id_tipoContrato, tipo_contrato) VALUES
(1, 'Término indefinido'),
(2, 'Término fijo'),
(3, 'Obra o labor'),
(4, 'Aprendizaje'),
(5, 'Prestación de servicios'),
(6, 'Ocasional o accidental');


CREATE TABLE empleado(
		cedula bigint primary key  not null,
		Nombre_completo varchar(50) not null,
		fecha_ingreso date not null,
		fecha_retiro date,
		telefono bigint not null,
		id_cargo int not null,
		id_departamento int not null,
		id_tipoContrato int not null,
		foreign key (id_cargo) references cargo(id_cargo),
		foreign key (id_departamento) references departamento(id_departamento),
		foreign key (id_tipoContrato) references tipoContrato(id_tipoContrato)
);

CREATE TABLE banco(
	id_banco int primary key auto_increment,
    Nombre_banco varchar(45),
    Tipo_cuenta varchar(45),
    Numero_de_cuenta varchar(15),
    id_cedula bigint,
    foreign key (id_cedula) references empleado(cedula)
);


CREATE TABLE Devengados(
	id_devengados int primary key auto_increment,								
    id_empleado bigint,
    salario bigint,
    Sub_transporte bigint,
    Gastos_representativos bigint,
    Viaticos bigint,
    Comisiones bigint,
    Horas_trabajadas int,
    Cantidad_horas_diurnas int,
    Cantidad_horas_nocturnas int,
    Cantidad_horas_diurnas_festivas int,
    Cantidad_horas_nocturnas_festivas int,
    Horas_extra_diurnas bigint,
    Horas_extra_nocturnas bigint,
    Horas_extra_dominicales_diurnas bigint,
    Horas_extra_dominicales_nocturnas bigint,
    foreign key (id_empleado) references empleado(cedula)
);


CREATE TABLE Descuentos (
	id_descuentos int primary key auto_increment,
    id_empleado bigint,
    salud bigint,
    pension bigint,
    credito_empleado bigint,
    foreign key (id_empleado) references empleado(cedula)
);


CREATE TABLE Pagos(
	id_pagos int primary key auto_increment,
    id_empleado bigint,
    total_devengados bigint,
    total_descuentos bigint,
    total_pago bigint,
    fecha_pago date,
    foreign key (id_empleado) references empleado(cedula)
);






