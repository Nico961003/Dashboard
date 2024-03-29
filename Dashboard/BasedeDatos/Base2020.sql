create database tituloProfesional;
use tituloProfesional


create table entidadFederativa(
idEntidad_F   int primary key not null,
nombreEntidad varchar(100) 
)


create table autorizacionRec(
ID_AUTORIZACION_RECONOCIMIENTO	int(11) primary key not null ,
AUTORIZACIÓN_RECONOCIMIENTO	text
)
insert into autorizacionRec values('1', 'RVOE FEDERAL');
insert into autorizacionRec values('2', 'RVOE ESTATAL');
insert into autorizacionRec values('3', 'AUTORIZACIÓN FEDERAL');
insert into autorizacionRec values('4', 'AUTORIZACIÓN ESTATAL');
insert into autorizacionRec values('5', 'ACTA DE SESIÓN');
insert into autorizacionRec values('6', 'ACUERDO DE INCORPORACIÓN');
insert into autorizacionRec values('7', 'ACUERDO SECRETARIAL SEP');
insert into autorizacionRec values('8', 'DECRETO DE CREACIÓN');
insert into autorizacionRec values('9', 'OTRO');




create table modalidadTitulacion(
ID_MODALIDAD_TITULACIÓN	int(11) primary key not null,
CLAVE	int(11),
MODALIDAD_TITULACIÓN	text,
TIPO_DE_MODALIDAD	text
);
insert into modalidadTitulacion values('1', '1', 'POR TESIS', 'ACTA DE EXAMEN');
insert into modalidadTitulacion values('2', '2', 'POR PROMEDIO', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('3', '3', 'POR ESTUDIOS DE POSGRADOS', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('4', '4', 'POR EXPERIENCIA LABORAL', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('5', '5', 'POR CENEVAL', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('6', '6', 'OTRO', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('7', '6', 'SEMINARIO DE TITULACIÓN', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('8', '6', 'EXAMEN DE CONOCIMIENTOS GENERALES DE LA LICENCIATURA', 'CONSTANCIA DE EXENCIÓN');
insert into modalidadTitulacion values('9', '6', 'REPORTE GLOBAL DE SERVICIO SOCIAL', 'CONSTANCIA DE EXENCIÓN');


create table estudioAntecedente(
idTipoEstudioAntecedente int primary key not null,
tipodeEstudio varchar (100)
);


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

update Carreras set IdCarrera='621303' where Carrera='LICENCIATURA EN ADMINISTRACION DE EMPRESAS'
update Carreras set IdCarrera='615305' where Carrera='LICENCIATURA EN ADMINISTRACION DE EMPRESAS TURISTICAS'
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
insert into Carreras values ('615305','LICENCIATURA EN ADMINISTRACION DE EMPRESAS TURISTICAS','20080158');
insert into Carreras values ('621303','LICENCIATURA EN ADMINISTRACION DE EMPRESAS',	'2006133');
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
    numeroSerie					varchar(100),
    pass						blob,
	idResponsable               varchar(30)
);
select * from Responsable
alter table Responsable
add numeroSerie varchar(100)
modify pass blob
select cast(aes_decrypt(pass, 'xyz123') as char) from Responsable where Clave=1
select * from txt
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

-- Visualizar entidad federativa
CREATE PROCEDURE `nombreEntidadFederativa`()
SELECT nombreEntidad FROM entidadFederativa
END
-- Visualizar datos del profesionista
CREATE PROCEDURE `datosProfesionista`()
SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno, CURP, Correo FROM Profesionista
END



-- Actualizar registro profesionista
CREATE PROCEDURE actualizaProfesionista(
IN matriculaActual text,
IN Nombre text,
IN apellidoPaterno text,
IN apellidoMaterno text,
IN CURP text,
IN correo text,
IN institucionProcedencia text,
IN idEntidadFederativa text,
IN fechaInicioAntecedente text,
IN fechaTerminoAntecedente text,
IN idTipoEstudioAntecedente text,
IN tipodeEstudio text,
IN eFederativa text,
IN noCedula text
)
Update Profesionista set Nombre = Nombre, apellidoPaterno = apellidoPaterno, apellidoMaterno= apellidoMaterno
                        , CURP = CURP , Correo = correo, institucionProcedencia= institucionProcedencia
                        , idEntidadFederativa=idEntidadFederativa, fechaAntInicio= fechaInicioAntecedente, fechaAntTermino = fechaTerminoAntecedente
                        , idTipoEstudioAntecedente = idTipoEstudioAntecedente,tipodeEstudio = tipodeEstudio, eFederativa = eFederativa
                        , noCedula=noCedula WHERE Matricula = matriculaActual
                        
-- Varifica matricula 
CREATE PROCEDURE verificaMatricula(IN InMatricula text)
SELECT Matricula FROM Profesionista where Matricula = InMatricula
-- Elimina profesionista
CREATE PROCEDURE eliminaProfesionista(IN InMatricula text)
Delete from Profesionista where Matricula = InMatricula
-- busca profesionista
CREATE PROCEDURE buscaProfesionista(IN buscar text)
SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno, CURP, Correo FROM Profesionista WHERE Matricula LIKE CONCAT('%', buscar , '%')  
OR Nombre LIKE CONCAT('%', buscar , '%') 
OR apellidoPaterno LIKE CONCAT('%', buscar , '%') 
OR apellidoMaterno LIKE CONCAT('%', buscar , '%') 
OR CURP LIKE CONCAT('%', buscar , '%') 
OR Correo LIKE CONCAT('%', buscar , '%')  
-- tipo de estudio antecedente
CREATE PROCEDURE tipoEstudio(IN tipoEstudio text)
SELECT idTipoAntecedente FROM estudioAntecedente where tipoEstudioAntecedente=tipoEstudio
-- buscar id Entidad Federativa
CREATE PROCEDURE obtenIdEntidad(IN entidad text)
SELECT id_EntidadF FROM entidadFederativa where nombreEntidad=entidad
-- insertar profesionista
CREATE PROCEDURE insertaProfesionista(
IN Matricula text, 
IN Nombre text,  
IN apellidoPaterno text,  
IN apellidoMaterno text, 
IN correo text, 
IN CURP text, 
IN institucionProcedencia text, 
IN idEntidadFederativa text, 
IN eFederativa text, 
IN fechaAntInicio text, 
IN fechaAntTermino text, 
IN idTipoEstudioAntecedente text, 
IN tipodeEstudio text, 
IN noCedula text, 
IN estatus text
)
INSERT INTO Profesionista(Matricula, Nombre, apellidoPaterno, 
                     apellidoMaterno, correo, CURP, institucionProcedencia,idEntidadFederativa,eFederativa,
                     fechaAntInicio,fechaAntTermino,idTipoEstudioAntecedente,tipodeEstudio,
                     noCedula,estatus) VALUES (Matricula, Nombre, apellidoPaterno, 
                     apellidoMaterno, correo, CURP, institucionProcedencia,idEntidadFederativa,eFederativa,
                     fechaAntInicio,fechaAntTermino,idTipoEstudioAntecedente,tipodeEstudio,
                     noCedula,estatus);

-- Titulos

-- imprime tabla txt
CREATE PROCEDURE `registrosTxt`()
SELECT folioControl, matricula, nombre, aPaterno, aMaterno FROM txt WHERE estatus='A'
-- llenado de combo profesionista
CREATE PROCEDURE `llenaComboProfesionista`()
SELECT Matricula, Nombre, apellidoPaterno, apellidoMaterno FROM Profesionista where estatus='A'
-- llenado de combo Autorizacion reconocimiento
CREATE PROCEDURE `llenadoComboAutorizacionRec`()
SELECT AUTORIZACIÓN_RECONOCIMIENTO FROM autorizacionRec
-- llenado de combo modalidad titulacion
CREATE PROCEDURE `llenaComboModalidadTitulacion`()
SELECT MODALIDAD_TITULACIÓN FROM modalidadTitulacion
-- llena combo fundamentos del servicio social
CREATE PROCEDURE `llenaComboFundamentoSS`()
SELECT FUNDAMENTO_LEGAL_SERVICIO_SOCIAL FROM fundamentoSSocial
-- Actualiza estatus del profesionista
CREATE PROCEDURE actulizaEstatusProfesionista (IN InCURP text)
UPDATE Profesionista set estatus='A' where CURP=InCURP
-- elmina titulo
CREATE PROCEDURE eliminaTitulo(IN folio text)
Delete from txt where folioControl = folio
-- visualiza informacion a detalle de un titulo
CREATE PROCEDURE visualizaDetalles (IN folio text)
SELECT modalidadTitulacion,correo, nombreCarrera, fechaExpedicion, fechaExamen,
       fechaExamen, sSocial, fundamentoSS, autorizacion_reconocimiento,
       institucionProcedencia, fechaAntInicio, fechaAntTermino FROM txt where folioControl = folio
-- busca titulo
CREATE PROCEDURE buscaTitulo (IN buscar text)
SELECT folioControl, matricula, nombre, aPaterno, aMaterno
FROM txt WHERE folioControl  LIKE CONCAT('%', buscar , '%')  
OR matricula LIKE CONCAT('%', buscar , '%') 
OR nombre LIKE CONCAT('%', buscar , '%') 
OR aPaterno LIKE CONCAT('%', buscar , '%') 
OR aMaterno LIKE CONCAT('%', buscar , '%') 
-- busca txt Y XML
CREATE PROCEDURE buscaTxt (IN buscar text)
SELECT matricula, nombre, aPaterno, aMaterno, estatus FROM txt 
where matricula LIKE CONCAT('%', buscar , '%') 
OR nombre LIKE CONCAT('%', buscar , '%') 
OR aPaterno LIKE CONCAT('%', buscar , '%') 
OR aMaterno LIKE CONCAT('%', buscar , '%') 
call buscaTxt(201510019)
 -- obten id modalidad titulacion
 CREATE PROCEDURE obtenIdModalidadTitulacion(IN modalidadTitulacion text)
 SELECT CLAVE FROM modalidadTitulacion where MODALIDAD_TITULACIÓN=modalidadTitulacion
-- obten id autorizacion reconocimiento
CREATE PROCEDURE obtenIdAutorizacionRec(IN autRec text)
SELECT ID_AUTORIZACION_RECONOCIMIENTO FROM autorizacionRec where AUTORIZACIÓN_RECONOCIMIENTO=autRec
-- obten id enteidad federativa
CREATE PROCEDURE obtenIdEntidadFed (IN nombreE text)
SELECT id_EntidadF FROM entidadFederativa where nombreEntidad=nombreE
-- obten fundamento servicio social
CREATE PROCEDURE obtenIdFundamentoSS(IN fundamento text)
SELECT ID_FUNDAMENTO_LEGAL_SERVICIO_SOCIAL FROM fundamentoSSocial where FUNDAMENTO_LEGAL_SERVICIO_SOCIAL=fundamento
-- obten el id del tipo de antecedente
CREATE PROCEDURE obtenIdTipoAntecedente(IN tipo text)
SELECT idTipoAntecedente FROM estudioAntecedente where tipoEstudioAntecedente=tipo
-- inserta un titulo a la BD
CREATE PROCEDURE insertaTitulo(
IN folioControl text,
IN fechaExpedicion text,
IN idModalidadTitulacion text,
IN modalidadTitulacion text,
IN fechaExamen text,
IN matricula text,
IN nombre text,
IN aPaterno text,
IN aMaterno text,
IN correo text,
IN CURP text,
IN sSocial text,
IN idFundamentoLegalServicioSocial text,
IN idEntidadFederativa text,
IN eFederativa text,
IN fundamentoSS text,
IN clave text,
IN nombreCarrera text,
IN numeroRvoe text,
IN fechaInicioCarrera text,
IN fechaFinCarrera text,
IN clave_autorizacion text,
IN autorizacion_reconocimiento text,
IN institucionProcedencia text,
IN idEntidadFederativa2 text,
IN eFederativa2 text,
IN fechaAntInicio text,
IN fechaAntTermino text,
IN idTipoEstudioAntecedente text,
IN tipodeEstudio text,
IN noCedula text,
IN estatus text,
IN archivo0 text,
IN archivo1 text,
IN archivo2 text,
IN archivo3 text,
IN archivo4 text
)
INSERT INTO txt(folioControl,fechaExpedicion,idModalidadTitulacion,
					modalidadTitulacion,fechaExamen,matricula,nombre,aPaterno,aMaterno,correo,CURP,sSocial,
                    idFundamentoLegalServicioSocial,idEntidadFederativa,eFederativa,fundamentoSS,clave,nombreCarrera,
                    numeroRvoe,fechaInicioCarrera,fechaFinCarrera,clave_autorizacion,autorizacion_reconocimiento,
                    institucionProcedencia,idEntidadFederativa2,eFederativa2,fechaAntInicio,fechaAntTermino,
                    idTipoEstudioAntecedente,tipodeEstudio,noCedula,estatus,archivo0,archivo1,archivo2,archivo3,archivo4) VALUES (
					folioControl,fechaExpedicion,idModalidadTitulacion,
					modalidadTitulacion,fechaExamen,matricula,nombre,aPaterno,aMaterno,correo,CURP,sSocial,
                    idFundamentoLegalServicioSocial,idEntidadFederativa,eFederativa,fundamentoSS,clave,nombreCarrera,
                    numeroRvoe,fechaInicioCarrera,fechaFinCarrera,clave_autorizacion,autorizacion_reconocimiento,
                    institucionProcedencia,idEntidadFederativa2,eFederativa2,fechaAntInicio,fechaAntTermino,
                    idTipoEstudioAntecedente,tipodeEstudio,noCedula,estatus,archivo0,archivo1,archivo2,archivo3,archivo4)
-- Actualiza estatus del profesionista a baja 
CREATE PROCEDURE actulizaBajaProfesionista (IN InMatricula text)
UPDATE Profesionista set estatus='B' where Matricula=InMatricula

-- Responsables

-- imprime tabla responsables
CREATE PROCEDURE `registroResponsable`()
SELECT Clave, Nombre, apellidoPaterno, apellidoMaterno, CURP, Puesto  FROM Responsable
-- actualizar datos responsable
CREATE PROCEDURE actualizaResponsable(
IN Nombre text,
IN apellidoPaterno text,
IN apellidoMaterno text,
IN CURP text,
IN Puesto text,
IN abrev text,
IN Llave text,
IN Certificado text,
IN numeroSerie text,
IN pass text,
IN idResponsable text,
IN inClave text
)
Update Responsable set Nombre= Nombre, apellidoPaterno= apellidoPaterno, apellidoMaterno= apellidoMaterno,
                       CURP= CURP, Puesto= Puesto, abrev= abrev,Llave= Llave, Certificado= Certificado, numeroSerie= numeroSerie,
                       pass= aes_encrypt(pass,'xyz123'), idResponsable=idResponsable  where Clave= inClave    
-- llena campos de formulario
CREATE PROCEDURE llenaCampos(IN inCURP text)
SELECT Clave, Llave, Certificado, abrev  FROM Responsable where CURP= inCURP
-- inserta responsable
CREATE PROCEDURE insertaResponsable(
IN Clave text,
IN Nombre text,
IN apellidoPaterno text,
IN apellidoMaterno text,
IN CURP text,
IN Puesto text,
IN abrev text,
IN Llave text,
IN Certificado text,
IN numeroSerie text,
IN pass text,
IN idResponsable int
)

INSERT INTO Responsable(Clave, Nombre, apellidoPaterno, apellidoMaterno, CURP, Puesto, abrev, Llave, Certificado, numeroSerie, pass, idResponsable) VALUES ( Clave, Nombre, apellidoPaterno,
                     apellidoMaterno, CURP, Puesto, abrev, Llave, Certificado, numeroSerie, aes_encrypt(pass,'xyz123'), idResponsable)

-- Correccion de Posibles errores de autenticacion de Java con MySQL8
create user genaro@localhost identified by'Supervi$or_123'
GRANT ALL PRIVILEGES ON tituloProfesional.* TO 'genaro'@'localhost';
ALTER USER 'genaro'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Supervi$or_123';
-- data long = entrar a terminal al usuario correspondiente en mysql
-- meter el siguiente comando:
SET @@global.sql_mode= '';
-- ademas en el menu Edit/Preferences/Safe mode, es necesario desactivar
-- y volver a reconectar