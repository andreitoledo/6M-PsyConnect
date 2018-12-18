/**
 * @author andrei
 *
 * 18 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.AgendaDAO;
import com.br.sixminds.psyconnect.model.Agenda;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaAgendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AgendaDAO agendaDAO;

	private List<Agenda> agendas = new ArrayList<>();

	private Agenda agendaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the agendas
	 */
	public List<Agenda> getAgendas() {
		return agendas;
	}

	@PostConstruct
	public void inicializar() {
		agendas = agendaDAO.buscarTodos();

	}

	public void excluir() {
		try {
			agendaDAO.excluir(agendaSelecionado);
			this.agendas.remove(agendaSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());
		}

	}

	public Agenda getAgendaSelecionado() {
		return agendaSelecionado;
	}

	public void setAgendaSelecionado(Agenda agendaSelecionado) {
		this.agendaSelecionado = agendaSelecionado;
	}

}
