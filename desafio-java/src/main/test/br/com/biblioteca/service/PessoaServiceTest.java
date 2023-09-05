package br.com.biblioteca.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class PessoaServiceTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	PessoaService pessoaService;
	
	@Test
	void testeBasicoDeSoma() {
		int soma = 5 + 1;
		assertEquals(6, soma);
	}

}
