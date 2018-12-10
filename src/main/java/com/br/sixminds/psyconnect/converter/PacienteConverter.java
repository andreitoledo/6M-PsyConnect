/**
 * @author andrei
 *
 * 9 de dez de 2018
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.PacienteDAO;
import com.br.sixminds.psyconnect.model.Paciente;

/**
 * @author andrei
 *
 */

@FacesConverter(forClass = Paciente.class)
public class PacienteConverter implements Converter {

	@Inject
	private PacienteDAO pacienteDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Paciente retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.pacienteDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Paciente) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
