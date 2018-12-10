/**
 * @author andrei
 *
 * 9 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.PacienteDAO;
import com.br.sixminds.psyconnect.model.Paciente;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaPacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	PacienteDAO pacienteDAO;

	private List<Paciente> pacientes = new ArrayList<>();

	private Paciente pacienteSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the pacientes
	 */
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	/* carrego a lista com todos os pacientes */
	@PostConstruct
	public void inicializar() {
		pacientes = pacienteDAO.buscarTodos();
	}

	public void excluir() {
		try {
			pacienteDAO.excluir(pacienteSelecionado);
			this.pacientes.remove(pacienteSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());

		}
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}

}
