/**
 * @author andrei
 *
 * 14 de dez de 2018
 */
package com.br.sixminds.psyconnect.controller.cadastros.entidade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.sixminds.psyconnect.model.EspecialidadeMedica;
import com.br.sixminds.psyconnect.service.CadastroEspecialidadeMedicaService;
import com.br.sixminds.psyconnect.service.NegocioException;
import com.br.sixminds.psyconnect.util.jsf.FacesMessages;

/**
 * @author andrei
 *
 */

@Named
@ViewScoped
public class CadastroEspecialidadeMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EspecialidadeMedica especialidadeMedica;

	@Inject
	private CadastroEspecialidadeMedicaService cadastroEspecialidadeMedicaService;

    @Inject
	private FacesMessages facesMessages;
    
    public void inicializar(){
    	if (especialidadeMedica == null) {
    		limpar();
			
		}
    }

	/**
	 * 
	 */
	private void limpar() {
		this.especialidadeMedica = new EspecialidadeMedica();
		
	}
	
	public void salvar() {
		try {
			this.cadastroEspecialidadeMedicaService.salvar(especialidadeMedica);
			facesMessages.info("Especialidade Médica salvo com sucesso.");

		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());

		}

		limpar();
	}
    
	
	public EspecialidadeMedica getEspecialidadeMedica() {
		return especialidadeMedica;
	}

	public void setEspecialidadeMedica(EspecialidadeMedica especialidadeMedica) {
		this.especialidadeMedica = especialidadeMedica;
	}

	public boolean isEditando() {
		return this.especialidadeMedica.getCodigo() != null;
	}
}
