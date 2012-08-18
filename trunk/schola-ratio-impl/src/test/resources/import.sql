insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Cajuru', 89012099, 'CTBA', '', 'PR', 500,'Das rosas amarelas', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Ap', 98776547, 'SJP', '', 'PR', 1500,'Travessa rosa', nextval('seq_endereco'));

INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 123456789, 'aaa@aaa.com', 12345, 'ScholaRatio1', 12345234, 1);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 234567890, 'bbb@bbb.com', 23456, 'ScholaRatio2', 23452345, 1);
