/**
 * @author andrei
 *
 * 23 de jan de 2019
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.TipoPessoa;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class TipoPessoaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public TipoPessoa buscarPeloCodigo(Long codigo) {
		return manager.find(TipoPessoa.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<TipoPessoa> buscarTodos() {
		return manager.createQuery("Select tp from TipoPessoa tp").getResultList();
	}

	public void salvar(TipoPessoa tipoPessoa) {
		manager.merge(tipoPessoa);
	}

	@Transactional
	public void excluir(TipoPessoa tipoPessoa) throws NegocioException {
		tipoPessoa = buscarPeloCodigo(tipoPessoa.getCodigo());
		try {
			manager.remove(tipoPessoa);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Tipo Pessoa não pode ser excluído.");

		}

	}

}
