package br.com.biblioteca.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> buscarTodosGerentes() {
		return pessoaRepository.findByIsFuncionario(false);
	}
	
	public List<Pessoa> buscarTodosMembros() {
		return pessoaRepository.findByIsFuncionario(true);
	}
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).get();
	}
	
	public List<Pessoa> buscarTodos(Set<Long> ids) {
//		Set<Long> set = new HashSet<>(Arrays.asList(ids));
		return pessoaRepository.findAllById(ids);
	}

}
