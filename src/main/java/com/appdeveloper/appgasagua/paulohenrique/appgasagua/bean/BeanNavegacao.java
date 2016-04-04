<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 * @author PauloHenrique
 *
 */
@ManagedBean(name = "beanNavegacao")
@SessionScoped
public class BeanNavegacao {

	private static final String LOGIN = "/login";

	private static final java.lang.String INICIO = "/index";

	private static final java.lang.String LISTAR_PEDIDOS = "/paginas/listarPedidos";

	private static final java.lang.String CADASTRAR_PEDIDO = "/paginas/cadastrarPedido";

	private static final String CADASTRAR_PRODUTO = "/paginas/cadastrarProduto";

	private static final java.lang.String VISUALIZAR_AVALIACAO = "/paginas/visualizarAvaliacao";

	private RequestContext context;

	private boolean usuarioLogado;

	private String tipoUsuario;

	public BeanNavegacao() {
		context = RequestContext.getCurrentInstance();
	}


	/**
	 * @return
	 */
	public static BeanNavegacao getInstanciaBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (BeanNavegacao) context.getExternalContext().getSessionMap()
				.get("beanNavegacao");
	}

	public void actionValidarLogin() {
		// TODO remover
	}

	/**
	 * @return
	 */
	public static String getInicio() {
		return INICIO;
	}

	/**
	 * @return
	 */
	public static String getFazerLogin() {
		return LOGIN;
	}

	/**
	 * @return
	 */
	public static String getListarPedidos() {
		return LISTAR_PEDIDOS;
	}

	/**
	 * @return
	 */
	public static String getCadastrarPedido() {
		return CADASTRAR_PEDIDO;
	}

	/**
	 * @return
	 */
	public static String getCadastrarProdutos() {
		return CADASTRAR_PRODUTO;
	}

	/**
	 * @return
	 */
	public static String getVisualizarAvaliacao() {
		return VISUALIZAR_AVALIACAO;
	}

	public RequestContext getContext() {
		return context;
	}


	public void setContext(RequestContext context) {
		this.context = context;
	}


	public boolean isUsuarioLogado() {
		return context.getCallbackParams().get("loggedIn") != null
				&& (Boolean) context.getCallbackParams().get("loggedIn");
	}
	
	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public java.lang.String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(java.lang.String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 * @author PauloHenrique
 *
 */
@ManagedBean(name = "beanNavegacao")
@SessionScoped
public class BeanNavegacao {

	private static final String LOGIN = "/login";

	private static final java.lang.String INICIO = "/index";

	private static final java.lang.String LISTAR_PEDIDOS = "/paginas/listarPedidos";

	private static final java.lang.String CADASTRAR_PEDIDO = "/paginas/cadastrarPedido";

	private static final String CADASTRAR_PRODUTO = "/paginas/cadastrarProduto";

	private static final java.lang.String VISUALIZAR_AVALIACAO = "/paginas/visualizarAvaliacao";

	private RequestContext context;

	private boolean usuarioLogado;

	private String tipoUsuario;

	public BeanNavegacao() {
		context = RequestContext.getCurrentInstance();
	}


	/**
	 * @return
	 */
	public static BeanNavegacao getInstanciaBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (BeanNavegacao) context.getExternalContext().getSessionMap()
				.get("beanNavegacao");
	}

	public void actionValidarLogin() {
		// TODO remover
	}

	/**
	 * @return
	 */
	public static String getInicio() {
		return INICIO;
	}

	/**
	 * @return
	 */
	public static String getFazerLogin() {
		return LOGIN;
	}

	/**
	 * @return
	 */
	public static String getListarPedidos() {
		return LISTAR_PEDIDOS;
	}

	/**
	 * @return
	 */
	public static String getCadastrarPedido() {
		return CADASTRAR_PEDIDO;
	}

	/**
	 * @return
	 */
	public static String getCadastrarProdutos() {
		return CADASTRAR_PRODUTO;
	}

	/**
	 * @return
	 */
	public static String getVisualizarAvaliacao() {
		return VISUALIZAR_AVALIACAO;
	}

	public RequestContext getContext() {
		return context;
	}


	public void setContext(RequestContext context) {
		this.context = context;
	}


	public boolean isUsuarioLogado() {
		return context.getCallbackParams().get("loggedIn") != null
				&& (Boolean) context.getCallbackParams().get("loggedIn");
	}
	
	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public java.lang.String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(java.lang.String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
