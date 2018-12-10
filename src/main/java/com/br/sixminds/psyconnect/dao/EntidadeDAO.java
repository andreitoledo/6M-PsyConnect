/**
 * @author andrei
 *
 * 9 de dez de 2018
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.br.sixminds.psyconnect.model.Entidade;

/**
 * @author andrei
 *
 */

public class EntidadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Entidade> buscarTodos() {
		return manager.createQuery("from Entidade").getResultList();
	}

}
