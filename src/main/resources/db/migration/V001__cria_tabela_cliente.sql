create table cliente (
	idcliente bigint not null auto_increment,
	razaosocial  varchar(80) not null,
    cnpj  varchar(60) not null,
    telefone varchar(20),
	email varchar(255) not null,
	
	primary key(idcliente)
);


INSERT INTO cliente(idcliente,razaosocial,cnpj,telefone,email)
VALUES(1,'comercio de bebidas jacarezinho ltda','0000012345678','123456789','jacarezinhobebidas@mail.com');

INSERT INTO cliente(idcliente,razaosocial,cnpj,telefone,email)
VALUES(2,'pizzaria bom gosto','0000023345279','123456789','bomgosto@mail.com');

INSERT INTO cliente(idcliente,razaosocial,cnpj,telefone,email)
VALUES(3,'pastelaria do lado de fora','0000087654321','123456789','pastelaria@mail.com');