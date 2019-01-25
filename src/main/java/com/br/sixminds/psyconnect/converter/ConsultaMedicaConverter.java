/**
 * @author andrei
 *
 * 21 de jan de 2019
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.ConsultaMedicaDAO;
import com.br.sixminds.psyconnect.model.ConsultaMedica;

/**
 * @author andrei
 *
 */

@FacesConverter(forClass = ConsultaMedica.class)
public class ConsultaMedicaConverter implements Converter {

	@Inject
	private ConsultaMedicaDAO consultaMedicaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		ConsultaMedica retorno = null;

		/*isNotEmpty = não está vazio*/
		if (StringUtils.isNotEmpty(value)) {
			retorno = this.consultaMedicaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((ConsultaMedica) value).getCodigo();
			String retorno = ((codigo == null ? null : codigo.toString()));

			return retorno;

		}

		return "";
	}

}
