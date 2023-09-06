package br.com.biblioteca.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PessoaDto {
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String dataNascimento;
	
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	private Boolean isFuncionario;

}
