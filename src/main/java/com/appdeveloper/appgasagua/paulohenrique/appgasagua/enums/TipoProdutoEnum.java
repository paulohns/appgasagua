package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum TipoProdutoEnum {
	AGUA("Água"), GAS("Gás"); 

	private String descricao;

	private TipoProdutoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
