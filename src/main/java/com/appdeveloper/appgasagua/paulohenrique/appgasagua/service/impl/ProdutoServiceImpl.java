package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.impl;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.ProdutoDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl.ProdutoDAOImpl;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService;

/**
 * @author PauloHenrique
 *
 */
public class ProdutoServiceImpl implements ProdutoService {
	
	private ProdutoDAO produtoDAO = new ProdutoDAOImpl(Produto.class);  

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService#listarProdutos()
	 */
	@Override
	public List<Produto> listarProdutos() throws AppGasAguaException {
		return produtoDAO.listarPedidos();
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService#salvar(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto)
	 */
	@Override
	public void salvar(Produto produto) throws AppGasAguaException {
		produtoDAO.salvar(produto);
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.service.ProdutoService#removerProduto(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto)
	 */
	@Override
	public void removerProduto(Produto protudoSelecionado)
			throws AppGasAguaException {
		produtoDAO.removerProduto(protudoSelecionado);
	}

}
