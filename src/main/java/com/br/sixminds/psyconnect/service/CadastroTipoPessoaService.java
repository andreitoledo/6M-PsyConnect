/**
 * @author andrei
 *
 * 23 de jan de 2019
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.TipoPessoaDAO;
import com.br.sixminds.psyconnect.model.TipoPessoa;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroTipoPessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoPessoaDAO tipoPessoaDAO;

	@Transactional
	public void salvar(TipoPessoa tipoPessoa) throws NegocioException {

		this.tipoPessoaDAO.salvar(tipoPessoa);

	}

}
