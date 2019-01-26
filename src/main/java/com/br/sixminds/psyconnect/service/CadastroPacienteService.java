/**
 * @author andrei
 *
 * 9 de dez de 2018
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.PacienteDAO;
import com.br.sixminds.psyconnect.model.Paciente;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 * 
 */

public class CadastroPacienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PacienteDAO pacienteDAO;

	@Transactional
	public void salvar(Paciente paciente) throws NegocioException {
		
		/*regra: deixar o CPF único*/
		
		

		this.pacienteDAO.salvar(paciente);

	}

}
