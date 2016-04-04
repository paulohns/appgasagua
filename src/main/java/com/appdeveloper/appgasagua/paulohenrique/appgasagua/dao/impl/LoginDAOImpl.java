package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl;

import org.hibernate.exception.ConstraintViolationException;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.utils.HibernateUtil;

/**
 * @author PauloHenrique
 *
 */
@SuppressWarnings("serial")
public class LoginDAOImpl extends GenericDAO<LoginSistema> implements LoginDAO {

	public LoginDAOImpl(Class<LoginSistema> entityClass) {
		super(entityClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginSistemaDAO
	 * #salvar
	 * (com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginDAO#salvar
	 * (com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema)
	 */
	@Override
	public void salvar(LoginSistema LoginSistema) throws AppGasAguaException {
		super.save(LoginSistema);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginSistemaDAO
	 * #removerLoginSistema
	 * (com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema)
	 */
	@Override
	public void removerLoginSistema(LoginSistema protudoSelecionado)
			throws AppGasAguaException {
		try {
			super.delete(protudoSelecionado);
		} catch (ConstraintViolationException sqle) {
			throw new AppGasAguaException(
					"Não é possivel remover este Login do sistema.");
		} catch (AppGasAguaException as) {
			throw new AppGasAguaException(
					"Ocorreu um erro inesperado ao excluir este Login do sistema.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.LoginDAO#fazerLogin
	 * (com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema)
	 */
	@Override
	public boolean fazerLogin(LoginSistema loginSistema)
			throws AppGasAguaException {
		boolean logado = false;
		try {
			if (!session.isOpen()) {
				session = HibernateUtil.getSessionFactory().openSession();
			}
			session.beginTransaction();

			logado = session
					.createQuery(
							"FROM LoginSistema login WHERE login.usuario =:login AND login.senha =:senha")
					.setParameter("login", loginSistema.getUsuario())
					.setParameter("senha", loginSistema.getSenha())
					.uniqueResult() != null;
		} catch (Exception e) {
			throw new AppGasAguaException("Ocorreu um erro ao fazer o login.");
		} finally {
			session.close();
		}

		return logado;
	}

}
