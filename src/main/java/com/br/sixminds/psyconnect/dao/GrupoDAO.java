/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.Grupo;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class GrupoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Grupo buscarPeloCodigo(Long codigo) {
		return manager.find(Grupo.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Grupo> buscarTodos() {
		return manager.createQuery("Select g from Grupo g").getResultList();

	}

	public void salvar(Grupo grupo) {
		manager.merge(grupo);

	}

	@Transactional
	public void excluir(Grupo grupo) throws NegocioException {
		grupo = buscarPeloCodigo(grupo.getCodigo());

		try {
			manager.remove(grupo);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Esse grupo não pode ser excluído.");

		}

	}

}
