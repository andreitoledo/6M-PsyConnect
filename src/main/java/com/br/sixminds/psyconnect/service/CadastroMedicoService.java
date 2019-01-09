/**
 * @author andrei
 *
 * 29 de dez de 2018
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.Medico;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroMedicoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MedicoDAO medicoDAO;
	
	@Transactional
	public void salvar(Medico medico) throws NegocioException {
		
		this.medicoDAO.salvar(medico);
		
	}

}
