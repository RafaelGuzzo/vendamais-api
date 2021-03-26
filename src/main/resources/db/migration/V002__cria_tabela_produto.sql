create table produto (
	idproduto bigserial not null,
	codigo  varchar(60) not null,
    descricao  varchar(255) not null,
    preco decimal(10,2) not null,
    
	primary key(idproduto)
);
