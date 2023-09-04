package br.com.biblioteca.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import lombok.Data;

@Data
@Entity
@Table(name = "projeto")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_previsao")
	private Date dataPrevisao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fim")
	private Date dataFim;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusEnum status;
	
	@NumberFormat(style=Style.CURRENCY, pattern = "#,###,##0.00")
	@Column(name = "orcamento")
	private BigDecimal orcamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "risco")
	private RiscoEnum risco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gerente", referencedColumnName = "id")
	private Pessoa gerente;
	
}
