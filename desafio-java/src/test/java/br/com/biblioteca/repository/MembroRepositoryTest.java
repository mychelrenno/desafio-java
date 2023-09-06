package br.com.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.biblioteca.model.Membro;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MembroRepositoryTest {

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	@DisplayName("testa a persistencia da classe membro, onde nao deve ser permitido membro sem projeto e pessoa.")
//	@ExpectedException(Exception.class)
	void saveMembroSemPessoaEProjeto() {
		Membro m = new Membro();
	    assertThrows(Exception.class, () -> {
	    	membroRepository.save(m);
	    });
	}
	
	@Test
	@DisplayName("teste de persistencia da classe membro, com projeto e pessoa.")
	void saveMembroComPessoaEProjeto() {
		Pessoa pessoa = createPessoa("nome qualquer", new Date(), "12345678901", true);
		Projeto projeto = createProjeto();
		Membro membro = new Membro();
		membro.setMembro(pessoa);
		membro.setProjeto(projeto);
		
		membro = membroRepository.save(membro);
		
		assertNotNull(membro.getId());
		assertNotNull(membro.getMembro().getId());
		assertNotNull(membro.getProjeto().getId());
	}
	
	private Pessoa createPessoa(String nome, Date dataNascimento, String cpf, Boolean isFuncionario) {
		Pessoa p = Pessoa.builder().nome(nome).dataNascimento(dataNascimento).cpf(cpf).isFuncionario(isFuncionario).build();
		return em.persist(p);
	}
	
	private Projeto createProjeto() {
		Projeto p = new Projeto();
		return em.persist(p);
	}

}
