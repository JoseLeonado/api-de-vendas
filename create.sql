create table tb_cliente (id  serial not null, data_nascimento varchar(255), nome varchar(255), primary key (id))
create table tb_compras (id  serial not null, data_compra date, total_compra float8, cliente_id int4, primary key (id))
alter table tb_compras add constraint FKto1hl9btn8n1ssr1yglhog601 foreign key (cliente_id) references tb_cliente
INSERT INTO tb_cliente(nome, data_nascimento) VALUES('Maria', '14/12/2000')
INSERT INTO tb_compras(cliente_id, total_compra, data_compra) VALUES(1, 100.0, '2021-05-15')
