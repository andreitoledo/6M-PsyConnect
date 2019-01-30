/**
 * @author andrei
 *
 * 30 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.Medico;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	MedicoDAO medicoDAO;

	private List<Medico> medicos = new ArrayList<>();

	private Medico medicoSelecionado;

	@Inject
	private FacesMessages facesmessages;

	/**
	 * @return the medicos
	 */
	public List<Medico> getMedicos() {
		return medicos;
	}

	@PostConstruct
	public void inicializar() {
		medicos = medicoDAO.buscarTodos();
	}

	public void excluir() {
		try {
			medicoDAO.excluir(medicoSelecionado);
			this.medicos.remove(medicoSelecionado);
			facesmessages.info("Medico " + medicoSelecionado.getNome() + " excluído com sucesso.");

		} catch (NegocioException e) {
			facesmessages.error(e.getMessage());
		}
	}

	public Medico getMedicoSelecionado() {
		return medicoSelecionado;
	}

	public void setMedicoSelecionado(Medico medicoSelecionado) {
		this.medicoSelecionado = medicoSelecionado;
	}

}
