/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.ConsultaMedicaDAO;
import com.br.sixminds.psyconnect.model.ConsultaMedica;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaConsultaMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ConsultaMedicaDAO consultaMedicaDAO;

	private List<ConsultaMedica> consultasMedicas = new ArrayList<>();

	private ConsultaMedica consultaMedicaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the consultasMedicas
	 */
	public List<ConsultaMedica> getConsultasMedicas() {
		return consultasMedicas;
	}

	@PostConstruct
	public void inicializar() {
		consultasMedicas = consultaMedicaDAO.buscarTodos();

	}

	public void excluir() {
		try {
			consultaMedicaDAO.excluir(consultaMedicaSelecionado);
			this.consultasMedicas.remove(consultaMedicaSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());

		}

	}

	public ConsultaMedica getConsultaMedicaSelecionado() {
		return consultaMedicaSelecionado;
	}

	public void setConsultaMedicaSelecionado(ConsultaMedica consultaMedicaSelecionado) {
		this.consultaMedicaSelecionado = consultaMedicaSelecionado;
	}

}
