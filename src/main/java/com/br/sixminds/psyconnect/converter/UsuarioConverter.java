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

import com.br.sixminds.psyconnect.model.Usuario;
import com.br.sixminds.psyconnect.repository.Usuarios;
import com.br.sixminds.psyconnect.util.cdi.CDIServiceLocator;

/**
 * @author andrei
 *
 */
@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{
	
	//@Inject
	private Usuarios usuarios;
	
	public UsuarioConverter(){
		this.usuarios = (Usuarios) CDIServiceLocator.getBean(Usuarios.class);
	}
	
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;

		if (value != null) {
			retorno = this.usuarios.porCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Usuario) value).getCodigo().toString();
		}
		return "";
	}
	
	

}
