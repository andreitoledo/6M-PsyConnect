/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.ConsultaMedica;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class ConsultaMedicaDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ConsultaMedica buscarPeloCodigo(Long codigo) {
		return manager.find(ConsultaMedica.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> buscarTodos() {
		return manager.createNamedQuery("ConsultaMedica.buscarTodos").getResultList();

	}

	public void salvar(ConsultaMedica consultaMedica) {
		manager.merge(consultaMedica);

	}

	@Transactional
	public void excluir(ConsultaMedica consultaMedica) throws NegocioException {
		consultaMedica = buscarPeloCodigo(consultaMedica.getCodigo());

		try {
			manager.remove(consultaMedica);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Consulta Médica não pode ser excluído.");

		}

	}

	public List<ConsultaMedica> porDescricaoSemelhante(String descricao) {

		return manager.createQuery("from ConsultaMedica where descricao like :descricao", ConsultaMedica.class)
				.setParameter("descricao", "%" + descricao + "%").getResultList();
	}

	public List<ConsultaMedica> porDescricao(String descricao) {
		return this.manager
				.createQuery("from ConsultaMedica where upper(descricao) like :descricao", ConsultaMedica.class)
				.setParameter("descricao", descricao.toUpperCase() + "%").getResultList();

	}

}
