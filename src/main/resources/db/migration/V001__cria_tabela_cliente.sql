create table cliente (
	idcliente bigserial not null,
	razaosocial  varchar(80) not null,
    cnpj  varchar(60) not null,
    telefone varchar(20),
	email varchar(255) not null,
	
	primary key(idcliente)
);
