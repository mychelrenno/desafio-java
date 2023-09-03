package br.com.biblioteca.service;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.dto.ProjetoDto;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetoRepository;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private MembroService membroService;
	
	public void salvar(ProjetoDto projetoDto) {
		Projeto projeto = convertDtoToEntity(projetoDto);
		
		membroService.salvar(projeto, projetoDto.getMembros());
		
		projetoRepository.save(projeto);
	}
	
	public List<Projeto> buscarTodos() {
		return projetoRepository.findAll();
	}
	
	public Projeto buscarPorId(Long id) {
		return projetoRepository.getById(id);
	}
	
	public void excluir(Long projetoId) {
		projetoRepository.deleteById(projetoId);
	}
	
	public ProjetoDto convertEntityToDto(Projeto p) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Projeto, ProjetoDto>() {
			@Override
			protected void configure() {
				Long gerente = source.getGerente().getId();
				map().setGerente(gerente);
			}
		});
		ProjetoDto dto = modelMapper.map(p, ProjetoDto.class);
		
		Set<Long> membros = membroService.buscarPessoaIdSetPorProjetoId(p.getId());
		dto.setMembros(membros);
		
		return dto;
	}
	
	public Projeto convertDtoToEntity(ProjetoDto projetoDto) {
		ModelMapper modelMapper = new ModelMapper();
		
		Projeto projeto = modelMapper.map(projetoDto, Projeto.class);
		
		if (projetoDto.getGerente() != null) {
			Pessoa gerente = pessoaService.buscarPorId(projetoDto.getGerente());
			projeto.setGerente(gerente);
		}
		
		return projeto;
	}

}
