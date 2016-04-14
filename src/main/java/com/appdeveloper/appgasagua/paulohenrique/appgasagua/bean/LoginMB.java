package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.LoginSistema;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.LoginService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.LoginServiceImpl;

/**
 * @author PauloHenrique
 *
 */
@ManagedBean(name = "loginMB")
@ViewAccessScoped
public class LoginMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** A constante NAME. */
    private static final String NAME = "loginMB";
	
	private LoginSistema login;
	private LoginService loginService;
	private BeanNavegacao beanNavegacao;
	private boolean loggedIn;
	
	@PostConstruct
	public void construct() {
		login = new LoginSistema();
		loginService = new LoginServiceImpl();
		beanNavegacao = BeanNavegacao.getInstanciaBean();
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public LoginSistema getLogin() {
		return login;
	}

	public void setLogin(LoginSistema login) {
		this.login = login;
	}

	/**
	 */
	public void actionLogin() {
		FacesMessage message = null;
		loggedIn = false;

		if (!StringUtils.isEmpty(login.getUsuario()) && !StringUtils.isEmpty(login.getSenha())) {
			try {
				loggedIn = loginService.fazerLogin(login);
				if(loggedIn){
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo " + login.getUsuario(),
						login.getUsuario());
				} else {
					message = new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuário ou senha incorreto.", "Erro no login");
				}
			} catch (AppGasAguaException e) {
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro fazer Loggin", "Erro no sistema");
			}
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Usuário ou senha não foram preenchidos.", "Invalid credentials");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		beanNavegacao.getContext().addCallbackParam("loggedIn", loggedIn);
		
		beanNavegacao.setUsuarioLogado(loggedIn);
	}
	
	public static String getName() {
		return NAME;
	}

}
