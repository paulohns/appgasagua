package com.appdeveloper.appgasagua.paulohenrique.appgasagua.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.FormaPagamentoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.StatusPedidoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl.PedidoServiceImpl;

@ManagedBean(name="pedidoMB")
@ViewScoped
public class PedidoMB {
	
	private PedidoService pedidoService;
	private List<Pedido> listaPedidos;
	private Pedido pedidoEmEdicao;
	
	
	@PostConstruct
	public void construct(){
		pedidoService = new PedidoServiceImpl();
		pedidoEmEdicao = new  Pedido();
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
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "listar", "listou nada");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (AppGasAguaException e) {
			System.out.println("passou aqui! com erro");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao listar", "Ocorreu um erro ao listar os pedidos");
			
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", false);
		}
		
	}
	
	/**
	 * 
	 */
	public void addPedido(){
		
		pedidoEmEdicao.getEndereco().setCep("800293-312");
		pedidoEmEdicao.getEndereco().setCidadeEstado("r43534");
		pedidoEmEdicao.getEndereco().setEndereco("fdfrw4545");
		pedidoEmEdicao.setFormaPgto(FormaPagamentoEnum.CARTAO);
		pedidoEmEdicao.setStatusPedido(StatusPedidoEnum.SOLICITADO);
		pedidoEmEdicao.getEndereco().setNumero(43);
		
		try {
			pedidoService.salvar(pedidoEmEdicao );
		} catch (AppGasAguaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void actionConfirmarPedido(Pedido pedido){
		//fazer metodo service para alterar o status do pedido
		pedido.setStatusPedido(StatusPedidoEnum.AGUARDANDO_ENTREGA);
	}

	public void actionCancelarPedido(Pedido pedido){
		//fazer metodo service para alterar o status do pedido
		pedido.setStatusPedido(StatusPedidoEnum.CANCELADO);
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public Pedido getPedidoEmEdicao() {
		return pedidoEmEdicao;
	}

	public void setPedidoEmEdicao(Pedido pedidoEmEdicao) {
		this.pedidoEmEdicao = pedidoEmEdicao;
	} 
	

}
