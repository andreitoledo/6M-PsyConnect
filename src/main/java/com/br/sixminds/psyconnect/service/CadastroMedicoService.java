/**
 * @author andrei
 *
 * 29 de dez de 2018
 */
package com.br.sixminds.psyconnect.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.Medico;
import com.br.sixminds.psyconnect.util.jpa.Transactional;

/**
 * @author andrei
 *
 */
public class CadastroMedicoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MedicoDAO medicoDAO;
	
	@Transactional
	public void salvar(Medico medico) throws NegocioException {		
		
		/*regra: verifica se o CPF já existe.*/
		String inscricaoFederal = null;
		if (medico.getInscricaoFederal().equals(medicoDAO.porCpfSemelhante(inscricaoFederal))) {
			throw new NegocioException("CPF já existente.");			
		}
		
		/*regra: especialidade deve ser informada*/
		if (medico.getEspecialidadeMedica() == null 
				|| medico.getEspecialidadeMedica().equals("Selecione")) {
			throw new NegocioException("A especialidade deve ser informada.");
			
		}
		
		this.medicoDAO.salvar(medico);
		
		
		
	}

}
