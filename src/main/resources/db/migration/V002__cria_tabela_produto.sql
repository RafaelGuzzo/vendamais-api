create table produto (
	idproduto bigint not null auto_increment,
	codigo  varchar(60) not null,
    descricao  varchar(255) not null,
    preço decimal(10,2) not null,
    
	primary key(idproduto)
);

INSERT INTO produto(idproduto,codigo,descricao,preço)
VALUES(1,'PPTS7','pano de prato semaninha 7x15',12.50);

INSERT INTO vendamais.produto(idproduto,codigo,descricao,preço)
VALUES(2,'PPL01','pano de prato liso 15x15',9.00);

INSERT INTO vendamais.produto(idproduto,codigo,descricao,preço)
VALUES(3,'PCF40','pano de chão felpudo 40x60',7.50);

INSERT INTO produto(idproduto,codigo,descricao,preço)
VALUES(4,'PPBD2','pano de prato bordado 25x15',18.75);

INSERT INTO vendamais.produto(idproduto,codigo,descricao,preço)
VALUES(5,'PPL02','pano de prato liso 25x15',10.00);

INSERT INTO vendamais.produto(idproduto,codigo,descricao,preço)
VALUES(6,'PCF41','pano de chão felpudo M 45x60',9.50);