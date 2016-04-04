package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_endereco")
public class EnderecoPedido {

	private Integer idEndereco;
	private String endereco;
	private Integer numero;
	private String cep;
	private String cidadeEstado;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id",length=11, unique=true)
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	@Column(name="endereco", length=250)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name="numero", length=6)
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	@Column(name="cep", length=10)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Column(name="cidade_estado", length=80)
	public String getCidadeEstado() {
		return cidadeEstado;
	}
	public void setCidadeEstado(String cidadeEstado) {
		this.cidadeEstado = cidadeEstado;
	}
	
	@Transient
	public String getEnderecoCompleto(){
		return endereco + ", " + numero + " - " + cep + " - " + cidadeEstado; 
	}
	
}
