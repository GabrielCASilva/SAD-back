-- INSERT CARGOS
INSERT INTO cargo (nome, tipo_avaliacao, permitido_manter_meta, permitido_avaliacao_servidor, permitido_avaliacao_supervisor, permitido_manter_funcionario, permitido_manter_setor, permitido_manter_tarefa, permitido_atribuir_tarefa, permitido_progredir_tarefa) VALUES ('Servidor', 'executor', false, false, false, false, false, false, true, true);
INSERT INTO cargo (nome, tipo_avaliacao, permitido_manter_meta, permitido_avaliacao_servidor, permitido_avaliacao_supervisor, permitido_manter_funcionario, permitido_manter_setor, permitido_manter_tarefa, permitido_atribuir_tarefa, permitido_progredir_tarefa) VALUES ('Supervisor', 'superior', false, true, false, false, false, true, false, false);
INSERT INTO cargo (nome, tipo_avaliacao, permitido_manter_meta, permitido_avaliacao_servidor, permitido_avaliacao_supervisor, permitido_manter_funcionario, permitido_manter_setor, permitido_manter_tarefa, permitido_atribuir_tarefa, permitido_progredir_tarefa) VALUES ('Diretor', 'nenhum', true, false, true, false, false, false, false, false);
INSERT INTO cargo (nome, tipo_avaliacao, permitido_manter_meta, permitido_avaliacao_servidor, permitido_avaliacao_supervisor, permitido_manter_funcionario, permitido_manter_setor, permitido_manter_tarefa, permitido_atribuir_tarefa, permitido_progredir_tarefa) VALUES ('Administrador', 'nenhum', false, false, false, true, true, false, false, false);


-- INSERT FUNCIONARIOS
-- INSERT INTO funcionario (nome, data_nascimento, sexo, cpf, cep, endereco, telefone, foto, email, data_cadastro, login, senha_hash, situacao, cargo_id, setor_participa_id) VALUES ();
INSERT INTO funcionario (nome, data_nascimento, sexo, cpf, cep, endereco, telefone, foto, email, data_cadastro, login, senha_hash, situacao) VALUES ('João Silva', '1990-05-15', 'M', 12345678900, 12345678, 'Rua das Flores, 123', 1234567890, 'foto_joao.jpg', 'joao.silva@example.com', '2024-03-03', 'joaosilva', 'hash_da_senha', 'Ativo');
INSERT INTO funcionario (nome, data_nascimento, sexo, cpf, cep, endereco, telefone, foto, email, data_cadastro, login, senha_hash, situacao) VALUES ('MARCOS', '1990-05-15', 'M', 12345678900, 12345678, 'Rua das Flores, 123', 1234567890, 'foto_joao.jpg', 'joao.silva@example.com', '2024-03-03', 'joaosilva', 'hash_da_senha', 'Ativo');

-- INSERT METAS
-- INSERT INTO meta (nome, descricao, data_criacao, data_prevista_conclusao, data_conclusao, situacao) VALUES ();
INSERT INTO meta (nome, descricao, data_criacao, data_prevista_conclusao, data_conclusao, situacao) VALUES ('Meta de Vendas', 'Atingir um aumento de 10% nas vendas no próximo trimestre', '2024-03-03', '2024-06-30', NULL, 'Pendente');

-- INSERT TAREFAS
-- INSERT INTO tarefa (nome, descricao, data_criacao, data_prevista_conclusao, data_inicio, data_conclusao, taxa_progresso, situacao, meta_id, funcionario_alocado_id, funcionario_responsavel_id) VALUES ();
INSERT INTO tarefa (nome, descricao, data_criacao, data_prevista_conclusao, data_inicio, data_conclusao, taxa_progresso, situacao) VALUES ('Implementar novo recurso', 'Desenvolver e implementar um novo recurso para o sistema', '2024-03-03', '2024-06-30', NULL, NULL, 0, 'Pendente');

-- INSERT SETORES
-- INSERT INTO setor (nome, localizacao, ramal, supervisor_id) VALUES ();
INSERT INTO setor (nome, localizacao, ramal) VALUES ('Departamento de Vendas', 'Edifício Principal, 3º andar', 1234);

UPDATE funcionario SET cargo_id = 1, setor_participa_id = 1 WHERE id = 1;
UPDATE funcionario SET cargo_id = 2, setor_participa_id = 1 WHERE id = 2;

UPDATE setor SET supervisor_id = 1 WHERE id = 1;

UPDATE meta SET setor_id = 1, responsavel_id = 1 WHERE id = 1;

UPDATE tarefa SET meta_id = 1, funcionario_alocado_id = 1, funcionario_responsavel_id = 1 WHERE id = 1;