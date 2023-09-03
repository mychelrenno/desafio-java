package br.com.biblioteca.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.dto.PessoaDto;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/adicionar")
	public ResponseEntity<Object> name(@RequestBody final PessoaDto pessoaDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
		
		pessoaService.salvar(pessoa);
		
		return ResponseEntity.ok("Pessoa adicionada com sucesso.");
		
	}

}
