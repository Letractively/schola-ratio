insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Cajuru', 89012099, 'CTBA', '', 'PR', 500,'Das rosas amarelas', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Afonso Pena', 98776547, 'SJP', '', 'PR', 1500,'Rua de cima', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Agua Verde', 98753245, 'SVT', '', 'PR', 500,'Rua sem saida', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Pq da fonte', 98769809, 'CTBA', '', 'PR', 500,'Rua de baixo', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Parque das Bandeiras', 98769809, 'CTBA', '', 'PR', 500,'Praça Brasil', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Nova SV', 98769809, 'CTBA', '', 'PR', 500,'Rua amarela', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Ponte Nova', 98769809, 'CTBA', '', 'PR', 65,'Praça vermelha', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Boneca do Iguacu', 98769809, 'CTBA', '', 'PR', 500,'Praça azul', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Centro', 98769809, 'CTBA', '', 'PR', 56,'Rua 1098', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Rebouças', 98769809, 'CTBA', '', 'PR', 21,'Praça 1234', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Vila Nova', 98769809, 'CTBA', '', 'PR', 6542,'Rua 12 rosa', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Independencia', 98769809, 'CTBA', '', 'PR', 53,'Rua 10 rosa', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Rebouças', 98769809, 'CUBTAO', '', 'PR', 09877,'Praça 1234', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Vila Nova', 98769809, 'CTBA', '', 'PR', 508560,'Rua 12 rosa', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Independencia', 98769809, 'STOS', '', 'PR', 432,'Rua 10 rosa', nextval('seq_endereco'));

INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 123456789, 'aaa@aaa.com', 12345, 'ScholaRatio1', 12345234, 1);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 234567890, 'bbb@bbb.com', 23456, 'ScholaRatio2', 23452345, 2);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 345678901, 'ccc@ccc.com', 12345, 'ScholaRatio3', 34563456, 3);

INSERT INTO tb_user_roles(id, userrole) VALUES (1, 'ROLE_ACA');
INSERT INTO tb_user_roles(id, userrole) VALUES (2, 'ROLE_ADM');
INSERT INTO tb_user_roles(id, userrole) VALUES (3, 'ROLE_CFG');
INSERT INTO tb_user_roles(id, userrole) VALUES (4, 'ROLE_FIN');
INSERT INTO tb_user_roles(id, userrole) VALUES (5, 'ROLE_USR');
INSERT INTO tb_user_roles(id, userrole) VALUES (6, 'ROLE_ALU');

insert into tb_user_login( user_name, enable, password) values ( 'user_name1', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name2', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name3', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name4', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');

insert into tb_user_login( user_name, enable, password) values ( 'user_name5', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name6', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name7', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name8', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');

insert into tb_user_login( user_name, enable, password) values ( 'user_name9', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name10', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name11', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');
insert into tb_user_login( user_name, enable, password) values ( 'user_name12', 'TRUE', '7751a23fa55170a57e90374df13a3ab78efe0e99');



INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name1', 1);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name1', 2);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name1', 4);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name2', 2);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name2', 5);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name3', 3);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name4', 3);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name4', 4);

INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name5', 1);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name6', 1);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name7', 1);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name8', 1);

INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name9', 6);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name10', 6);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name11', 6);
INSERT INTO tb_user_login_tb_user_roles(tb_user_login_user_name, permissoes_id) VALUES ('user_name12', 6);


INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'PRIMEIRO', 15, 9.5);
INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'SEGUNDO', 20, 2);
INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'FINAL', 10, 7.5);


INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso1', 'ATIVO', 1);
INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso2', 'ATIVO', 2);
INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso3', 'ATIVO', 3);



INSERT INTO tb_usuario(usuario_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 12312312312, '2001-10-15', 'xpto@hgf3d3', 'Japones', 'Tokio', 'Takyo H San', '', '', 'XXYYZZ', 43221534, 'user_name1','M', 'INATIVO', 'RJ', 8);
INSERT INTO tb_usuario(usuario_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 45645645645, '1999-12-05', 'dasg@3gvcfdx', 'Chines', 'Guangdzu', 'Hong Chin Kong', '', '', 'XXYYZZ', 654234677, 'user_name2','M', 'ATIVO', 'AP', 9);
INSERT INTO tb_usuario(usuario_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 78978978990, '2001-01-12', 'hgftu@rtfdx', 'Brasileiro', 'Pará', 'Anonieta dos Santos', '', '', 'DDEESS', 6432098778, 'user_name3','F', 'ATIVO', 'SP', 10);
INSERT INTO tb_usuario(usuario_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 48978978990, '2001-01-14', '44444@rtfdx', 'Brasileiro', 'Pará', 'Anonieta dos Santos', '', '', '4SS', 4444098778, 'user_name4','F', 'ATIVO', 'SP', 11);


INSERT INTO tb_professor( professor_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name, sexo, telefone ,status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 111111, '2010-04-01', '111@111.com', 'nacionalidade1', 'naturalidade1', 'nome1', 'nomema1', 'nomepai1', 'orgaoexpeditor', 111, 'user_name5', 'M', '1111-1111', 'ATIVO', 'PR', 'descricaotitulo1', 'MESTRADO', 12);
INSERT INTO tb_professor( professor_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name, sexo, telefone ,status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 222222, '2010-04-02', '222@222.com', 'nacionalidade2', 'naturalidade2', 'nome2', 'nomema2', 'nomepai2', 'orgaoexpeditor', 222, 'user_name6', 'M', '2222-2222', 'ATIVO', 'PR', 'descricaotitulo2', 'MESTRADO', 13);
INSERT INTO tb_professor( professor_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name, sexo, telefone ,status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 333333, '2010-04-03', '333@333.com', 'nacionalidade3', 'naturalidade3', 'nome3', 'nomema3', 'nomepai3', 'orgaoexpeditor', 333, 'user_name7', 'M', '3333-3333', 'ATIVO', 'PR', 'descricaotitulo3', 'MESTRADO', 14);
INSERT INTO tb_professor( professor_id, cpf, dataNascimento, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, user_name, sexo, telefone ,status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 444444, '2010-04-04', '444@444.com', 'nacionalidade4', 'naturalidade4', 'nome4', 'nomema4', 'nomepai4', 'orgaoexpeditor', 444, 'user_name8', 'M', '5555-5555', 'ATIVO', 'PR', 'descricaotitulo4', 'MESTRADO', 15);

insert into tb_aluno (aluno_id, cpf, user_name, dataNascimento, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, sexo, telefone ,status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'33333333333','user_name9','2003-08-15','wwwrrr@email.com','4','Brasileiro','São Vicente','Astolpho P Cruz','','','SSP-SP','2222222222','M', '3333-3333' , 'ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, user_name, dataNascimento, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg,  sexo, telefone ,status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'55555555555','user_name10','1994-06-10','xxxxxx@email.com','5','Canadense','Curitiba','Josepha P Silva','','','SSP-SP','11111111','F', '4444-4444', 'ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, user_name, dataNascimento, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg,  sexo, telefone ,status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'88888888888','user_name11','1999-04-01','oooooo@email.com','6','Brasileiro','São José dos Pinhais','Jeronimo Pires','','','SSP-RS','54387621','M', '7777-7777' ,'ATIVO','RS','2012-08-18');
insert into tb_aluno (aluno_id, cpf, user_name, dataNascimento, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg,  sexo, telefone ,status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'44444444444','user_name12','1994-04-01','444444@email.com','7','Brasileiro','São José dos Pinhais','Jeronimo Pires','','','SSP-RS','44387621','M', '9999-9999' ,'ATIVO','RS','2012-08-14');

INSERT INTO tb_desconto( desconto_id, status, tipodesconto, valordesconto, aluno_aluno_id) VALUES (nextval('seq_desconto'), 'ATIVO', 'Bolsa1', 50.00, 1);
INSERT INTO tb_desconto( desconto_id, status, tipodesconto, valordesconto, aluno_aluno_id) VALUES (nextval('seq_desconto'), 'ATIVO', 'Bolsa2', 52.00, 2);
INSERT INTO tb_desconto( desconto_id, status, tipodesconto, valordesconto, aluno_aluno_id) VALUES (nextval('seq_desconto'), 'ATIVO', 'Bolsa3', 53.00, 3);


INSERT INTO tb_disciplina( id, cargahoraria, nome, periodo, status)  VALUES (nextval('seq_disciplina'), 11, 'disciplina1', 1, 'ATIVO');
INSERT INTO tb_disciplina( id, cargahoraria, nome, periodo, status)  VALUES (nextval('seq_disciplina'), 22, 'disciplina2', 2, 'ATIVO');
INSERT INTO tb_disciplina( id, cargahoraria, nome, periodo, status)  VALUES (nextval('seq_disciplina'), 33, 'disciplina3', 1, 'ATIVO');


INSERT INTO tb_mensalidade( mensalidade_id, mesreferencia, status, valor, valorpago, aluno_aluno_id)  VALUES (nextval('seq_mensalidade'), '2012-10-01', 'ATIVO', 200.51, 200.51, 1);
INSERT INTO tb_mensalidade( mensalidade_id, mesreferencia, status, valor, valorpago, aluno_aluno_id)  VALUES (nextval('seq_mensalidade'), '2012-10-02', 'ATIVO', 200.52, 200.52, 2);
INSERT INTO tb_mensalidade( mensalidade_id, mesreferencia, status, valor, valorpago, aluno_aluno_id)  VALUES (nextval('seq_mensalidade'), '2012-10-03', 'ATIVO', 200.53, 200.53, 3);


INSERT INTO tb_turma( turma_id, ano, horariodeaulas, status, disciplina_id, professor_id) VALUES ( nextval('seq_turma'), '2012-10-01', 'SEGUNDA_PRIMEIRO_HORARIO', 'ATIVO', 1, 1);
INSERT INTO tb_turma( turma_id, ano, horariodeaulas, status, disciplina_id, professor_id) VALUES ( nextval('seq_turma'), '2012-10-02', 'SEGUNDA_SEGUNDO_HORARIO', 'ATIVO', 2, 2);
INSERT INTO tb_turma( turma_id, ano, horariodeaulas, status, disciplina_id, professor_id) VALUES ( nextval('seq_turma'), '2012-10-03', 'TERCA_PRIMEIRO_HORARIO', 'ATIVO', 3, 3);


INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'CURSANDO', 1, 1);
INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'CURSANDO', 2, 2);
INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'CURSANDO', 3, 3);


INSERT INTO tb_avaliacao_aluno( avaliacao_aluno_id, aluno_aluno_id, avaliacao_id, turma_turma_id)  VALUES (nextval('seq_avaliacao_aluno'), 1, 1, 1);
INSERT INTO tb_avaliacao_aluno( avaliacao_aluno_id, aluno_aluno_id, avaliacao_id, turma_turma_id)  VALUES (nextval('seq_avaliacao_aluno'), 2, 2, 2);
INSERT INTO tb_avaliacao_aluno( avaliacao_aluno_id, aluno_aluno_id, avaliacao_id, turma_turma_id)  VALUES (nextval('seq_avaliacao_aluno'), 3, 3, 3);


INSERT INTO tb_curso_tb_disciplina( tb_curso_curso_id, disciplina_id) VALUES (1, 1);
INSERT INTO tb_curso_tb_disciplina( tb_curso_curso_id, disciplina_id) VALUES (2, 2);
INSERT INTO tb_curso_tb_disciplina( tb_curso_curso_id, disciplina_id) VALUES (3, 3);


INSERT INTO tb_disponibilidade_professor( disponibilidade_professor_id, status, professor_professor_id) VALUES (nextval('seq_disponibilidade_professor'), 'ATIVO', 1);
INSERT INTO tb_disponibilidade_professor( disponibilidade_professor_id, status, professor_professor_id) VALUES (nextval('seq_disponibilidade_professor'), 'ATIVO', 2);
INSERT INTO tb_disponibilidade_professor( disponibilidade_professor_id, status, professor_professor_id) VALUES (nextval('seq_disponibilidade_professor'), 'ATIVO', 3);


INSERT INTO tb_disponibilidade_professor_tb_disciplina( tb_disponibilidade_professor_disponibilidade_professor_id, disciplinas_id) VALUES (1, 1);
INSERT INTO tb_disponibilidade_professor_tb_disciplina( tb_disponibilidade_professor_disponibilidade_professor_id, disciplinas_id) VALUES (2, 2);
INSERT INTO tb_disponibilidade_professor_tb_disciplina( tb_disponibilidade_professor_disponibilidade_professor_id, disciplinas_id) VALUES (3, 3);


INSERT INTO tb_horario_aulas( id, value) VALUES (1, 'SEGUNDA_PRIMEIRO_HORARIO');
INSERT INTO tb_horario_aulas( id, value) VALUES (2, 'SEGUNDA_SEGUNDO_HORARIO');
INSERT INTO tb_horario_aulas( id, value) VALUES (3, 'TERCA_PRIMEIRO_HORARIO');


INSERT INTO tb_disponibilidade_professor_tb_horario_aulas( tb_disponibilidade_professor_disponibilidade_professor_id, horariodisponivel_id) VALUES (1, 1);
INSERT INTO tb_disponibilidade_professor_tb_horario_aulas( tb_disponibilidade_professor_disponibilidade_professor_id, horariodisponivel_id) VALUES (2, 2);
INSERT INTO tb_disponibilidade_professor_tb_horario_aulas( tb_disponibilidade_professor_disponibilidade_professor_id, horariodisponivel_id) VALUES (3, 3);


INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'APROVADO', 1, 1);
INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'APROVADO', 2, 2);
INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'APROVADO', 3, 3);


INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (1, 1);
INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (2, 2);
INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (3, 3);


INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (1, 1);
INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (2, 3);
INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (3, 3);
