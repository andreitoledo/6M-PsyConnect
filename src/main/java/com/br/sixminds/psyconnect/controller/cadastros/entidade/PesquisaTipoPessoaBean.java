/**
 * @author andrei
 *
 * 23 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.dao.TipoPessoaDAO;
import com.br.sixminds.psyconnect.model.TipoPessoa;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class PesquisaTipoPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	TipoPessoaDAO tipoPessoaDAO;

	private List<TipoPessoa> tipoPessoas = new ArrayList<>();

	private TipoPessoa tipoPessoaSelecionado;

	@Inject
	private FacesMessages facesMessages;

	/**
	 * @return the tipoPessoas
	 */
	public List<TipoPessoa> getTipoPessoas() {
		return tipoPessoas;
	}

	@PostConstruct
	public void inicializar() {
		tipoPessoas = tipoPessoaDAO.buscarTodos();

	}

	public void excluir() {
		try {
			tipoPessoaDAO.excluir(tipoPessoaSelecionado);
			this.tipoPessoas.remove(tipoPessoaSelecionado);

		} catch (Exception e) {
			facesMessages.error(e.getMessage());

		}
	}

	public TipoPessoa getTipoPessoaSelecionado() {
		return tipoPessoaSelecionado;
	}

	public void setTipoPessoaSelecionado(TipoPessoa tipoPessoaSelecionado) {
		this.tipoPessoaSelecionado = tipoPessoaSelecionado;
	}

}
