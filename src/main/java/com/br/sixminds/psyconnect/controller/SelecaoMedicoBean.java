package com.br.sixminds.psyconnect.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.br.sixminds.psyconnect.dao.ConsultaMedicaDAO;
import com.br.sixminds.psyconnect.model.ConsultaMedica;

@Named
@ViewScoped
public class SelecaoMedicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ConsultaMedicaDAO consultaMedicaDAO;

	private String nome;

	private List<ConsultaMedica> consultasMedicasFiltrados;

	public void pesquisar() {
		consultasMedicasFiltrados = consultaMedicaDAO.porNomeSemelhante(nome);
	}

	/* cria a caixa de dialogo */
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 470);

		RequestContext.getCurrentInstance().openDialog("SelecaoConsultaMedica", opcoes, null);
	}

	public void selecionar(ConsultaMedica consultaMedica) {
		RequestContext.getCurrentInstance().closeDialog(consultaMedica);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ConsultaMedica> getConsultasMedicasFiltrados() {
		return consultasMedicasFiltrados;
	}

}