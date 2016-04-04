package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.PedidoDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido;

/**
 * @author PauloHenrique
 *
 */
@SuppressWarnings("serial")
public class PedidoDAOImpl extends GenericDAO<Pedido> implements PedidoDAO {

	public PedidoDAOImpl(Class<Pedido> entityClass) {
		super(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.PedidoDAO#listarPedidos()
	 */
	@Override
	public List<Pedido> listarPedidos() throws AppGasAguaException{
		return findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.PedidoDAO#salvar(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Pedido)
	 */
	@Override
	public void salvar(Pedido entity) throws AppGasAguaException {
		super.beginTransaction();
		super.save(entity);
		super.commitAndCloseTransaction();
	}

}
