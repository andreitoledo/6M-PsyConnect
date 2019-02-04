/**
 * @author andrei
 *
 * 7 de dez de 2018
 */
package com.br.sixminds.psyconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.br.sixminds.psyconnect.model.enums.TipoLogradouro;
import com.br.sixminds.psyconnect.model.enums.TipoTelefone;

/**
 * @author andrei
 *
 */

@Entity
@Table(name = "paciente")
@DiscriminatorValue("PACIENTE")
public class Paciente extends Entidade {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Temporal(TemporalType.DATE)	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual; // rg
	@NotEmpty
	@CPF
	@Column(name = "inscricao_federal")
	private String inscricaoFederal; // cpf

	/* ENDERECO ESTABELECIMENTO */

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_log_estabelecimento")
	private TipoLogradouro tipoLogradouro;
	@Column(name = "logradouro_estabelecimento")
	private String logradouro;
	@Column(name = "numero_estabelecimento")
	private String numero;
	@Column(name = "complemento_estabelecimento")
	private String complemento;
	@Column(name = "bairro_estabelecimento")
	private String bairro;
	@Column(name = "cep_estabelecimento")
	private String cep;
	@Column(name = "cidade_estabelecimento")
	private String cidade;
	@Column(name = "uf_estabelecimento")
	private String uf;
	@Column(name = "pais_estabelecimento")
	private String pais;

	/* CONTATOS */

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone1")
	private TipoTelefone tipoTelefone1;
	private String ddd1;
	@Column(name = "numero_tel1")
	private String numeroTel1;
	private String contato1;
	@Email
	private String email1;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone2")
	private TipoTelefone tipoTelefone2;
	private String ddd2;
	@Column(name = "numero_tel2")
	private String numeroTel2;
	private String contato2;
	private String email2;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone3")
	private TipoTelefone tipoTelefone3;
	private String ddd3;
	@Column(name = "numero_tel3")
	private String numeroTel3;
	private String contato3;
	private String email3;


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoFederal() {
		return inscricaoFederal;
	}

	public void setInscricaoFederal(String inscricaoFederal) {
		this.inscricaoFederal = inscricaoFederal;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public TipoTelefone getTipoTelefone1() {
		return tipoTelefone1;
	}

	public void setTipoTelefone1(TipoTelefone tipoTelefone1) {
		this.tipoTelefone1 = tipoTelefone1;
	}

	public String getDdd1() {
		return ddd1;
	}

	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}

	public String getNumeroTel1() {
		return numeroTel1;
	}

	public void setNumeroTel1(String numeroTel1) {
		this.numeroTel1 = numeroTel1;
	}

	public String getContato1() {
		return contato1;
	}

	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public TipoTelefone getTipoTelefone2() {
		return tipoTelefone2;
	}

	public void setTipoTelefone2(TipoTelefone tipoTelefone2) {
		this.tipoTelefone2 = tipoTelefone2;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public String getNumeroTel2() {
		return numeroTel2;
	}

	public void setNumeroTel2(String numeroTel2) {
		this.numeroTel2 = numeroTel2;
	}

	public String getContato2() {
		return contato2;
	}

	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public TipoTelefone getTipoTelefone3() {
		return tipoTelefone3;
	}

	public void setTipoTelefone3(TipoTelefone tipoTelefone3) {
		this.tipoTelefone3 = tipoTelefone3;
	}

	public String getDdd3() {
		return ddd3;
	}

	public void setDdd3(String ddd3) {
		this.ddd3 = ddd3;
	}

	public String getNumeroTel3() {
		return numeroTel3;
	}

	public void setNumeroTel3(String numeroTel3) {
		this.numeroTel3 = numeroTel3;
	}

	public String getContato3() {
		return contato3;
	}

	public void setContato3(String contato3) {
		this.contato3 = contato3;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

}
