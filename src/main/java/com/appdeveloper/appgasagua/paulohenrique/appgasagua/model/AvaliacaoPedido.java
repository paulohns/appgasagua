package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author PauloHenrique
 *
 */
@Entity
@Table(name="tb_avaliacao_pedido")
//@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_AVALIACAO")
public class AvaliacaoPedido {
	
	private Integer idAvaliacao;
	private String descricao;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id",length=11, unique=true)
	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	
	@Column(name="descricao_avaliacao")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
