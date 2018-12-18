package com.br.sixminds.psyconnect.model.enums;

public enum TipoSituacaoCadastro {

	ATIVO("ATIVO"), 
	INATIVO("INATIVO");

	private String descricao;

	TipoSituacaoCadastro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
