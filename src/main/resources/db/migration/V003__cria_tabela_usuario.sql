create table usuario (
	idusuario bigint not null auto_increment,
	nome  varchar(255) not null,
    email  varchar(255) not null,
    login  varchar(255) not null,
    senha  varchar(255) not null,
    
    unique key unique_email(email),
	primary key(idusuario)
);