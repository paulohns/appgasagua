package com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception;

public class AppGasAguaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public AppGasAguaException(String mensagem) {
		super(mensagem);
	}
	
	public AppGasAguaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
