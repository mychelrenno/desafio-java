package br.com.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.biblioteca.dto.ProjetoDto;
import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.PessoaService;
import br.com.biblioteca.service.ProjetoService;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	ProjetoService projetoService;

	@GetMapping
	public String home(Model model, HttpServletRequest httpServletRequest) {
		
		model.addAttribute("projeto", new ProjetoDto());
		model.addAttribute("gerenteList", pessoaService.buscarTodosGerentes());
		model.addAttribute("membroList", pessoaService.buscarTodosMembros());
		
		return "projeto";
	}
	
	@PostMapping("/salvar")
	public String salvar(Model model, HttpServletRequest httpServletRequest, @ModelAttribute("projeto") ProjetoDto projetoDto) {
		
		projetoService.salvar(projetoDto);
		
		model.addAttribute("projetoList", projetoService.buscarTodos());
		
		return "index";
	}
	
	@GetMapping("/editar")
	public String editarProjeto(Model model, HttpServletRequest httpServletRequest, @ModelAttribute("projeto") ProjetoDto projetoDto) {
		
		Projeto projeto = projetoService.buscarPorId(projetoDto.getId());
		
		model.addAttribute("projeto", projetoService.convertEntityToDto(projeto));
		model.addAttribute("gerenteList", pessoaService.buscarTodosGerentes());
		model.addAttribute("membroList", pessoaService.buscarTodosMembros());
		
		return "projeto";
	}
	
	@DeleteMapping("/excluir")
	public ResponseEntity<?> excluirProjeto(Model model, HttpServletRequest httpServletRequest, @RequestParam("id") Long id) {
		
		projetoService.excluir(id);
		
		model.addAttribute("projetoList", projetoService.buscarTodos());
		
//		return "index";
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
