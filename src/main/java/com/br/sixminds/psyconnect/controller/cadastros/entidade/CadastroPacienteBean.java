/**
 * @author andrei
 *
 * 9 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.Paciente;
import com.br.sixminds.psyconnect.model.enums.TipoLogradouro;
import com.br.sixminds.psyconnect.model.enums.TipoTelefone;
import com.br.sixminds.psyconnect.service.CadastroPacienteService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroPacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Paciente paciente;

	@Inject
	private CadastroPacienteService cadastroPacienteService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (paciente == null) {
			limpar();

		}

	}

	/**
	 * método que limpa os campos para receber novos dados
	 */
	private void limpar() {
		this.paciente = new Paciente();

	}

	public void salvar() {
		try {
			this.cadastroPacienteService.salvar(paciente);
			facesMessages.info("Paciente salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/* enuns */
	public TipoLogradouro[] getTipoLogradouros() {
		return TipoLogradouro.values();
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();

	}

	public boolean isEditando() {
		return this.paciente.getCodigo() != null;
	}

}
