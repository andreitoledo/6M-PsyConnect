/**
 * @author andrei
 *
 * 5 de dez de 2018
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.UsuarioDAO;
import com.br.sixminds.psyconnect.model.Usuario;

/**
 * @author andrei
 *
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioCadastroConverter implements Converter {

	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Usuario retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.usuarioDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((Usuario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
