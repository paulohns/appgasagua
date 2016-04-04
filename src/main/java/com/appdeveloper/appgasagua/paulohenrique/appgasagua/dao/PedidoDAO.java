package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;

/**
 * @author PauloHenrique
 *
 */
public interface PedidoDAO {

	/**
	 * @return
	 * @throws AppGasAguaException
	 */
	List<Pedido> listarPedidos() throws AppGasAguaException;

	/**
	 * @param entity
	 * @throws AppGasAguaException
	 */
	void salvar(Pedido entity) throws AppGasAguaException;

}
