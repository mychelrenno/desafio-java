package br.com.biblioteca.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.MembroRepository;

@Service
public class MembroService {
	
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Transactional
	public void salvar(Projeto projeto, Set<Long> membroIds) {
		membroRepository.deleteAllByProjetoId(projeto.getId());
		List<Pessoa> membros = pessoaService.buscarTodos(membroIds);
		membros.forEach( m -> {
			Membro membro = new Membro();
			membro.setMembro(m);
			membro.setProjeto(projeto);
			membroRepository.save(membro);
		});
	}
	
	public Set<Long> buscarPessoaIdSetPorProjetoId(Long projetoId) {
		List<Membro> membros = membroRepository.findByProjetoId(projetoId);
		Set<Long> membroSet = new HashSet<>();
		membros.forEach(m -> {
			membroSet.add(m.getMembro().getId());
		});
		return membroSet;
	}
	
}
