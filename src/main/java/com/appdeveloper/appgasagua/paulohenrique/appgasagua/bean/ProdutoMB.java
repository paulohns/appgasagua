<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.EspecificacaoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.ProdutoServiceImpl;

/**
 * @author PauloHenrique
 *
 */
@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoMB {

	private ProdutoService produtoService;
	private List<Produto> listaProdutos;
	private Produto produtoEmEdicao;
	private RequestContext context;

	@PostConstruct
	public void construct() {

		produtoEmEdicao = new Produto();
		if (BeanNavegacao.getInstanciaBean() == null
				|| !BeanNavegacao.getInstanciaBean().isUsuarioLogado()) {
			return;
		}

		produtoService = new ProdutoServiceImpl();

		if (listaProdutos == null) {
			listarProdutos();
		}

		context = RequestContext.getCurrentInstance();
	}

	/**
	 * 
	 */
	public void listarProdutos() {
		try {
			listaProdutos = produtoService.listarProdutos();
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro ao listar", "Ocorreu um erro ao listar os pedidos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}

	/**
	 * 
	 */
	public void actionAddPedido() {
		try {
			produtoService.salvar(produtoEmEdicao);
			produtoEmEdicao = new Produto();
			listarProdutos();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto salvo com sucesso.", "SALVAR");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro ao salvar o produto", "Erro ao salvar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}

	/**
	 * @param produdoSelecionado
	 */
	public void actionExcluir(Produto produdoSelecionado) {

		try {
			produtoService.removerProduto(produdoSelecionado);
			listaProdutos.remove(produdoSelecionado);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto removido com sucesso.", "REMOVER");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					e.getMessage(), "Erro ao salvar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}
	
	public void actionAlterar(Produto produtoSelecionado){
		produtoEmEdicao = produtoSelecionado;
	}

	/**
	 * @return
	 */
	public TipoProdutoEnum[] getComboTipoProduto() {
		return TipoProdutoEnum.values();
	}

	/**
	 * @return
	 */
	public EspecificacaoEnum[] getComboEspecificacao() {
		return EspecificacaoEnum.values();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Produto getProdutoEmEdicao() {
		return produtoEmEdicao;
	}

	public void setProdutoEmEdicao(Produto produtoEmEdicao) {
		this.produtoEmEdicao = produtoEmEdicao;
	}

}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.EspecificacaoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.ProdutoServiceImpl;

/**
 * @author PauloHenrique
 *
 */
@ManagedBean(name = "produtoMB")
@ViewScoped
public class ProdutoMB {

	private ProdutoService produtoService;
	private List<Produto> listaProdutos;
	private Produto produtoEmEdicao;
	private RequestContext context;

	@PostConstruct
	public void construct() {

		produtoEmEdicao = new Produto();
		if (BeanNavegacao.getInstanciaBean() == null
				|| !BeanNavegacao.getInstanciaBean().isUsuarioLogado()) {
			return;
		}

		produtoService = new ProdutoServiceImpl();

		if (listaProdutos == null) {
			listarProdutos();
		}

		context = RequestContext.getCurrentInstance();
	}

	/**
	 * 
	 */
	public void listarProdutos() {
		try {
			listaProdutos = produtoService.listarProdutos();
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Erro ao listar", "Ocorreu um erro ao listar os pedidos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}

	/**
	 * 
	 */
	public void actionAddPedido() {
		try {
			produtoService.salvar(produtoEmEdicao);
			produtoEmEdicao = new Produto();
			listarProdutos();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto salvo com sucesso.", "SALVAR");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro ao salvar o produto", "Erro ao salvar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}

	/**
	 * @param protudoSelecionado
	 */
	public void actionExcluir(Produto protudoSelecionado) {

		try {
			produtoService.removerProduto(protudoSelecionado);
			listaProdutos.remove(protudoSelecionado);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Produto removido com sucesso.", "REMOVER");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					e.getMessage(), "Erro ao salvar");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}

	}

	/**
	 * @return
	 */
	public TipoProdutoEnum[] getComboTipoProduto() {
		return TipoProdutoEnum.values();
	}

	/**
	 * @return
	 */
	public EspecificacaoEnum[] getComboEspecificacao() {
		return EspecificacaoEnum.values();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Produto getProdutoEmEdicao() {
		return produtoEmEdicao;
	}

	public void setProdutoEmEdicao(Produto produtoEmEdicao) {
		this.produtoEmEdicao = produtoEmEdicao;
	}

}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
