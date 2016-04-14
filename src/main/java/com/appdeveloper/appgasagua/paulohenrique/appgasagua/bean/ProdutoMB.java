package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.context.RequestContext;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.EspecificacaoProdutoEnum;
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
@ViewAccessScoped
public class ProdutoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProdutoService produtoService;
	private List<Produto> listaProdutos;
	private Produto produtoEmEdicao;
	private RequestContext context;
	
	

	public ProdutoMB() {
		super();
		produtoEmEdicao = new Produto();
		
		produtoService = new ProdutoServiceImpl();
		
		if (listaProdutos == null) {
			listarProdutos();
		}

		context = RequestContext.getCurrentInstance();
		
	}

	@PostConstruct
	public void construct() {

		if (BeanNavegacao.getInstanciaBean() == null
				|| !BeanNavegacao.getInstanciaBean().isUsuarioLogado()) {
			return;
		}
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
	public EspecificacaoProdutoEnum[] getComboTipoProduto() {
		return EspecificacaoProdutoEnum.values();
	}

	/**
	 * @return
	 */
	public TipoProdutoEnum[] getComboEspecificacao() {
		return TipoProdutoEnum.values();
	}
	
	/**
	 * @return
	 */
	public static ProdutoMB getInstanciaBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		return (ProdutoMB) context.getExternalContext().getSessionMap()
				.get("produtoMB");
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
