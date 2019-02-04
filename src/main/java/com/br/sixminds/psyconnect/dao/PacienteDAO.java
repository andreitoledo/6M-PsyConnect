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
import javax.persistence.PersistenceException;

import com.br.sixminds.psyconnect.model.Paciente;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */

public class PacienteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	/* métodos */

	public Paciente buscarPeloCodigo(Long codigo) {
		return manager.find(Paciente.class, codigo);

	}

	@SuppressWarnings("unchecked")
	public List<Paciente> buscarTodos() {
		return manager.createQuery("Select p from Paciente p").getResultList();

	}

	public void salvar(Paciente paciente) {
		manager.merge(paciente);

	}

	@Transactional
	public void excluir(Paciente paciente) throws NegocioException {
		paciente = buscarPeloCodigo(paciente.getCodigo());

		try {
			manager.remove(paciente);
			manager.flush();

		} catch (PersistenceException e) {
			throw new NegocioException("Paciente não pode ser excluído.");

		}

	}

	public List<Paciente> porNomeSemelhante(String nome) {

		return manager.createQuery("from Paciente where nome like :nome", Paciente.class)
				.setParameter("nome", "%" + nome + "%").getResultList();
	}

	public List<Paciente> porCpfSemelhante(String inscricaoFederal) {

		return manager.createQuery("from Paciente where inscricaoFederal like :inscricaoFederal", Paciente.class)
				.setParameter("inscricaoFederal", "%" + inscricaoFederal + "%").getResultList();
	}

}
