/**
 * @author andrei
 *
 * 30 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.EspecialidadeMedicaDAO;
import com.br.sixminds.psyconnect.model.EspecialidadeMedica;
import com.br.sixminds.psyconnect.model.Medico;
import com.br.sixminds.psyconnect.model.enums.TipoLogradouro;
import com.br.sixminds.psyconnect.model.enums.TipoTelefone;
import com.br.sixminds.psyconnect.service.CadastroMedicoService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Medico medico;

	@Inject
	private CadastroMedicoService cadastroMedicoService;	

	private List<EspecialidadeMedica> especialidadeMedicas;	

	@Inject
	private EspecialidadeMedicaDAO especialidadeMedicaDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (medico == null) {
			limpar();

		}
		
		this.especialidadeMedicas = this.especialidadeMedicaDAO.buscarTodos();

	}

	/**
	 * 
	 */
	private void limpar() {
		this.medico = new Medico();
	}

	public void salvar() {
		try {

			this.cadastroMedicoService.salvar(medico);
			facesMessages.info("Médico salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<EspecialidadeMedica> getEspecialidadeMedicas() {
		return especialidadeMedicas;
	}
	
	/* enuns */
	
	public TipoLogradouro[] getTipoLogradouros(){
		return TipoLogradouro.values();
		
	}

	public TipoTelefone[] getTipoTelefones() {
		return TipoTelefone.values();

	}

	public boolean isEditando() {
		return this.medico.getCodigo() != null;
	}

}
