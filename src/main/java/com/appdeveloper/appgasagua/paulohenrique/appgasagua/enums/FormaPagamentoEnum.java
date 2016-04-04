package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

public enum FormaPagamentoEnum {

	CARTAO("Cartão"), DINHEIRO("Dinheiro"); 

	private String descricao;

	private FormaPagamentoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
