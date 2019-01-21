/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.ConsultaMedicaDAO;
import com.br.sixminds.psyconnect.model.ConsultaMedica;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroConsultaMedicaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ConsultaMedicaDAO ConsultaMedicaDAO;

	@Transactional
	public void salvar(ConsultaMedica consultaMedica) throws NegocioException {

		this.ConsultaMedicaDAO.salvar(consultaMedica);

	}

}
