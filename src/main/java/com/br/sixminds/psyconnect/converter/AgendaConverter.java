/**
 * @author andrei
 *
 * 18 de dez de 2018
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.AgendaDAO;
import com.br.sixminds.psyconnect.model.Agenda;

/**
 * @author andrei
 *
 */

@FacesConverter(forClass = Agenda.class)
public class AgendaConverter implements Converter {

	@Inject
	private AgendaDAO agendaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Agenda retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.agendaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((Agenda) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
