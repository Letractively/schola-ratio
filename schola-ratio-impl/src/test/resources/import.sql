insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Cajuru', 89012099, 'CTBA', '', 'PR', 500,'Das rosas amarelas', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('Ap', 98776547, 'SJP', '', 'PR', 1500,'Travessa rosa', nextval('seq_endereco'));
insert into tb_endereco (bairro, cep, cidade, complemento, estado, numero, rua, id_endereco) values ('AV', 98769809, 'CTBA', '', 'PR', 500,'Praça rosa', nextval('seq_endereco'));

INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 123456789, 'aaa@aaa.com', 12345, 'ScholaRatio1', 12345234, 1);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 234567890, 'bbb@bbb.com', 23456, 'ScholaRatio2', 23452345, 2);
INSERT INTO tb_instituicao(id_instituicao, cnpj, email_instituicao, inscricao_estadual, nome_instituicao, telefone_instituicao, endereco_instituicao) VALUES (nextval('seq_instituicao'), 345678901, 'ccc@ccc.com', 12345, 'ScholaRatio3', 34563456, 3);

insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'33333333333','2003-08-15','wwwrrr@email.com','1','Brasileiro','São Vicente','Astolpho P Cruz','','','SSP-SP','2222222222','123qwe','M','ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'55555555555','1994-06-10','xxxxxx@email.com','2','Canadense','Curitiba','Josepha P Silva','','','SSP-SP','11111111','123qwe','F','ATIVO','SP','2012-08-18');
insert into tb_aluno (aluno_id, cpf, dataExpedicao, email, endereco_usuario, nacionalidade, naturalidade, nome, nomeMae, nomePai, orgaoExpeditor, rg, senha, sexo, status, ufOrgaoExpeditor, dataDeMatricula) values (nextval('seq_aluno'),'88888888888','1999-04-01','oooooo@email.com','3','Brasileiro','São José dos Pinhais','Jeronimo Pires','','','SSP-RS','54387621','123qwe','M','ATIVO','RS','2012-08-18');

INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao1', 'tipopermissao1');
INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao2', 'tipopermissao2');
INSERT INTO tb_permissao( permissao_id, descricaopermissao, tipopermissao) VALUES (nextval('seq_permissao'), 'descricaopermissao3', 'tipopermissao3');

INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'PRIMEIRO', 15, 9.5);
INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'SEGUNDO', 20, 2);
INSERT INTO tb_avaliacao(id, bimestre, frequencia, nota) VALUES (nextval('seq_avaliacao'), 'FINAL', 10, 7.5);

INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso1', 'ATIVO', 1);
INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso2', 'ATIVO', 2);
INSERT INTO tb_curso( curso_id, duracao, nome, status, instituicao_id) VALUES (nextval('seq_curso'), 8, 'Curso3', 'ATIVO', 3);

INSERT INTO tb_usuario(usuario_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 12312312312, '2001-10-15', 'xpto@hgf3d3', 'Japones', 'Tokio', 'Takyo H San', '', '', 'XXYYZZ', 43221534, '*******','M', 'INATIVO', 'RJ', 3);
INSERT INTO tb_usuario(usuario_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 45645645645, '1999-12-05', 'dasg@3gvcfdx', 'Chines', 'Guangdzu', 'Hong Chin Kong', '', '', 'XXYYZZ', 654234677, '*******','M', 'ATIVO', 'AP', 2);
INSERT INTO tb_usuario(usuario_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha,sexo, status, uforgaoexpeditor, endereco_usuario) VALUES (nextval('seq_usuario'), 78978978990, '2001-01-12', 'hgftu@rtfdx', 'Brasileiro', 'Pará', 'Anonieta dos Santos', '', '', 'DDEESS', 6432098778, '*******','F', 'ATIVO', 'SP', 1);

INSERT INTO tb_professor( professor_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha, sexo, status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 111111, '2010-04-01', '111@111.com', 'nacionalidade1', 'naturalidade1', 'nome1', 'nomema1', 'nomepai1', 'orgaoexpeditor', 111, 111, 'M', 'ATIVO', 'PR', 'descricaotitulo1', 'MESTRADO', 1);
INSERT INTO tb_professor( professor_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha, sexo, status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 222222, '2010-04-02', '222@222.com', 'nacionalidade2', 'naturalidade2', 'nome2', 'nomema2', 'nomepai2', 'orgaoexpeditor', 222, 222, 'M', 'ATIVO', 'PR', 'descricaotitulo2', 'MESTRADO', 2);
INSERT INTO tb_professor( professor_id, cpf, dataexpedicao, email, nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor, rg, senha, sexo, status, uforgaoexpeditor, descricaotitulo, titulo, endereco_usuario) VALUES       (nextval('seq_professor') , 333333, '2010-04-03', '333@333.com', 'nacionalidade3', 'naturalidade3', 'nome3', 'nomema3', 'nomepai3', 'orgaoexpeditor', 333, 333, 'M', 'ATIVO', 'PR', 'descricaotitulo3', 'MESTRADO', 3);

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

INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'ATIVO', 1, 1);
INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'ATIVO', 2, 2);
INSERT INTO tb_aluno_curso( aluno_curso, situacaoalunocurso, aluno_aluno_id, curso_curso_id)  VALUES (nextval('seq_aluno_curso'), 'ATIVO', 3, 3);

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

INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'ATIVO', 1, 1);
INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'ATIVO', 2, 2);
INSERT INTO tb_situacao_aluno_turma( situacao_aluno_turma_id, situacao, aluno_aluno_id, turma_turma_id) VALUES (nextval('seq_situacao_aluno_turma'), 'ATIVO', 3, 3);

INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (1, 1);
INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (2, 2);
INSERT INTO tb_turma_tb_aluno( tb_turma_turma_id, alunos_aluno_id) VALUES (3, 3);

INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (1, 1);
INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (2, 3);
INSERT INTO tb_disciplina_tb_disciplina( tb_disciplina_id, requisitos_id)  VALUES (3, 3);
