package com.trabalho.sad.seeding;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Meta;
import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.model.entities.Tarefa;
import com.trabalho.sad.model.entities.enums.SituacaoFuncionario;
import com.trabalho.sad.model.entities.enums.SituacaoMeta;
import com.trabalho.sad.model.entities.enums.SituacaoTarefa;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.model.repository.FuncionarioRepository;
import com.trabalho.sad.model.repository.MetaRepository;
import com.trabalho.sad.model.repository.SetorRepository;
import com.trabalho.sad.model.repository.TarefaRepository;
import com.trabalho.sad.service.SetorService;

@Configuration
@Profile("test")
public class Seeding implements Serializable, CommandLineRunner  {
	private static final long serialVersionUID = 1L; 
	
	@Autowired
	SetorService setorService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private SetorRepository setorRepository;

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private MetaRepository metaRepository;

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Setor s01 = new Setor("DG-Diretoria de Gestão", "Endereço zona oeste", 100L, null);
		Setor s02 = new Setor("COPLAN-Coordenação de Planejamento, Orçamento e Finanças", "Endereço zona oeste", 110L, null);
		Setor s03 = new Setor("CTIC-Coordenação de Tecnologia da Informação e Comunicação", "Endereço zona oeste", 120L, null);
		Setor s04 = new Setor("DIPEQ-Diretoria de Pesquisa Cientifica", "Endereço zona leste", 200L, null );
		Setor s05 = new Setor("CCB-Coordenação de Coleções Biológicas", "Endereço zona leste", 210L, null);
		
		Cargo c01 = new Cargo("Diretor",      "Tipo Avaliação1", true, false, true, false, false, false, false, false);
		Cargo c02 = new Cargo("Supervisor",   "Tipo Avaliação2", false, true, false, false, false, true, false, false);
		Cargo c03 = new Cargo("Servidor",     "Tipo Avaliação3", false, false, false, false, false, false, true, true);
		Cargo c04 = new Cargo("Administrador","Tipo Avaliação4", false, false, false, true, true, false, false, false);
		
		cargoRepository.saveAll(Arrays.asList(c01, c02, c03, c04));

		Funcionario f01 = new Funcionario("Benedito Fernando Drumond", LocalDate.of(2001, 10, 20), 'M', 20577083902L, 22220001L, "Rua do Catete", 			  9827615L, "linkFoto", "benedito@gmail.com", LocalDate.of(2022, 2, 10), "benedito", "12345", SituacaoFuncionario.ATIVO, s01, c01);
		Funcionario f02 = new Funcionario("Isis Sophie Campos",        LocalDate.of(2002, 6, 25),  'F', 97691005601L, 22041011L, "Rua Santa Clara", 		  9827620L, "linkFoto", "isis@gmail.com", 	  LocalDate.of(2022, 3, 20), "isis",     "12345", SituacaoFuncionario.ATIVO, s02, c02);
		Funcionario f03 = new Funcionario("Noah Anderson Porto",       LocalDate.of(2000, 8, 10),  'M', 88910882182L, 22270000L, "Rua Voluntários da Pátria", 9827630L, "linkFoto", "noah@gmail.com", 	  LocalDate.of(2022, 10, 20),"noah",     "12345", SituacaoFuncionario.ATIVO, s02, c03);
		Funcionario f04 = new Funcionario("Lorenzo Bento Galvão",      LocalDate.of(2001, 4, 12),  'M', 74493927801L, 22410003L, "Rua Visconde de Pirajá", 	  9827625L, "linkFoto", "lorenzo@gmail.com",  LocalDate.of(2022, 5, 19), "lorenzo",  "12345", SituacaoFuncionario.ATIVO, s02, c03);
		Funcionario f05 = new Funcionario("Manuel Calebe da Paz",      LocalDate.of(1998, 7, 15),  'M', 18926131238L, 22220040L, "Rua Dois de Dezembro", 	  9827635L, "linkFoto", "manuel@gmail.com",   LocalDate.of(2022, 2, 15), "manuel",   "12345", SituacaoFuncionario.ATIVO, s02, c03);
		Funcionario f06 = new Funcionario("Marli Kamilly Rezende",     LocalDate.of(2002, 3, 29),  'F', 39430490605L, 20270242L, "Rua Afonso Pena", 		  9827640L, "linkFoto", "marli@gmail.com",    LocalDate.of(2022, 2, 15), "marli",    "12345", SituacaoFuncionario.ATIVO, s03, c02);
		Funcionario f07 = new Funcionario("Mirella Benedita da Cruz",  LocalDate.of(2002, 11, 19), 'F', 92810589879L, 20530430L, "Rua Abreu Vieira", 		  9827650L, "linkFoto", "mirella@gmail.com",  LocalDate.of(2022, 1, 20), "mirella",  "12345", SituacaoFuncionario.ATIVO, s03, c03);
		Funcionario f08 = new Funcionario("Nathan João Monteiro",      LocalDate.of(2002, 1, 30),  'M', 23308040832L, 20910020L, "Rua Amarantes", 			  9827655L, "linkFoto", "nathan@gmail.com",   LocalDate.of(2022, 1, 20), "nathan",   "12345", SituacaoFuncionario.ATIVO, s03, c03);
		Funcionario f09 = new Funcionario("Bianca Rayssa Campos",      LocalDate.of(2000, 2, 28),  'F', 10746248237L, 20941150L, "Rua Almirante Baltazar", 	  9827660L, "linkFoto", "bianca@gmail.com",   LocalDate.of(2022, 1, 20), "bianca",   "12345", SituacaoFuncionario.ATIVO, s03, c03);		
		Funcionario f10 = new Funcionario("Ágatha Luana Almada",       LocalDate.of(2001, 2, 22),  'F', 37572844618L, 20920250L, "Rua Conde de Bom Fim", 	  9827665L, "linkFoto", "agatha@gmail.com",   LocalDate.of(2022, 1, 10), "agatha",   "12345", SituacaoFuncionario.ATIVO, s04, c01);
		Funcionario f11 = new Funcionario("Cecília Tereza Malu Moura", LocalDate.of(2000, 5, 15),  'F', 61103357549L, 20511190L, "Rua Basílio Antônio", 	  9827670L, "linkFoto", "cecilia@gmail.com",  LocalDate.of(2022, 1, 10), "cecilia",  "12345", SituacaoFuncionario.ATIVO, s05, c02);
		Funcionario f12 = new Funcionario("Lúcia Emanuelly Castro",    LocalDate.of(2000, 7, 27),  'F', 26106674264L, 20521290L, "Rua Ângelo Agostine", 	  9827675L, "linkFoto", "lucia@gmail.com",    LocalDate.of(2022, 3, 20), "lucia",    "12345", SituacaoFuncionario.ATIVO, s05, c03);
		Funcionario f13 = new Funcionario("Raimundo Kauê Bryan Dias",  LocalDate.of(2001, 12, 04), 'M', 36041401293L, 20260322L, "Rua Anézio de Castro", 	  9827680L, "linkFoto", "raimundo@gmail.com", LocalDate.of(2022, 2, 16), "raimundo", "12345", SituacaoFuncionario.ATIVO, s05, c03);	
		Funcionario f14 = new Funcionario("Kaique Felipe Freitas",     LocalDate.of(2001, 9, 29),  'M', 95631766264L, 20260321L, "Rua Américo Nogueira", 	  9827685L, "linkFoto", "kaique@gmail.com",   LocalDate.of(2022, 2, 16), "kaique",   "12345", SituacaoFuncionario.ATIVO, s05, c03);	
		Funcionario f15 = new Funcionario("Cláudio Pedro Almeida",     LocalDate.of(2001, 12, 10), 'M', 38036040441L, 20261106L, "Rua Barão de Itapagipe", 	  9827690L, "linkFoto", "claudio@gmail.com",  LocalDate.of(2022, 2, 16), "claudio",  "12345", SituacaoFuncionario.ATIVO, s05, c03);	
		
		s01.setSupervisor(f01);
		s02.setSupervisor(f02);
		s03.setSupervisor(f06);
		s04.setSupervisor(f10);
		s05.setSupervisor(f11);
		
		setorRepository.saveAll(Arrays.asList(s01, s02, s03, s04, s05));
		
		funcionarioRepository.saveAll(Arrays.asList(f01, f02, f03, f04, f05, f06, f07, f08, f09, f10, f11, f12, f13, f14, f15));
		
		Meta m1 = new Meta("Conservação de espécies ameaçadas de plantas", "O objetivo é identificar,catalogar espécies ameaçadas e estabelecer programas de reprodução e propagação de plantas", LocalDate.of(2023, 01, 05), LocalDate.of(2024, 01, 05), LocalDate.of(2024, 01, 05) , SituacaoMeta.CONCLUÍDO,f10, s05);
		Meta m2 = new Meta("Educação ambiental e sensibilização do público sobre a biodiversidade", "O objetivo é desenvolver progrmas, realizar palestras e criar materiais educativos", LocalDate.of(2024, 01, 05), LocalDate.of(2024, 12, 15), null, SituacaoMeta.EM_ANDAMENTO, f01, s03);
		Meta m3 = new Meta("Promoção da pesquisa científica em botânica e ecologia", "O objetivo obter coloboração de instituições acadêmicas, promover um banco de dados botânico e oferecer oportunidades de pesquisas a estudantes e cientistas", LocalDate.of(2023, 01, 10), LocalDate.of(2024, 01, 10), LocalDate.of(2024, 01, 10), SituacaoMeta.CONCLUÍDO, f10, s05);
		Meta m4 = new Meta("Criação de espaços de recreação e relaxamento para os visitantes", "O objetivo é criar jardins temáticos, áreas de descanso e contemplação e organizar eventos culturais e artísticos", LocalDate.of(2024, 1, 5), LocalDate.of(2024, 12, 30), null, SituacaoMeta.EM_ANDAMENTO, f01, s02);
		Meta m5 = new Meta("Apoio à polinização e à vida selvagem", "O objetivo é criar habitats específicos para polinizadores e implementação de práticas de jardinagem que promovam a diversidade da vida", LocalDate.of(2023, 01, 10), LocalDate.of(2023, 12, 30), LocalDate.of(2023, 12, 30), SituacaoMeta.CONCLUÍDO, f10, s05);
		
		metaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
		Tarefa t11 = new Tarefa("Identificação e catalogação de espécies em risco", "O objetivo é identificar,catalogar espécies ameaçadas", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 7, 30), LocalDate.of(2023, 1, 15), LocalDate.of(2023, 12, 30), 100.0, SituacaoTarefa.CONCLUÍDO, f11, f12, m1);
		Tarefa t12 = new Tarefa("Estabelecimento de programas de reprodução e propagação de plantas ameaçadas", "O objetivo é estabelecer programas de reprodução e propagação de plantas", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 11, 30), LocalDate.of(2023, 1, 15), LocalDate.of(2023, 11, 30), 100.0, SituacaoTarefa.CONCLUÍDO, f11, f13, m1);
		Tarefa t13 = new Tarefa("Participação em esforços de conservação ex-situ e in-situ", "O objetivo é focar no esforço de conservação ex-situ e in-situ", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 12, 20), LocalDate.of(2023, 1, 20), LocalDate.of(2024, 1, 4), 100.0, SituacaoTarefa.CONCLUÍDO, f11, f14, m1);

		Tarefa t21 = new Tarefa("Desenvolvimento de programas educacionais para escolas, grupos comunitários e visitantes", "O objetivo é desenvolver programas educacionais e grupos temáticos", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 12, 15), LocalDate.of(2024, 1, 20), null, 20.0, SituacaoTarefa.EM_ANDAMENTO,f06, f07, m2);
		Tarefa t22 = new Tarefa("Realização de palestras, workshops e atividades práticas sobre temas relacionados à botânica e conservação", "O objetivo é promover workshops e atividades práticas sobre botânica e conservação", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 12, 15), LocalDate.of(2023, 1, 20), null, 10.0, SituacaoTarefa.EM_ANDAMENTO,f06, f08, m2);		
		Tarefa t23 = new Tarefa("Criação de materiais educativos, como folhetos, guias de identificação e exposições interativas", "O objetivo é promover estudos sobre a flora local e global através das instituições acadêmicas e de pesquisa", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 12, 15), LocalDate.of(2024, 1, 20), null, 15.0, SituacaoTarefa.EM_ANDAMENTO,f06, f09, m2);		

		Tarefa t31 = new Tarefa("Colaboração com instituições acadêmicas e de pesquisa para conduzir estudos sobre a flora local e global", "O objetivo é criar material educativo e exposição interativa", LocalDate.of(2023, 1, 15), LocalDate.of(2024, 1, 10), LocalDate.of(2023, 1, 17), LocalDate.of(2024, 1, 10), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f12, m3);		
		Tarefa t32 = new Tarefa("Manutenção de bancos de dados botânicos e herbários", "O objetivo é manter banco de dados botânico", LocalDate.of(2023, 1, 15), LocalDate.of(2024, 1, 10), LocalDate.of(2023, 1, 17), LocalDate.of(2023, 12, 30), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f13, m3);		
		Tarefa t33 = new Tarefa("Oferta de oportunidades de pesquisa para estudantes e cientistas em residência", "O objetivo é oferecer oportunidades de pesquisas para estudantes e cientistas", LocalDate.of(2023, 1, 15), LocalDate.of(2024, 1, 10), LocalDate.of(2023, 1, 17), LocalDate.of(2023, 12, 30), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f15, m3);		

		Tarefa t41 = new Tarefa("Design e manutenção de trilhas botânicas e jardins temáticos", "O objetivo é criar novos design trilhas e jardins temáticos", LocalDate.of(2024, 1, 5), LocalDate.of(2024, 12, 30), LocalDate.of(2024, 1, 7), null, 15.0, SituacaoTarefa.EM_ANDAMENTO,f02, f03, m4);
		Tarefa t42 = new Tarefa("Instalação de áreas de descanso e contemplação, como bancos e mirantes", "O objetivo é criar novas áreas de descanso e contemplação", LocalDate.of(2024, 1, 5), LocalDate.of(2024, 12, 30), LocalDate.of(2024, 1, 7), null, 10.0, SituacaoTarefa.EM_ANDAMENTO,f02, f04, m4);
		Tarefa t43 = new Tarefa("Organização de eventos culturais e artísticos, como concertos ao ar livre e exposições de esculturas botânicas", "O objetivo é organizar eventos culturais e artísticos", LocalDate.of(2024, 1, 5), LocalDate.of(2024, 12, 30), LocalDate.of(2024, 1, 7), null, 10.0, SituacaoTarefa.EM_ANDAMENTO,f02, f05, m4);

		Tarefa t51 = new Tarefa("Criação de habitats específicos para polinizadores, como jardins de borboletas e abelhas", "O objetivo é a criação de habitats específicos para plonizadores ", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 11, 30), LocalDate.of(2023, 1, 10), LocalDate.of(2024, 12, 30), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f13, m5);
		Tarefa t52 = new Tarefa("Instalação de caixas-ninho e abrigos para aves e pequenos mamíferos", "O objetivo é a criação de abrigos para aves e pequenos mamíferos", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 11, 30), LocalDate.of(2023, 1, 10), LocalDate.of(2024, 11, 30), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f14, m5);
		Tarefa t53 = new Tarefa("Implementação de práticas de jardinagem que promovam a diversidade de vida selvagem", "O objetivo promover o plantio de flores nativas e a manutenção de áreas de refúgio", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 12, 30), LocalDate.of(2023, 1, 10), LocalDate.of(2024, 12, 30), 100.0, SituacaoTarefa.CONCLUÍDO,f11, f15, m5);
		
		tarefaRepository.saveAll(Arrays.asList(t11, t12, t13, t21, t22, t23, t31, t32, t33, t41, t42, t43, t51, t52, t53));	
	}
}
