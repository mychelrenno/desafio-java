package br.com.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.service.ProjetoService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	ProjetoService projetoService;

	@GetMapping
	public String home(Model model, HttpServletRequest httpServletRequest) {
		
		model.addAttribute("projetoList", projetoService.buscarTodosOrderById());
		
		return "index";
	}
	
}
