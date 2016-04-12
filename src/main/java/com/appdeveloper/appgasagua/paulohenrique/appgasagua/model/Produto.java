package com.appdeveloper.appgasagua.paulohenrique.appgasagua.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;

@Entity
@Table(name="TB_PRODUTO", schema="public")
public class Produto {

	private Integer idProduto;
	private Integer quantidade;//quantidade a ser comprada
	private String descricao;//alterar para marca
	private BigDecimal valor;//valor de cada unidade
	private TipoProdutoEnum tipo;//trazer esta informacao junto com a marca na combo no app
//	private EspecificacaoEnum especificacao;//remover este campo, o tipo ja especifica
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="TB_PRODUTO_ID_SEQ")
	@SequenceGenerator(allocationSize=1, initialValue=1, name="TB_PRODUTO_ID_SEQ", sequenceName="TB_PRODUTO_ID_SEQ")
	@Column(name="id",length=11, unique=true)
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo")
	public TipoProdutoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoProdutoEnum tipo) {
		this.tipo = tipo;
	}

	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	@Enumerated(EnumType.ORDINAL)
//	@Column(name="especificacao")
//	public EspecificacaoEnum getEspecificacao() {
//		return especificacao;
//	}
//	public void setEspecificacao(EspecificacaoEnum especificacao) {
//		this.especificacao = especificacao;
//	}
	
	@Column(name="quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name="valor")
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
