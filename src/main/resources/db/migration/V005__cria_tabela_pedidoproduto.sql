create table pedidoproduto (
	idpedidoproduto bigint not null auto_increment,
	idpedido  bigint not null,
    idproduto bigint not null,
    quantidade bigint not null,
    
	primary key(idpedidoproduto)
);

alter table pedidoproduto add constraint fk_pedidoproduto_pedido
foreign key (idpedido) references pedido (idpedido);

alter table pedidoproduto add constraint fk_pedidoproduto_produto
foreign key (idproduto) references produto (idproduto);