create table usuario (
	idusuario bigserial not null,
	nome  varchar(255) not null,
    email  varchar(255) not null unique,
    login  varchar(255) not null,
    senha  varchar(255) not null,
    
	primary key(idusuario)
);

INSERT INTO usuario (idusuario, nome, email, login, senha) values (1, 'Administrador', 'admin@vendamais.com','admin', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');