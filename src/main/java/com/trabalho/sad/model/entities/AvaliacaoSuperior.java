package com.trabalho.sad.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

import com.trabalho.sad.model.entities.enums.SituacaoServico;

public class AvaliacaoSuperior implements Avaliacao {
	
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	private double indiceComprometimento;
	private double tarefasConcluidas;
	
	private Funcionario funcionarioAlvo = null;
	private List<Tarefa> tarefasAvaliacao = null; 
	
	
	public AvaliacaoSuperior(Funcionario funcionario, List<Tarefa> tarefasEscopo) {
		this.indiceProdutividade = 0;
		this.indiceAgilidade = 0;
		this.indiceEficacia = 0;
		this.indiceComprometimento = 0;
		
		this.funcionarioAlvo = funcionario;
		this.tarefasAvaliacao = tarefasEscopo;
	}

	
	@Override
	public boolean calcularAvaliacao() {
		if(!this.obterTarefas()) {
			return false;
		}
		this.indiceProdutividade = calcularProdutividade();
		this.indiceAgilidade = calcularAgilidade();
		this.indiceEficacia = calcularEficacia();
		this.indiceComprometimento = calcularComprometimento();
		
		return true;
	}

	@Override
	public boolean obterTarefas() {
		
		if(this.tarefasAvaliacao == null) {
			return false;
		}
		
		if(this.tarefasAvaliacao.size() == 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public void gerarRelatorio(Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim) {
		HashMap<String, String> variables = new HashMap<>();

		LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		variables.put("dataAtual", dataAtual.format(formatter));
		variables.put("dataInicioPeriodo", dataInicio.format(formatter));
		variables.put("dataFinalPeriodo", dataFim.format(formatter));

		// Funcionario
        variables.put("nomeFuncionario", funcionario.getNome());
        variables.put("identificacaoFuncionario", funcionario.getId().toString());
		variables.put("dataNascimento", funcionario.getDataNascimento().format(formatter));
		variables.put("sexoFuncionario", String.valueOf(funcionario.getSexo()));
		variables.put("cpfFuncionario", String.valueOf(funcionario.getCpf()));
		variables.put("enderecoFuncionario", funcionario.getEndereco());
		variables.put("cepFuncionario", funcionario.getCep().toString());
		variables.put("telefoneFuncionario", funcionario.getTelefone().toString());
		variables.put("emailFuncionario", funcionario.getEmail());
		variables.put("dataCadastroFuncionario", funcionario.getDataCadastro().format(formatter));
		variables.put("situacaoFuncionario", funcionario.getSituacao().toString());
		variables.put("cargoFuncionario", funcionario.getCargo().getNome());
		variables.put("avaliacaoFuncionario", funcionario.getCargo().getTipoAvaliacao().toString());

		// Setor
		variables.put("nomeSetor", funcionario.getSetor().getNome());
		variables.put("identificacaoSetor", funcionario.getSetor().getId().toString());
		variables.put("localizacaoSetor", funcionario.getSetor().getLocalizacao());
		variables.put("ramalSetor", funcionario.getSetor().getRamal().toString());
		variables.put("responsavelSetor", funcionario.getSetor().getSupervisor().getNome());
		variables.put("identificacaoResponsavel", funcionario.getSetor().getId().toString());

		// Metricas
		variables.put("agilidade", String.valueOf(this.getIndiceAgilidade()));
		variables.put("produtividade", String.valueOf(this.getIndiceProdutividade()));
		variables.put("eficacia", String.valueOf(this.getIndiceEficacia()));
		variables.put("comprometimento", String.valueOf(this.getIndiceComprometimento()));

		// Complemento
		variables.put("totalAvaliadas", String.valueOf(this.tarefasAvaliacao.size()));
		variables.put("totalConcluidas", String.valueOf(this.tarefasConcluidas));

		Relatorio relatorio = new Relatorio();

		try{
			relatorio.gerarRelatorioCompleto("relatorio_funcionario.docx", variables);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private double calcularProdutividade() {
		double resultado = 0;
		double tarefasConcluidas = 0;
		
		/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Obtendo quantidade de tarefas concluídas */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
				tarefasConcluidas++;
			}
		}
		/* Produtividade = Quantidade de tarefas concluídas, pelo total de tarefas */
		this.tarefasConcluidas = tarefasConcluidas;
		resultado = tarefasConcluidas / this.tarefasAvaliacao.size();
		return resultado;
	}
	
	private double calcularAgilidade() {
		double resultado = 0;
		long diasAgilidade = 0;
		
		/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Verifica se tarefa foi concluída */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
					/* Acumula diferença entre data de conclusão e data de criação, para cada tarefa */
				diasAgilidade = diasAgilidade + ChronoUnit.DAYS.between(tarefa.getDataCriacao(), tarefa.getDataConclusao());
			}
		}
		
			/* Agilidade = Resultado de diasAgilidade, por total de tarefas */
		resultado = diasAgilidade / this.tarefasAvaliacao.size();
		return resultado;
	}
	
	private double calcularEficacia() {
		double resultado = 0;
		long diasEficacia = 0;
		
			/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
				/* Verifica se tarefa foi concluída */
			if(tarefa.getSituacao() == SituacaoServico.CONCLUÍDO) {
					/* Acumula diferença entre data de conclusão prevista e data de conclusão efetiva, 
					 * para cada tarefa */
				diasEficacia = diasEficacia + ChronoUnit.DAYS.between(tarefa.getDataConclusao(), tarefa.getDataPrevistaConclusao());
			}
		}
		
			/* Eficácia = Resultado de diasEficacia, por total de tarefas */
		resultado = diasEficacia / this.tarefasAvaliacao.size();
		return resultado;
	}
	
	private double calcularComprometimento() {
		double resultado = 0;
		double tarefasEmComprometimento = 0;
		
		/* Percorrer lista de tarefas */
		for(Tarefa tarefa : this.tarefasAvaliacao) {
			if(tarefa.getSituacao() != SituacaoServico.ATIVO){
					/* Obtendo quantidade de tarefas em taxa de progresso maior ou igual a 50% */
				if(tarefa.getTaxaProgresso() >= 0.50) {
					tarefasEmComprometimento++;
				}
			}
		}
		/* Produtividade = Quantidade de tarefas em taxa de progresso maior ou igual a 50%, 
		 * pelo total de tarefas */
		resultado = tarefasEmComprometimento / this.tarefasAvaliacao.size();
		return resultado;
	}


	public double getIndiceProdutividade() {
		return indiceProdutividade;
	}

	public double getIndiceAgilidade() {
		return indiceAgilidade;
	}

	public double getIndiceEficacia() {
		return indiceEficacia;
	}

	public double getIndiceComprometimento() {
		return indiceComprometimento;
	}


	@Override
	public void gerarRelatorio(Meta meta, LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorio'");
	}

}