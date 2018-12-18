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

import com.br.sixminds.psyconnect.dao.EspecialidadeMedicaDAO;
import com.br.sixminds.psyconnect.model.EspecialidadeMedica;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaEspecialidadeMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EspecialidadeMedicaDAO especialidadeMedicaDAO;

	private List<EspecialidadeMedica> especialidadesMedicas = new ArrayList<>();

	private EspecialidadeMedica especialidadeMedicaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the especialidadesMedicas
	 */
	public List<EspecialidadeMedica> getEspecialidadesMedicas() {
		return especialidadesMedicas;
	}

	@PostConstruct
	public void inicializar() {
		especialidadesMedicas = especialidadeMedicaDAO.buscarTodos();
	}

	public void excluir() {
		try {
			especialidadeMedicaDAO.excluir(especialidadeMedicaSelecionado);
			this.especialidadesMedicas.remove(especialidadeMedicaSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());
		}
	}

	public EspecialidadeMedica getEspecialidadeMedicaSelecionado() {
		return especialidadeMedicaSelecionado;
	}

	public void setEspecialidadeMedicaSelecionado(EspecialidadeMedica especialidadeMedicaSelecionado) {
		this.especialidadeMedicaSelecionado = especialidadeMedicaSelecionado;
	}

}
