create table pedido (
	idpedido bigserial not null,
	numero  bigint not null,
	situacao varchar(20) not null,
    idcliente bigint not null,
    dataPedido timestamp not null,
    
	primary key(idpedido)
);

alter table pedido add constraint fk_pedido_cliente
foreign key (idcliente) references cliente (idcliente);