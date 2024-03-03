package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.api.dto.FuncionarioDTO;
import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.entities.status.SituacaoFuncionario;
import com.trabalho.sad.model.repository.FuncionarioRepository;
import com.trabalho.sad.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
		/* Acesso aos métodos de persistência JPA para funcionários
		 * */
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
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
		 * marcada como 'Inativo' 
		 * */
	@Override
	@Transactional
	public Funcionario inativar(Funcionario funcionarioParam) {
			/* Para inativar, a situação do funcionário deve ser 'inativo'.
			 * */
		funcionarioParam.setSituacao(SituacaoFuncionario.INATIVO.toString());
		return funcionarioRepository.save(funcionarioParam);
	}

	@Override
	@Transactional
	public List<FuncionarioDTO> buscar() {	
			/* Verifica que o parâmetro recebido não é nulo
			* */
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		List<FuncionarioDTO> funcionariosDTO = funcionarios.stream()
				.map(FuncionarioDTO::new)
				.collect(Collectors.toList());
		return funcionariosDTO;
	}


	@Override
	@Transactional
	public Optional<Funcionario> consultarPorId(Long id) {
		return funcionarioRepository.findById(id);
	}

}
