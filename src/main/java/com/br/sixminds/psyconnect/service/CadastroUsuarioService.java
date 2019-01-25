/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.UsuarioDAO;
import com.br.sixminds.psyconnect.model.Usuario;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Transactional
	public void salvar(Usuario usuario) throws NegocioException {
		
		if (usuario.getNome() == null 
			|| usuario.getNome().equals("Selecione")){
		throw new NegocioException("O Nome deve ser informado.");
		
		}

		this.usuarioDAO.salvar(usuario);
	}

}
