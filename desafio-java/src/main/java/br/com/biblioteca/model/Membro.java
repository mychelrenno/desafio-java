package br.com.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "membro")
public class Membro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_membro", referencedColumnName = "id", nullable = false)
	private Pessoa membro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_projeto", referencedColumnName = "id", nullable = false)
	private Projeto projeto;

}
