package br.com.biblioteca.enums;

public enum RiscoEnum {

	BAIXO_RISCO(1, "Baixo"),
	MEDIO_RISCO(2, "Médio"),
	ALTO_RISCO(3, "Alto");
	
	private Integer codigo;
	private String descricao;

	RiscoEnum(Integer codigo, String descricao) {
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
