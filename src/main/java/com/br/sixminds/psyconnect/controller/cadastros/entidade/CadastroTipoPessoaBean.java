/**
 * @author andrei
 *
 * 23 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.TipoPessoa;
import com.br.sixminds.psyconnect.service.CadastroTipoPessoaService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroTipoPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TipoPessoa tipoPessoa;

	@Inject
	private CadastroTipoPessoaService cadastroTipoPessoaService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (tipoPessoa == null) {
			limpar();

		}
	}

	private void limpar() {
		this.tipoPessoa = new TipoPessoa();

	}

	public void salvar() {
		try {
			this.cadastroTipoPessoaService.salvar(tipoPessoa);
			facesMessages.info("Tipo Pessoa salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public boolean isEditando() {
		return this.tipoPessoa.getCodigo() != null;
	}

}
