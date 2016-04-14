package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.context.RequestContext;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.FormaPagamentoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.StatusPedidoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.PedidoServiceImpl;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.ProdutoServiceImpl;

@ManagedBean(name="pedidoMB")
@ViewAccessScoped
public class PedidoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PedidoService pedidoService;
	private ProdutoService produtoService;
	private List<Pedido> listaPedidos;
	private Pedido pedidoEmEdicao;
	private Produto gasPedido;
	private Produto aguaPedido;

	private Integer idGasPedido;
	private Integer idAguaPedido;

	private List<Produto> listaProdutoAgua;
	private List<Produto> listaProdutoGas;
	
	
	@PostConstruct
	public void construct(){
		pedidoService = new PedidoServiceImpl();
		produtoService = new ProdutoServiceImpl();
		
		pedidoEmEdicao = new  Pedido(true);
		if(listaPedidos == null){
			listarPedidos();
		}
	}
	
	/**
	 * 
	 */
	public void listarPedidos() {
		
		RequestContext context = RequestContext.getCurrentInstance();
		try {
			listaPedidos = pedidoService.listarPedidos();
			listaProdutoGas = listarProdutos(TipoProdutoEnum.GAS);
			listaProdutoAgua = listarProdutos(TipoProdutoEnum.AGUA);
//			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "listar", "listou nada");
//			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar", "Ocorreu um erro ao listar os pedidos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}
		
	}
	
	public List<Produto> listarProdutos(TipoProdutoEnum tipoProdutoEnum){
		try {
			return produtoService.listarProdutosPorTipo(tipoProdutoEnum);
		} catch (AppGasAguaException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar os produtos", "Ocorreu um erro ao listar os pedidos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return new ArrayList<Produto>();
		}
	}
	
	/**
	 * 
	 */
	public void actionSalvarPedido(){
		
		pedidoEmEdicao.getEndereco().setCep("800293-312");
		pedidoEmEdicao.getEndereco().setCidadeEstado("r43534");
		pedidoEmEdicao.getEndereco().setEndereco("fdfrw4545");
		pedidoEmEdicao.setFormaPgto(FormaPagamentoEnum.CARTAO_DEBITO);
		pedidoEmEdicao.setStatusPedido(StatusPedidoEnum.SOLICITADO);
		pedidoEmEdicao.getEndereco().setNumero(43);
		pedidoEmEdicao.setValorTotalPedido(BigDecimal.TEN);
		Produto aguaPedido = new Produto();
		aguaPedido.setDescricao("agua pedido");
		pedidoEmEdicao.setAguaPedido(aguaPedido );
		Produto gasPedido = new Produto();
		gasPedido.setDescricao("gas pedido");
		pedidoEmEdicao.setGasPedido(gasPedido);
		
//		try {
//			pedidoService.salvar(pedidoEmEdicao );
//		} catch (AppGasAguaException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		listaPedidos.add(pedidoEmEdicao);
	}
	
	public void actionConfirmarPedido(Pedido pedido){
		//fazer metodo service para alterar o status do pedido
		pedido.setStatusPedido(StatusPedidoEnum.AGUARDANDO_ENTREGA);
	}

	public void actionCancelarPedido(Pedido pedido){
		//fazer metodo service para alterar o status do pedido
		pedido.setStatusPedido(StatusPedidoEnum.CANCELADO);
	}
	
	public void actionExcluir(Pedido pedido){
		listaPedidos.remove(pedido);
	}
	
	/**
	 * 
	 */
	public void setaValorItemAgua(){
		if(idAguaPedido != null){
			BigDecimal valor = new BigDecimal(0);
			for (Produto produto : listaProdutoAgua) {
				if(produto.getIdProduto().equals(idAguaPedido)){
					valor = produto.getValor().multiply(BigDecimal.valueOf(pedidoEmEdicao.getQntItemAgua()));
					break;
				}
			}
			aguaPedido.setValor(valor);
		}
	}

	/**
	 * 
	 */
	public void setaValorItemGas(){
		if(idGasPedido != null){
			BigDecimal valor = new BigDecimal(0);
			for (Produto produto : listaProdutoGas) {
				if(produto.getIdProduto().equals(idGasPedido)){
					valor = produto.getValor().multiply(BigDecimal.valueOf(pedidoEmEdicao.getQntItemGas()));
					break;
				}
			}
			gasPedido.setValor(valor);
		}
	}
	
	/**
	 * @return
	 */
	public FormaPagamentoEnum[] getComboFormaPagamento(){
		return FormaPagamentoEnum.values();
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Produto> getListaProdutoAgua() {
		return listaProdutoAgua;
	}

	public void setListaProdutoAgua(List<Produto> listaProdutoAgua) {
		this.listaProdutoAgua = listaProdutoAgua;
	}

	public List<Produto> getListaProdutoGas() {
		return listaProdutoGas;
	}

	public void setListaProdutoGas(List<Produto> listaProdutoGas) {
		this.listaProdutoGas = listaProdutoGas;
	}

	public Pedido getPedidoEmEdicao() {
		return pedidoEmEdicao;
	}

	public void setPedidoEmEdicao(Pedido pedidoEmEdicao) {
		this.pedidoEmEdicao = pedidoEmEdicao;
	}

	public Produto getGasPedido() {
		return gasPedido;
	}

	public void setGasPedido(Produto gasPedido) {
		this.gasPedido = gasPedido;
	}

	public Produto getAguaPedido() {
		return aguaPedido;
	}

	public void setAguaPedido(Produto aguaPedido) {
		this.aguaPedido = aguaPedido;
	}

	public Integer getIdGasPedido() {
		return idGasPedido;
	}

	public void setIdGasPedido(Integer idGasPedido) {
		this.idGasPedido = idGasPedido;
	}

	public Integer getIdAguaPedido() {
		return idAguaPedido;
	}

	public void setIdAguaPedido(Integer idAguaPedido) {
		this.idAguaPedido = idAguaPedido;
	} 
	

}
