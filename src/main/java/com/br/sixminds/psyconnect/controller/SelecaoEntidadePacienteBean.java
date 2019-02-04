package com.br.sixminds.psyconnect.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.br.sixminds.psyconnect.dao.PacienteDAO;
import com.br.sixminds.psyconnect.model.Paciente;

@Named
@ViewScoped
public class SelecaoEntidadePacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PacienteDAO pacienteDAO;
	

	private String nome;

	private List<Paciente> pacientesFiltrados;

	/* efetua a busca pelo nome passado na pesquisa */
	public void pesquisar() {
		pacientesFiltrados = pacienteDAO.porNomeSemelhante(nome);
	}

	/* cria a caixa de dialogo */
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 700);

		RequestContext.getCurrentInstance().openDialog("SelecaoPaciente", opcoes, null);
	}

	public void selecionar(Paciente paciente) {
		RequestContext.getCurrentInstance().closeDialog(paciente);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientesFiltrados() {
		return pacientesFiltrados;
	}

}