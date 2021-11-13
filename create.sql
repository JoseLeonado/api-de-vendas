create table tb_cliente (id integer not null auto_increment, data_nascimento varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table tb_compras (id integer not null auto_increment, data_compra date, total_compra double precision, cliente_id integer, primary key (id)) engine=InnoDB
alter table tb_compras add constraint FKto1hl9btn8n1ssr1yglhog601 foreign key (cliente_id) references tb_cliente (id)
INSERT INTO tb_cliente(nome, data_nascimento) VALUES('Maria', '14/12/2000')
INSERT INTO tb_compras(cliente_id, total_compra, data_compra) VALUES(1, 100.0, '2021-05-15')
