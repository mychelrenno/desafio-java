package br.com.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
	
	List<Membro> findByProjetoId(Long id);
	
	void deleteAllByProjetoId(Long id);

}
