/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.GrupoDAO;
import com.br.sixminds.psyconnect.model.Grupo;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroGrupoService implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GrupoDAO grupoDAO;
	
	@Transactional
	public void salvar(Grupo grupo) throws NegocioException{
		
		this.grupoDAO.salvar(grupo);
		
	}

}
