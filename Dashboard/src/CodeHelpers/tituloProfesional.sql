create database tituloProfesional;
use tituloProfesional


 create table Profesionista(
    Matricula					int primary key not null,
    Nombre						varchar(50),
    apellidoPaterno 			varchar(50),
    apellidoMaterno				varchar(50),
    Correo						varchar(50),
    CURP			    		varchar(50),
    institucionProcedencia		varchar(50),
    idEntidadFederativa 		varchar(50),
	eFederativa					varchar(50),
    fechaAntInicio 				varchar(50),
    fechaAntTermino				varchar(50),
    idTipoEstudioAntecedente	varchar(50),
	tipodeEstudio 				varchar(50),
    noCedula  					varchar(50),
    estatus						varchar(1)
   )
 
create table txt(
	folioControl					varchar(50), 
    fechaExpedicion 				varchar(50),
    idModalidadTitulacion			varchar(50),
	modalidadTitulacion				varchar(50),
    fechaExamen 					varchar(50),
    
    matricula 						varchar(50),
    nombre 							varchar(50),
    aPaterno 						varchar(50),
    aMaterno 						varchar(50),
    correo 							varchar(50),
    CURP 							varchar(50),
	sSocial 						varchar(50),
    idFundamentoLegalServicioSocial	varchar(50),
    idEntidadFederativa 			varchar(50),
	eFederativa						varchar(50),
    fundamentoSS 					varchar(200),
    
	clave 							varchar(50),
    nombreCarrera 					varchar(70),
    numeroRvoe 						varchar(50),
    fechaInicioCarrera				varchar(50),
    fechaFinCarrera					varchar(50),
    clave_autorizacion 				varchar(50),
    autorizacion_reconocimiento		varchar(50),
    
    institucionProcedencia			varchar(50),
    idEntidadFederativa2 			varchar(50),
	eFederativa2					varchar(50),
    fechaAntInicio 					varchar(50),
    fechaAntTermino					varchar(50),
    idTipoEstudioAntecedente		varchar(50),
	tipodeEstudio 					varchar(50),
    noCedula  						varchar(50),

    estatus							varchar(1),
    archivo0						text(65535),
    archivo1						text(65535),
    archivo2						text(65535),
    archivo3						text(65535),
    archivo4						text(65535),
    
    firma0						 	varchar(400),
    firma1						 	varchar(400),
    firma2						 	varchar(400),
    firma3						 	varchar(400),
    firma4						 	varchar(400)

)


create table Carreras (
IdCarrera   int primary key not null,
Carrera     varchar(200),
noRvoe      int
)


insert into Carreras values ('207380','LICENCIATURA EN ENSEÑANZA DE LA LENGUA INGLESA', '2006444');
insert into Carreras values ('231301','LICENCIATURA EN PSICOLOGIA',	'20081467');
insert into Carreras values ('622306','LICENCIATURA EN MERCADOTECNIA','20080094');
insert into Carreras values ('514384','LICENCIATURA EN INGENIERIA MECATRONICA','20080093');
insert into Carreras values ('521315','LICENCIATURA EN INGENIERIA INDUSTRIAL Y DE SISTEMAS','20080179');
insert into Carreras values ('521312','LICENCIATURA EN INGENIERIA EN SISTEMAS COMPUTACIONALES','2006135');
insert into Carreras values ('615318','LICENCIATURA EN GASTRONOMIA','20110312');
insert into Carreras values ('612301','LICENCIATURA EN DERECHO','2006134');
insert into Carreras values ('607316','LICENCIATURA EN CONTADURIA PUBLICA','2006136');
insert into Carreras values ('621317','LICENCIATURA EN COMERCIO INTERNACIONAL','20080092');
insert into Carreras values ('611310','LICENCIATURA EN CIENCIAS DE LA COMUNICACION','20080091');
insert into Carreras values ('621303','LICENCIATURA EN ADMINISTRACION DE EMPRESAS TURISTICAS','20080158');
insert into Carreras values ('615305','LICENCIATURA EN ADMINISTRACION DE EMPRESAS',	'2006133');
insert into Carreras values ('771302','LICENCIATURA EN DISEÑO GRAFICO',	'20080176');


create table Responsable(
	Clave						int primary key not null,
	Nombre 						varchar(50),
	apellidoPaterno 			varchar(50),
	apellidoMaterno 			varchar(50),
	CURP 						varchar(50),
	Puesto 						varchar(50),
    abrev						varchar(50),
	Llave 						varchar(500),
	Certificado 				varchar(500),
    pass						varchar(100),
	idResponsable               varchar(30)
);


create table configuracion(
claveEscuela 		      varchar(500),
nombreEscuela			  varchar(500),
carpeta                   varchar(500)
)

/***************** PROCEDIMIENTOS ALMACENADOS ********************************/
-- Carreras

-- Visualizar la tabla carreras
CREATE PROCEDURE `Carreras`()
SELECT * FROM Carreras
END
-- Busqueda en la tabla carreras
CREATE PROCEDURE Busqueda(IN buscar text)
SELECT * FROM Carreras WHERE IdCarrera LIKE CONCAT('%', buscar , '%')  
OR Carrera LIKE CONCAT('%', buscar , '%') 
OR noRvoe LIKE CONCAT('%', buscar , '%') 
-- Insercion en tabla carreras
CREATE PROCEDURE guardaCarrera(
IN IdCarrera text,
IN Carrera text,
IN noRvoe text
)
INSERT INTO Carreras(IdCarrera, Carrera, noRvoe) VALUES (IdCarrera, Carrera, noRvoe)
-- Eliminar un registro en la tabla carreras
CREATE PROCEDURE eliminaCarrera(IN Carrera text)
DELETE FROM Carreras WHERE IdCarrera=Carrera
-- Actualizar registro en tabla carreras
CREATE PROCEDURE actualizaCarrera(
IN Carrera text,
IN noRvoe text,
IN cveCarrera text
)
UPDATE Carreras SET Carrera = Carrera, noRvoe = noRvoe WHERE IdCarrera = cveCarrera
-- Verificar si existe la carrera
CREATE PROCEDURE verificaCveCarrera(IN cveCarrera text)
SELECT IdCarrera FROM Carreras WHERE IdCarrera = cveCarrera

-- Profesionista
CREATE PROCEDURE nombreEntidadFederativa
SELECT nombreEntidad FROM entidadFederativa



-- Correccion de Posibles errores de autenticacion de Java con MySQL8
create user genaro@localhost identified by'Supervi$or_123'
GRANT ALL PRIVILEGES ON tituloProfesional.* TO 'genaro'@'localhost';
ALTER USER 'genaro'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Supervi$or_123';
-- data long = entrar a terminal al usuario correspondiente en mysql
-- meter el siguiente comando:
SET @@global.sql_mode= '';
-- ademas en el menu Edit/Preferences/Safe mode, es necesario desactivar
-- y volver a reconectar
