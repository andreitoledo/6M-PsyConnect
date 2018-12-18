/**
 * @author andrei
 *
 * 18 de dez de 2018
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.Agenda;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class AgendaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Agenda buscarPeloCodigo(Long codigo) {
		return manager.find(Agenda.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Agenda> buscarTodos() {
		return manager.createQuery("Select a from Agenda a").getResultList();

	}

	public void salvar(Agenda agenda) {
		manager.merge(agenda);

	}

	@Transactional
	public void excluir(Agenda agenda) throws NegocioException {
		agenda = buscarPeloCodigo(agenda.getCodigo());
		
		try {
			manager.remove(agenda);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Essa agenda não pode ser excluída.");
			
		}

	}

}
