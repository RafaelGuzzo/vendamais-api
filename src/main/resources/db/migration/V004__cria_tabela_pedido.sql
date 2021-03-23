create table pedido (
	idpedido bigint not null auto_increment,
	numero  bigint not null,
    idcliente bigint not null,
    dataPedido datetime not null,
    
	primary key(idpedido)
);

alter table pedido add constraint fk_pedido_cliente
foreign key (idcliente) references cliente (idcliente);