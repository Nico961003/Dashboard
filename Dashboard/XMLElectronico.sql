   create database tituloProfesional;
   use tituloProfesional
   
   
create table FirmaResponsable(
idFirma                    int primary key not null auto_increment,
nombre                     varchar(50),
primerApellido             varchar(50),
segundoApellido            varchar(50),
curp                       varchar(50),  
idCargo                    int,
cargo                      varchar(50),
abrTitulo                  varchar(50),
sello                      varchar(200),
certificadoResponsable     varchar(300),
noCertificadoResponsable   varchar(50)
)

   create table Carrera(
   cveCarrera 						int not null,
   nombreCarrera 					varchar(50), 
   fechaInicio                      date,
   fechaTerminacion     			date,
   idAutorizacionReconocimiento     int,
   autorizacion_reconocimiento 		varchar(50)
   )  
   
   
   create table Profesionista(
   Matricula			int primary key not null,
   Nombre				varchar(50),
   apellidoPaterno 		varchar(50),
   apellidoMaterno		varchar(50),
   CURP					varchar(50),
   Correo			    varchar(50)
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
    fundamentoSS 					varchar(50),
    
	clave 							varchar(50),
    nombreCarrera 					varchar(50),
    numeroRvoe 						varchar(50),
    clave_autorizacion 				varchar(50),
    autorizacion_reconocimiento		varchar(50),
    
    institucionProcedencia			varchar(50),
    idEntidadFederativa 			varchar(50),
	eFederativa						varchar(50),
    fechaAntInicio 					varchar(50),
    fechaAntTermino					varchar(50),
    idTipoEstudioAntecedente		varchar(50),
	tipodeEstudio 					varchar(50),
    noCedula  						varchar(50),
    
    estatus							varchar(1)
    
)

INSERT INTO txt(folioControl,fechaExpedicion,idModalidadTitulacion, 
modalidadTitulacion,fechaExamen,matricula,nombre,aPaterno,aMaterno,correo,CURP,sSocial, 
idFundamentoLegalServicioSocial,fundamentoSS,clave,nombreCarrera,numeroRvoe,clave_autorizacion,autorizacion_reconocimiento, 
institucionProcedencia,idEntidadFederativa,eFederativa,fechaAntInicio,fechaAntTermino,
idTipoEstudioAntecedente,tipodeEstudio,noCedula ) VALUES ('123','2020-01-18','1','POR TESIS','2020-01-15','6547','JOSE LUIS','LIMON','SANCHEZ','jlimon@gmail.com','JLIMONS5498CN06','1','1','ART. 52 LRART. 5 CONST','3','LICENCIATURA EN CIENCIAS DE LA COMUNICACIÓN','20192815','1','RVOE FEDERAL','TESE','01','AGUASCALIENTES','2020-01-18','2020-01-30','1','MAESTRÍA','123','A')





select * from txt
    --curpResponsable 
    --idCargo 
    --cargo 
    --abrTitulo 



create user root@localhost identified by'Supervi$or123'
GRANT ALL PRIVILEGES ON tituloProfesional.* TO 'root'@'localhost';