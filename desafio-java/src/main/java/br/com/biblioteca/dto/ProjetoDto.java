package br.com.biblioteca.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.biblioteca.enums.RiscoEnum;
import br.com.biblioteca.enums.StatusEnum;
import lombok.Data;

@Data
public class ProjetoDto {
	
	private Long id;

	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataPrevisao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	private String descricao;
	
	private StatusEnum status;
	
	@NumberFormat(style=Style.CURRENCY, pattern = "###.##0,00")
	private BigDecimal orcamento;
	
	private RiscoEnum risco;
	
	private Long gerente;
	
	private Set<Long> membros;
	
	private Date dataInicioF;
	
	private Date dataPrevisaoF;
	
	private Date dataFimF;
	
	private BigDecimal orcamentoF;
	
}
