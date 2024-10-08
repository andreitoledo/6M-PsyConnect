/**
 * @author andrei
 *
 * 19 de jan de 2019
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.Grupo;
import com.br.sixminds.psyconnect.service.CadastroGrupoService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Grupo grupo;

	@Inject
	private CadastroGrupoService cadastroGrupoService;

	@Inject
	private FacesMessages facesMessages;

	public void inicializar() {
		if (grupo == null) {
			limpar();

		}

	}

	/**
	 * 
	 */
	private void limpar() {
		this.grupo = new Grupo();

	}

	public void salvar() {
		try {
			this.cadastroGrupoService.salvar(grupo);
			facesMessages.info("Grupo salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}

		limpar();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public boolean isEditando() {
		return this.grupo.getCodigo() != null;
	}

}
