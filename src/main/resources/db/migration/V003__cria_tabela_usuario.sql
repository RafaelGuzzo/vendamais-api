create table usuario (
	idusuario bigserial not null,
	nome  varchar(255) not null,
    email  varchar(255) not null unique,
    login  varchar(255) not null,
    senha  varchar(255) not null,
    
	primary key(idusuario)
);