package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;

public interface PedidoService {

	List<Pedido> listarPedidos() throws AppGasAguaException;

	void salvar(Pedido entity) throws AppGasAguaException;
	
}
