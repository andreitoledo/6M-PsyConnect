/**
 * @author andrei
 *
 * 6 de dez de 2018
 */
package com.br.sixminds.psyconnect.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 * @author andrei
 *
 */
public class FacesProducer {
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
//	@Produces
//	@RequestScoped
//	public HttpServletRequest getHttpServletRequest() {
//		return ((HttpServletRequest) getExternalContext().getRequest());	
//	}
	
	@Produces
	@RequestScoped
	public HttpServletResponse getHttpServletResponse() {
		return ((HttpServletResponse) getExternalContext().getResponse());	
	}

}
