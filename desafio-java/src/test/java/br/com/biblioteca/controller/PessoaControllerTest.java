package br.com.biblioteca.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.biblioteca.dto.PessoaDto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PessoaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<PessoaDto> pessoaDtoJson;
	
	@MockBean
	PessoaController pessoaController;

	@Test
	@DisplayName("testa a persistencia de pessoa atravez da api rest")
	void persistir_pessoa_apirest() throws Exception {
		var response = mvc.perform(
				MockMvcRequestBuilders.post("/pessoa/adicionar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(pessoaDtoJson.write(
						new PessoaDto("nome qualquer", "1990-10-26", "12345678901", true)
				).getJson())
		).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	@DisplayName("testa a falha da persistencia de pessoa com o cpf maior que 11 caracteres")
	void persistir_pessoa_cpf_apirest() throws Exception {
		var response = mvc.perform(
				MockMvcRequestBuilders.post("/pessoa/adicionar")
				.contentType(MediaType.APPLICATION_JSON)
				.content( "{\"nome\":\"Mychelgruillo\",\"dataNascimento\":\"1990-10-26\",\"cpf\":\"06888549909654654\",\"isFuncionario\":true}" )
				).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

}
