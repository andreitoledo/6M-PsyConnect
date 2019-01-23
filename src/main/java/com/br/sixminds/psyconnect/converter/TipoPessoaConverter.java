/**
 * @author andrei
 *
 * 23 de jan de 2019
 */
package com.br.sixminds.psyconnect.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.br.sixminds.psyconnect.dao.TipoPessoaDAO;
import com.br.sixminds.psyconnect.model.TipoPessoa;

/**
 * @author andrei
 *
 */

@FacesConverter(forClass = TipoPessoa.class)
public class TipoPessoaConverter implements Converter {

	@Inject
	private TipoPessoaDAO tipoPessoaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		TipoPessoa retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.tipoPessoaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((TipoPessoa) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
