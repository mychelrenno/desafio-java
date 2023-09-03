package br.com.biblioteca.dto;

import lombok.Data;

@Data
public class PessoaDto {
	
	private String nome;
	
	private String dataNascimento;
	
	private String cpf;
	
	private Boolean isFuncionario;

}
