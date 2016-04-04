package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;

/**
 * @author PauloHenrique
 *
 */
public interface ProdutoDAO {
	
	/**
	 * @return
	 * @throws AppGasAguaException
	 */
	List<Produto> listarPedidos() throws AppGasAguaException;

	/**
	 * @param produto
	 * @throws AppGasAguaException 
	 */
	void salvar(Produto produto) throws AppGasAguaException;

	/**
	 * @param protudoSelecionado
	 */
	void removerProduto(Produto protudoSelecionado)  throws AppGasAguaException;
	
}
