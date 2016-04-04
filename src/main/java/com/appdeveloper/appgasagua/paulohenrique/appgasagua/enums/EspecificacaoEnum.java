package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum EspecificacaoEnum {
	AGUA("Água"), GAS("Gás"); 

	private String descricao;

	private EspecificacaoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
