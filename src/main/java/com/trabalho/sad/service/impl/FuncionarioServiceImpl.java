package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.repository.FuncionarioRepository;
import com.trabalho.sad.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
		/* Acesso aos métodos de persistência JPA para funcionários
		 * */
	private FuncionarioRepository funcionarioRepository;
	
		/* Acesso aos métodos de persistência JPA auxiliares
		 * */
	//private CargoRepository cargoRepository;
	
	/* Construtor 
	 ***************************************************************************************************/
	public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepo) {
		this.funcionarioRepository = funcionarioRepo;
	}

	
	/* Métodos 
	 ***************************************************************************************************/
	@Override
	@Transactional
	public Funcionario cadastrar(Funcionario funcionarioParam) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(funcionarioParam.getId());
		return funcionarioRepository.save(funcionarioParam);
	}

	@Override
	@Transactional
	public Funcionario atualizar(Funcionario funcionarioParam) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(funcionarioParam.getId());
		return funcionarioRepository.save(funcionarioParam);
	}

		/* Funcionários não serão deletados. Ao invés disto, a situação do funcionário é 
		 * marcada como 'inativo' 
		 * */
	@Override
	@Transactional
	public Funcionario inativar(Funcionario funcionarioParam) {
			/* Para inativar, a situação do funcionário deve ser 'inativo'.
			 * Se não for, mudamos para 'inativo'.
			 * */
		//TODO
		return funcionarioRepository.save(funcionarioParam);
	}

	@Override
	@Transactional
	public List<Funcionario> buscar(Funcionario funcionarioParamFiltro) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(funcionarioParamFiltro.getId());
		Example<Funcionario> exampleFuncionario = Example.of(funcionarioParamFiltro);
		return funcionarioRepository.findAll(exampleFuncionario);
	}

}
