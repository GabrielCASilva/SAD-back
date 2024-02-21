package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Funcionario;
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
	public Funcionario cadastrar(Funcionario funcionario) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(funcionario.getId());
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public Funcionario atualizar(Funcionario funcionario) {	
			/* Verifica que o parâmetro recebido não é nulo
			 * */
		Objects.requireNonNull(funcionario.getId());
		return funcionarioRepository.save(funcionario);
	}

		/* Funcionários não serão deletados. Ao invés disto, a situação do funcionário é 
		 * marcada como 'inativo' 
		 * */
	@Override
	@Transactional
	public Funcionario inativar(Funcionario funcionario) {
			/* Para inativar, a situação do funcionário deve ser 'inativo'.
			 * Se não for, mudamos para 'inativo'.
			 * */
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public List<Funcionario> buscar() {	
		
		return funcionarioRepository.findAll();
	}
}
