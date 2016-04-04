package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl.LoginDAOImpl;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.LoginService;

/**
 * @author PauloHenrique
 *
 */
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginSistemaDAO = new LoginDAOImpl(LoginSistema.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.
	 * LoginSistemaService
	 * #salvar(com.appdeveloper.appgasagua.paulohenrique.appgasagua
	 * .model.LoginSistema)
	 */
	@Override
	public void salvar(LoginSistema LoginSistema) throws AppGasAguaException {
		loginSistemaDAO.salvar(LoginSistema);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.
	 * LoginSistemaService
	 * #removerLoginSistema(com.appdeveloper.appgasagua.paulohenrique
	 * .appgasagua.model.LoginSistema)
	 */
	@Override
	public void removerLoginSistema(LoginSistema protudoSelecionado)
			throws AppGasAguaException {
		loginSistemaDAO.removerLoginSistema(protudoSelecionado);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.LoginService
	 * #fazerLogin(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.
	 * LoginSistema)
	 */
	@Override
	public boolean fazerLogin(LoginSistema loginSistema)
			throws AppGasAguaException {
		return loginSistemaDAO.fazerLogin(loginSistema);
	}

}
