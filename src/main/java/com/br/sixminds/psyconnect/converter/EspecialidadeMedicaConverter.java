/**
 * @author andrei
 *
 * 12 de dez de 2018
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.EspecialidadeMedicaDAO;
import com.br.sixminds.psyconnect.model.EspecialidadeMedica;

/**
 * @author andrei
 * 
 */

@FacesConverter(forClass = EspecialidadeMedica.class)
public class EspecialidadeMedicaConverter implements Converter {

	@Inject
	private EspecialidadeMedicaDAO EspecialidadeMedicaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		EspecialidadeMedica retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.EspecialidadeMedicaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((EspecialidadeMedica) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
