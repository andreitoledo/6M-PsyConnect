/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.ConsultaMedica;
import com.br.sixminds.psyconnect.model.Medico;
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

	@Inject
	private CadastroConsultaMedicaService cadastroConsultaMedicaService;
	
	private ConsultaMedica consultaMedica;

	/* por causa da busca por médicos */
	private List<Medico> medicos;

	@Inject
	private MedicoDAO medicoDAO;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (consultaMedica == null) {
			limpar();

		}

		this.medicos = this.medicoDAO.buscarTodos();
	}

	private void limpar() {
		this.consultaMedica = new ConsultaMedica();

	}

	public void medicoSelecionado(SelectEvent event) {
		Medico medico = (Medico) event.getObject();
		consultaMedica.setMedico(medico);
	}

	public void salvar() {
		try {
			this.cadastroConsultaMedicaService.salvar(consultaMedica);
			facesMessages.info("Consulta Médica salvo com sucesso.");

			limpar();

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

	}

	public ConsultaMedica getConsultaMedica() {
		return consultaMedica;
	}

	public void setConsultaMedica(ConsultaMedica consultaMedica) {
		this.consultaMedica = consultaMedica;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public boolean isEditando() {
		return this.consultaMedica.getCodigo() != null;
	}

	@NotBlank
	public String getNomeMedico() {
		return consultaMedica.getMedico() == null ? null : consultaMedica.getMedico().getNome();
	}

	public void setNomeMedico(String nome) {

	}

}
