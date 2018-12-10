/**
 * @author andrei
 *
 * 7 de dez de 2018
 */
package com.br.sixminds.psyconnect.model.enums;

/**
 * @author andrei
 *
 */
public enum TipoTelefone {

	CELULAR("CELULAR"), 
	RESIDENCIAL("RESIDENCIAL"), 
	COMERCIAL("COMERCIAL"), 
	CONTATO("CONTATO");

	private String descricao;

	// construtor
	private TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	// get descricao
	public String getDescricao() {
		return descricao;
	}

}
