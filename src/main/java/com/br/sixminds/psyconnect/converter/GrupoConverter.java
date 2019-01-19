/**
 * @author andrei
 *
 * 13 de jan de 2019
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.GrupoDAO;
import com.br.sixminds.psyconnect.model.Grupo;

/**
 * @author andrei
 *
 */
@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter {

	@Inject
	private GrupoDAO grupoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Grupo retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.grupoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((Grupo) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
