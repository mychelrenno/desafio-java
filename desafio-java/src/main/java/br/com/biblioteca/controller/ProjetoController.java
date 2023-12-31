package br.com.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.biblioteca.dto.ProjetoDto;
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
	public String novo(Model model, HttpServletRequest httpServletRequest) {
		
		model.addAttribute("projeto", new ProjetoDto());
		model.addAttribute("gerenteList", pessoaService.buscarTodosGerentes());
		model.addAttribute("membroList", pessoaService.buscarTodosMembros());
		
		return "projeto";
	}
	
	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("projeto") @Valid ProjetoDto projetoDto, BindingResult bindingResult, Model model) {
		
        if(bindingResult.hasErrors()) {
            return "projeto";
        }
		
		projetoService.salvar(projetoDto);
		
		model.addAttribute("projetoList", projetoService.buscarTodosOrderById());
		
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
		Projeto projeto = projetoService.buscarPorId(id);
		String message = projetoService.validaExclusao(projeto);
		HttpStatus hs = HttpStatus.UNAUTHORIZED;
		if (message == null || message.isEmpty()) {
			projetoService.excluir(id);
			message = "Projeto excluido com sucesso.";
			hs = HttpStatus.OK;
		}
		return new ResponseEntity<>(message, hs);
	}
	
}
