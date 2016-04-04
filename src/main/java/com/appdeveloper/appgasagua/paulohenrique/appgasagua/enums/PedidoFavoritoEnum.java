package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum PedidoFavoritoEnum {

	SIM("Sim"), NAO("Não"); 

	private String descricao;

	private PedidoFavoritoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
