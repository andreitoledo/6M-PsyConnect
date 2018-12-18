/**
 * @author andrei
 *
 * 18 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.Agenda;
import com.br.sixminds.psyconnect.service.CadastroAgendaService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroAgendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Agenda agenda;

	@Inject
	private CadastroAgendaService cadastroAgendaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (agenda == null) {
			limpar();

		}
	}

	private void limpar() {
		this.agenda = new Agenda();

	}

	public void salvar() {
		try {
			this.cadastroAgendaService.salvar(agenda);
			facesMessages.info("Agenda salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

		limpar();

	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public boolean isEditando() {
		return this.agenda.getCodigo() != null;
	}

}
