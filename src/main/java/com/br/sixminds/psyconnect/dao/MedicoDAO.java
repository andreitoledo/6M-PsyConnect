/**
 * @author andrei
 *
 * 29 de dez de 2018
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.Medico;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class MedicoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Medico buscarPeloCodigo(Long codigo) {
		return manager.find(Medico.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Medico> buscarTodos() {
		return manager.createNamedQuery("Medico.buscarTodos").getResultList();
	}

	public void salvar(Medico medico) {
		manager.merge(medico);
	}

	@Transactional
	public void excluir(Medico medico) throws NegocioException {
		medico = buscarPeloCodigo(medico.getCodigo());

		try {
			manager.remove(medico);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Médico não pode ser excluído");

		}
	}

	public List<Medico> porNomeSemelhante(String nome) {

		return manager.createQuery("from Medico where nome like :nome", Medico.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

}
