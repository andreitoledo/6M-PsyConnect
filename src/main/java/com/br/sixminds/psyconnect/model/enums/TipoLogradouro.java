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
public enum TipoLogradouro {
	
	RUA("RUA"),        
	AVENIDA("AVENIDA"),    
	TRAVESSA("TRAVESSA"),   
	PARALELA("PARALELA"),   
	SUBIDA("SUBIDA"),     
	BECO("BECO"),       
	LADEIRA("LADEIRA"),    
	LARGO("LARGO"),      
	LOTE("LOTE"),       
	MORRO("MORRO"),      
	PARQUE("PARQUE"),     
	PASSAGEM("PASSAGEM"),   
	PRACA("PRAÇA"),      
	QUADRA("QUADRA"),     
	RECANTO("RECANTO"),    
	RESIDENCIAL("RESIDENCIAL"),
	RODOVIA("RODOVIA"),    
	SITIO("SÍTIO"),      
	TUNEL("TÚNEL"),      
	VALE("VALE");
	
	private String descricao;

	private TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	

}
