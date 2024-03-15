package com.trabalho.sad.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.sad.model.entities.Funcionario;
import com.trabalho.sad.model.repository.FuncionarioRepository;
import com.trabalho.sad.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;	

	@Override
	@Transactional
	public Funcionario cadastrar(Funcionario funcionario) {	
		Objects.requireNonNull(funcionario.getId());
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public Funcionario atualizar(Long id, Funcionario obj) {
		Funcionario entity = funcionarioRepository.getReferenceById(id);
		atualizarDados(entity, obj);
		Objects.requireNonNull(entity.getId());
		return funcionarioRepository.save(entity);
	}

	public Funcionario atualizarDados(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setSexo(obj.getSexo());
		entity.setCpf(obj.getCpf());
		entity.setCep(obj.getCep());
		entity.setEndereco(obj.getEndereco());
		entity.setTelefone(obj.getTelefone());
		entity.setFoto(obj.getFoto());
		entity.setEmail(obj.getEmail());
		entity.setDataCadastro(obj.getDataCadastro());
		entity.setLogin(obj.getLogin());
		entity.setSenhaHash(obj.getSenhaHash()); 
		return(entity);
	}

	@Override
	@Transactional
	public Funcionario inativar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public List<Funcionario> buscar() {			
		return funcionarioRepository.findAll();
	}
	
	@Override
	@Transactional
	public Funcionario consultarPorId(Long id) {
		Optional<Funcionario> obj = funcionarioRepository.findById(id);
		return obj.get();
	}
}
