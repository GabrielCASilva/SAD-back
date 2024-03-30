package com.trabalho.sad.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

import com.trabalho.sad.model.entities.enums.SituacaoServico;

public class ProgressoMeta implements Avaliacao{
	
	private double indiceProdutividade;
	private double indiceAgilidade;
	private double indiceEficacia;
	private double tarefasConcluidas;
	
	private Meta metaAlvo = null;
	private List<Tarefa> tarefasAvaliacao = null; 
	
	
	public ProgressoMeta(Meta meta, List<Tarefa> tarefasEscopo) {
		this.indiceProdutividade = 0;
		this.indiceAgilidade = 0;
		this.indiceEficacia = 0;
		
		this.metaAlvo = meta;
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
	public void gerarRelatorio(Meta meta, LocalDate dataInicio, LocalDate dataFim) {
		HashMap<String, String> variables = new HashMap<>();

		LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		variables.put("dataAtual", dataAtual.format(formatter));
		variables.put("dataInicioPeriodo", dataInicio.format(formatter));
		variables.put("dataFinalPeriodo", dataFim.format(formatter));

		// Meta
		variables.put("nomeMeta", meta.getNome());
		variables.put("identificacaoMeta", meta.getId().toString());
		variables.put("descricaoMeta", meta.getDescricao());
		variables.put("dataCadastroMeta", meta.getDataCriacao().format(formatter));
		variables.put("dataPrevisaoMeta", meta.getDataPrevistaConclusao().format(formatter));
		variables.put("dataConclusaoMeta", meta.getDataConclusao().format(formatter));
		variables.put("situacaoMeta", meta.getSituacao().toString());

		// Setor
		variables.put("nomeSetor", meta.getSetor().getNome());
		variables.put("identificacaoSetor", meta.getSetor().getId().toString());
		variables.put("localizacaoSetor", meta.getSetor().getLocalizacao());
		variables.put("ramalSetor", meta.getSetor().getRamal().toString());
		variables.put("responsavelSetor", meta.getSetor().getSupervisor().getNome());
		variables.put("identificacaoResponsavel", meta.getSetor().getId().toString());

		// Funcionario
        variables.put("nomeFuncionario", meta.getDiretor().getNome());
        variables.put("identificacaoFuncionario", meta.getDiretor().getId().toString());
		variables.put("dataNascimento", meta.getDiretor().getDataNascimento().format(formatter));
		variables.put("sexoFuncionario", String.valueOf(meta.getDiretor().getSexo()));
		variables.put("cpfFuncionario", String.valueOf(meta.getDiretor().getCpf()));
		variables.put("enderecoFuncionario", meta.getDiretor().getEndereco());
		variables.put("cepFuncionario", meta.getDiretor().getCep().toString());
		variables.put("telefoneFuncionario", meta.getDiretor().getTelefone().toString());
		variables.put("emailFuncionario", meta.getDiretor().getEmail());
		variables.put("dataCadastroFuncionario", meta.getDiretor().getDataCadastro().format(formatter));
		variables.put("situacaoFuncionario", meta.getDiretor().getSituacao().toString());
		variables.put("cargoFuncionario", meta.getDiretor().getCargo().getNome());
		variables.put("avaliacaoFuncionario", meta.getDiretor().getCargo().getTipoAvaliacao().toString());

		// Metricas
		variables.put("agilidade", String.valueOf(this.getIndiceAgilidade()));
		variables.put("produtividade", String.valueOf(this.getIndiceProdutividade()));
		variables.put("eficacia", String.valueOf(this.getIndiceEficacia()));

		// Complemento
		variables.put("totalAvaliadas", String.valueOf(this.tarefasAvaliacao.size()));
		variables.put("totalConcluidas", String.valueOf(this.tarefasConcluidas));

		Relatorio relatorio = new Relatorio();

		try{
			relatorio.gerarRelatorioCompleto("relatorio_meta.docx", variables);
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

	
	public double getIndiceProdutividade() {
		return indiceProdutividade;
	}

	public double getIndiceAgilidade() {
		return indiceAgilidade;
	}

	public double getIndiceEficacia() {
		return indiceEficacia;
	}

	@Override
	public void gerarRelatorio(Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'gerarRelatorio'");
	}
	
}