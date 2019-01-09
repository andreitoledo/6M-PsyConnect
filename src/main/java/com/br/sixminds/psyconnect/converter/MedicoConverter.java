/**
 * @author andrei
 *
 * 29 de dez de 2018
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.Medico;

/**
 * @author andrei
 *
 */

@FacesConverter(forClass = Medico.class)
public class MedicoConverter implements Converter {

	@Inject
	private MedicoDAO medicoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Medico retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.medicoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Medico) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
