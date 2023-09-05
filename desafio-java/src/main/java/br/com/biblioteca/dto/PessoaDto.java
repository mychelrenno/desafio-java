package br.com.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PessoaDto {
	
	private String nome;
	
	private String dataNascimento;
	
	private String cpf;
	
	private Boolean isFuncionario;

}
