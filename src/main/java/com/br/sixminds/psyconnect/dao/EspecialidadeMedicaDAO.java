/**
 * @author andrei
 *
 * 12 de dez de 2018
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.EspecialidadeMedica;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class EspecialidadeMedicaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public EspecialidadeMedica buscarPeloCodigo(Long codigo) {
		return manager.find(EspecialidadeMedica.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<EspecialidadeMedica> buscarTodos() {
		return manager.createQuery("Select em from EspecialidadeMedica em").getResultList();
	}

	public void salvar(EspecialidadeMedica especialidadeMedica) {
		manager.merge(especialidadeMedica);
	}

	@Transactional
	public void excluir(EspecialidadeMedica especialidadeMedica) throws NegocioException {
		especialidadeMedica = buscarPeloCodigo(especialidadeMedica.getCodigo());

		try {
			manager.remove(especialidadeMedica);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Essa especialidade não pode ser excluído.");

		}

	}

}
