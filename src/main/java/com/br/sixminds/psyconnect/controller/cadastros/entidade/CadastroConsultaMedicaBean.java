/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.ConsultaMedica;
import com.br.sixminds.psyconnect.service.CadastroConsultaMedicaService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroConsultaMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ConsultaMedica consultaMedica;

	@Inject
	private CadastroConsultaMedicaService cadastroConsultaMedicaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (consultaMedica == null) {
			limpar();

		}
	}

	/**
	 * 
	 */
	private void limpar() {
		this.consultaMedica = new ConsultaMedica();

	}

	public void salvar() {
		try {
			this.cadastroConsultaMedicaService.salvar(consultaMedica);
			facesMessages.info("Consulta Médica salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();

	}

	public ConsultaMedica getConsultaMedica() {
		return consultaMedica;
	}

	public void setConsultaMedica(ConsultaMedica consultaMedica) {
		this.consultaMedica = consultaMedica;
	}
	
	public boolean isEditando() {
		return this.consultaMedica.getCodigo() != null;
	}
	

}
