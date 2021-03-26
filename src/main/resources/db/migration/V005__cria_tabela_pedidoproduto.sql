create table pedidoproduto (
	idpedidoproduto bigserial not null,
	idpedido  bigint not null,
    idproduto bigint not null,
    quantidade bigint not null,
    
	primary key(idpedidoproduto)
);

alter table pedidoproduto add constraint fk_pedidoproduto_pedido
foreign key (idpedido) references pedido (idpedido) on delete cascade on update cascade;

alter table pedidoproduto add constraint fk_pedidoproduto_produto
foreign key (idproduto) references produto (idproduto) on delete cascade on update cascade;