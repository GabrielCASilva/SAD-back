package com.trabalho.sad.seeding;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.trabalho.sad.model.entities.Cargo;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.Setor;
import com.trabalho.sad.model.entities.enums.Status;
import com.trabalho.sad.model.repository.CargoRepository;
import com.trabalho.sad.model.repository.FuncionarioRepository;
import com.trabalho.sad.model.repository.SetorRepository;

@Configuration
@Profile("test")
public class Seeding implements CommandLineRunner{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	public void run(String... args) throws Exception {	
		
		Setor s01 = new Setor("01", "Presidência", "aaaaaa", 100L);
		Setor s02 = new Setor("01.10", "DG-Diretoria de Gestão", "aaaaaa", 100L);
		Setor s03 = new Setor("01.10.01", "COPLAN-Coordenação de Planejamento, Orçamento e Finanças", "aaaaaa", 110L);
		Setor s04 = new Setor("01.10.01.01", "SCF-Serviço de Contabilidade e Finanças", "aaaaaa", 111L);
		Setor s05 = new Setor("01.10.02", "CTIC-Coordenação de Tecnologia da Informação e Comunicação", "aaaaaa", 220L);
		Setor s06 = new Setor("01.10.03", "CRL-Coordenação de Recursos Logísticos", "aaaaaa", 130L);
		Setor s07 = new Setor("01.10.03.01", "SAG-Serviço de Atividades Gerais", "aaaaaa", 131L);
		Setor s08 = new Setor("01.10.03.02", "SSP-Serviço de Segurança Patrimonial", "aaaaaa", 132L);
		Setor s09 = new Setor("01.10.04", "CGP-Coordenação de Gestão de Pessoas", "aaaaaa", 140L);
		Setor s10 = new Setor("01.10.05", "CERMA-Coordenação de Engenharia, Restauração e Manutenção", "aaaaaa", 150L);		
		Setor s11 = new Setor("01.20", "DIPEQ-Diretoria de Pesquisa Cientifica", "aaaaaa", 200L);
		Setor s12 = new Setor("01.20.01", "CCB-Coordenação de Coleções Biológicas", "aaaaa", 210L );
		Setor s13 = new Setor("01.20.02", "CNCF-Centro Nacional de Conservação da Flora", "aaaaa", 220L );
		Setor s14 = new Setor("01.30", "DICAT-Diretoria de Conhecimento, Ambiente e Tecnologia", "aaaaaa", 300L);
		Setor s15 = new Setor("01.30.01", "CCAV-Coordenação da Conservação da Área Verde", "aaaaaa", 310L);
		Setor s16 = new Setor("01.30.01.01", "SAM-Serviço de Acervo e Memória", "aaaaaa", 311L);
		Setor s17 = new Setor("01.30.01.02", "SCV-Serviço do Centro de Visitantes", "aaaaaa", 312L);
		
		setorRepository.saveAll(Arrays.asList(s01, s02, s03, s04, s05, s06,s07, s08, s09, s10, s11, s12, s13, s14, s15, s16, s17));
		
		Cargo c1 = new Cargo("Presidente", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c2 = new Cargo("Diretor", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c3 = new Cargo("Supervisor", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c4 = new Cargo("Pesquisador", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c5 = new Cargo("Tecnologista", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c6 = new Cargo("Técnico", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c7 = new Cargo("Auxiliar Técnico", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c8 = new Cargo("Analista em Ciência e Tecnologia", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c9 = new Cargo("Assistência em Ciência e Tecnologia", "xxxxx", true, true, true, true, true, true, true, true);
		Cargo c10 = new Cargo("Auxiliar em Ciência e Tecnologia", "xxxxx", true, true, true, true, true, true, true, true);
		
		cargoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		
		
		Funcionario f1 = new Funcionario("Carlos Red", Instant.parse("2001-10-17T01:50:00Z"), 'M', 11586547891L, Status.PRESIDENTE, s01, c1);
		Funcionario f2 = new Funcionario("Pedro Blue", Instant.parse("2001-10-17T01:50:00Z"), 'M', 11586547891L, Status.DIRETOR, s05, c2);
		Funcionario f3 = new Funcionario("Maria Brow", Instant.parse("2004-06-24T19:45:00Z"), 'F', 25685232471L, Status.SUPERVISOR, s05, c3);	
		Funcionario f4 = new Funcionario("João Blanc", Instant.parse("2001-02-16T17:30:00Z"), 'M', 25485211614L, Status.SERVIDOR,s05, c8 );
		Funcionario f5 = new Funcionario("José Yellow", Instant.parse("2001-02-16T17:30:00Z"), 'M', 25485211614L, Status.SERVIDOR,s05, c9 );
		Funcionario f6 = new Funcionario("Gorete Green", Instant.parse("2002-04-18T16:30:00Z"), 'F', 36856474112L, Status.DIRETOR, s11, c2);
		
		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5, f6));	
	}
}
