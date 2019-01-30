package com.br.sixminds.psyconnect.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.br.sixminds.psyconnect.dao.MedicoDAO;
import com.br.sixminds.psyconnect.model.Medico;

@Named
@ViewScoped
public class SelecaoEntidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MedicoDAO medicoDAO;

	private String nome;

	private List<Medico> medicosFiltrados;

	/* efetua a busca pelo nome passado na pesquisa */
	public void pesquisar() {
		medicosFiltrados = medicoDAO.porNomeSemelhante(nome);
	}

	/* cria a caixa de dialogo */
	public void abrirDialogo() {
		Map<String, Object> opcoes = new HashMap<>();
		opcoes.put("modal", true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 700);

		RequestContext.getCurrentInstance().openDialog("SelecaoMedico", opcoes, null);
	}

	public void selecionar(Medico medico) {
		RequestContext.getCurrentInstance().closeDialog(medico);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Medico> getMedicosFiltrados() {
		return medicosFiltrados;
	}

}