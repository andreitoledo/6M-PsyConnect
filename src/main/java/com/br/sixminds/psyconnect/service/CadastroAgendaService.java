/**
 * @author andrei
 *
 * 18 de dez de 2018
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.AgendaDAO;
import com.br.sixminds.psyconnect.model.Agenda;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroAgendaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AgendaDAO agendaDAO;

	@Transactional
	public void salvar(Agenda agenda) throws NegocioException {

		this.agendaDAO.salvar(agenda);

	}

}
