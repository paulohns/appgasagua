package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author PauloHenrique
 *
 */
@Entity
@Table(name="TB_AVALIACAO_PEDIDO")
//@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_AVALIACAO")
public class AvaliacaoPedido {
	
	private Integer idAvaliacao;
	private String descricao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="TB_AVALIACAO_PEDIDO_ID_SEQ")
	@SequenceGenerator(allocationSize=1, initialValue=1, name="TB_AVALIACAO_PEDIDO_ID_SEQ", sequenceName="TB_AVALIACAO_PEDIDO_ID_SEQ")
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
