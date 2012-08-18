insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Cajuru', 89012099, 'CTBA', '', 'PR', 500,'Das rosas amarelas', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Ap', 98776547, 'SJP', '', 'PR', 1500,'Travessa rosa', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('AV', 98769809, 'CTBA', '', 'PR', 500,'Pra�a rosa', nextval('seq_endereco'));

INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 123456789, 'aaa@aaa.com', 12345, 'ScholaRatio1', 12345234, 1);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 234567890, 'bbb@bbb.com', 23456, 'ScholaRatio2', 23452345, 2);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 345678901, 'ccc@ccc.com', 12345, 'ScholaRatio3', 34563456, 3);

insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'33333333333','2003-08-15','wwwrrr@email.com','1','Brasileiro','S�o Vicente','Astolpho P Cruz','','','SSP-SP','2222222222','123qwe','M','ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'55555555555','1994-06-10','xxxxxx@email.com','2','Canadense','Curitiba','Josepha P Silva','','','SSP-SP','11111111','123qwe','F','ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'88888888888','1999-04-01','oooooo@email.com','3','Brasileiro','S�o Jos� dos Pinhais','Jeronimo Pires','','','SSP-RS','54387621','123qwe','M','ATIVO','RS','2012-08-18');



INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao1', 'tipopermissao1');
INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao2', 'tipopermissao2');
INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao3', 'tipopermissao3');



