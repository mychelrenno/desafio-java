package br.com.biblioteca.enums;

public enum StatusEnum {

	EM_ANALISE(1, "Em análise"),
	ANALISE_REALIZADA(2, "Análise realizada"),
	ANALISE_APROVADA(3, "Análise aprovada"),
	INICIADO(4, "Iniciado"), //
	PLANEJADO(5, "Planejado"),
	EM_ANDAMENTO(6, "Em andamento"), //
	ENCERRADO(7, "Encerrado"), //
	CANCELADO(8, "Cancelado");
	
	private Integer codigo;
	private String descricao;

	StatusEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
