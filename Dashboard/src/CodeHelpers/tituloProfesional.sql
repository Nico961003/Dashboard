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
    pass						blob,
	idResponsable               varchar(30)
);
alter table Responsable
modify pass blob
delete from Responsable where Clave=1
drop table Responsable
select * from Responsable
INSERT INTO Responsable VALUES ('1', 'GENARO', 'RODRIGUEZ', 
'NICOLAS', 'DIRECTOR', 'DIRECTOR', 'ING.', 
'/home/genaro/Documentos/Cer_Key_ConPassword(2019UVictoria)/FirmaEncryJBV.key', 
'/home/genaro/Documentos/Cer_Key_ConPassword(2019UVictoria)/CertificadoJBV.cer',
aes_encrypt('2019UVictoria','xyz123'), '1');
INSERT INTO Responsable VALUES ('2', 'JUANA', 'REYES', 'ROSALES', 
'REYESOSDFIONH5006', 'RECTOR', 'ING.', 
'/home/genaro/Documentos/Cer_Key_ConPassword(2019UVictoria)/FirmaEncryMOR.key', 
'/home/genaro/Documentos/Cer_Key_ConPassword(2019UVictoria)/CertificadoMOR.cer',
aes_encrypt('2019UVictoria','xyz123'), '3');
delete from Responsable where Clave=1
select cast(aes_decrypt(pass, 'xyz123') as char) from Responsable where Clave=1
update Responsable set pass=aes_encrypt('2019UVictoria','xyz123') where Clave=1
delete from Responsable where Clave = 1
INSERT INTO Responsable VALUES (1,AES_ENCRYPT('522752','2019UVictoria'));
create procedure `firmante1`()
select idResponsable, Nombre, apellidoPaterno, apellidoMaterno,
CURP, Puesto, abrev, Llave, Certificado, cast(aes_decrypt(pass, 'xyz123') as char) from Responsable
where Clave=1
create procedure `firmante2`()
select idResponsable, Nombre, apellidoPaterno, apellidoMaterno,
CURP, Puesto, abrev, Llave, Certificado, cast(aes_decrypt(pass, 'xyz123') as char) from Responsable
where Clave=2
call firmante2
call firmante1
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
SELECT * FROM Profesionista WHERE Matricula LIKE CONCAT('%', buscar , '%')  
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
IN abr text,
IN Llave text,
IN Certificado text,
IN pass varchar(512),
IN inClave text
)
Update Responsable set Nombre= Nombre, apellidoPaterno= apellidoPaterno, apellidoMaterno= apellidoMaterno,
                       CURP= CURP, Puesto= Puesto, abrev= abr,Llave= Llave, Certificado= Certificado,
                       pass= (SHA2(" + pass + ",512))  where Clave= inClave    
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
IN pass text
)

INSERT INTO Responsable(Clave, Nombre, apellidoPaterno, apellidoMaterno, CURP, Puesto, abrev, Llave, Certificado, pass) VALUES ( Clave, Nombre, apellidoPaterno,
                     apellidoMaterno, CURP, Puesto, abr, Llave, Certificado, AES_ENCRYPT('text', UNHEX(SHA2(pass,512))))

-- Correccion de Posibles errores de autenticacion de Java con MySQL8
create user genaro@localhost identified by'Supervi$or_123'
GRANT ALL PRIVILEGES ON tituloProfesional.* TO 'genaro'@'localhost';
ALTER USER 'genaro'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Supervi$or_123';
-- data long = entrar a terminal al usuario correspondiente en mysql
-- meter el siguiente comando:
SET @@global.sql_mode= '';
-- ademas en el menu Edit/Preferences/Safe mode, es necesario desactivar
-- y volver a reconectar


select * from configuracion
'090653', 'UNIVERSIDAD VICTORIA', '/home/genaro/Documentos/'
