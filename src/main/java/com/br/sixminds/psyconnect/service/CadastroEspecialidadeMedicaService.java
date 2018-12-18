/**
 * @author andrei
 *
 * 12 de dez de 2018
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.EspecialidadeMedicaDAO;
import com.br.sixminds.psyconnect.model.EspecialidadeMedica;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */

public class CadastroEspecialidadeMedicaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EspecialidadeMedicaDAO especialidadeMedicaDAO;

	@Transactional
	public void salvar(EspecialidadeMedica especialidadeMedica) throws NegocioException {

		this.especialidadeMedicaDAO.salvar(especialidadeMedica);

	}

}
