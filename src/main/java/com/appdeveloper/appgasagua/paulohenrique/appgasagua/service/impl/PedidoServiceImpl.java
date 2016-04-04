<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.PedidoDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl.PedidoDAOImpl;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService;

/**
 * @author PauloHenrique
 *
 */
public class PedidoServiceImpl implements PedidoService{
	
	private PedidoDAO pedidoDAO = new PedidoDAOImpl(Pedido.class);  

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService#listarPedidos()
	 */
	@Override
	public List<Pedido> listarPedidos() throws AppGasAguaException {
		return pedidoDAO.listarPedidos();
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService#addPedido(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido)
	 */
	@Override
	public void salvar(Pedido entity) throws AppGasAguaException {
		pedidoDAO.salvar(entity);
	}

}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.PedidoDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl.PedidoDAOImpl;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService;

/**
 * @author PauloHenrique
 *
 */
public class PedidoServiceImpl implements PedidoService{
	
	private PedidoDAO pedidoDAO = new PedidoDAOImpl(Pedido.class);  

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService#listarPedidos()
	 */
	@Override
	public List<Pedido> listarPedidos() throws AppGasAguaException {
		return pedidoDAO.listarPedidos();
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.PedidoService#addPedido(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido)
	 */
	@Override
	public void salvar(Pedido entity) throws AppGasAguaException {
		pedidoDAO.salvar(entity);
	}

}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
