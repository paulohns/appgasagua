package com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums;

/**
 * @author PauloHenrique
 *
 */
public enum StatusPedidoEnum {

	SOLICITADO("Solicitado"), CANCELADO("Cancelado"), AGUARDANDO_ENTREGA("Aguardando entrega"), ENTREGUE("Entregue"); 

	private String situacao;

	private StatusPedidoEnum(String situacao) {
		this.setSituacao(situacao);
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
