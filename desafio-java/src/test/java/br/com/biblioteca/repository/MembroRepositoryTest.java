package br.com.biblioteca.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.biblioteca.model.Membro;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MembroRepositoryTest {

	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	@DisplayName("")
	void test() {
		Membro m = new Membro();
		membroRepository.save(m);
	}

}
