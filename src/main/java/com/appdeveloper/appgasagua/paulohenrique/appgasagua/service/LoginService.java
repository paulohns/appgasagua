<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema;

/**
 * @author PauloHenrique
 *
 */
public interface LoginService {

	/**
	 * @param LoginSistema
	 * @throws AppGasAguaException
	 */
	void salvar(LoginSistema LoginSistema) throws AppGasAguaException;

	/**
	 * @param protudoSelecionado
	 * @throws AppGasAguaException
	 */
	void removerLoginSistema(LoginSistema loginSistema)
			throws AppGasAguaException;

	/**
	 * @param loginSistema
	 * @return
	 * @throws AppGasAguaException
	 */
	boolean fazerLogin(LoginSistema loginSistema) throws AppGasAguaException;;

}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema;

/**
 * @author PauloHenrique
 *
 */
public interface LoginService {

	/**
	 * @param LoginSistema
	 * @throws AppGasAguaException
	 */
	void salvar(LoginSistema LoginSistema) throws AppGasAguaException;

	/**
	 * @param protudoSelecionado
	 * @throws AppGasAguaException
	 */
	void removerLoginSistema(LoginSistema loginSistema)
			throws AppGasAguaException;

	/**
	 * @param loginSistema
	 * @return
	 * @throws AppGasAguaException
	 */
	boolean fazerLogin(LoginSistema loginSistema) throws AppGasAguaException;;

}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
