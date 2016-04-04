<<<<<<< HEAD
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;

/**
 * @author PauloHenrique
 *
 */
public interface ProdutoService {

	/**
	 * @return
	 */
	List<Produto> listarProdutos() throws AppGasAguaException;

	/**
	 * @param produto
	 * @throws AppGasAguaException
	 */
	void salvar(Produto produto) throws AppGasAguaException;

	/**
	 * @param protudoSelecionado
	 * @throws AppGasAguaException
	 */
	void removerProduto(Produto protudoSelecionado)throws AppGasAguaException;

}
=======
package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;

/**
 * @author PauloHenrique
 *
 */
public interface ProdutoService {

	/**
	 * @return
	 */
	List<Produto> listarProdutos() throws AppGasAguaException;

	/**
	 * @param produto
	 * @throws AppGasAguaException
	 */
	void salvar(Produto produto) throws AppGasAguaException;

	/**
	 * @param protudoSelecionado
	 * @throws AppGasAguaException
	 */
	void removerProduto(Produto protudoSelecionado)throws AppGasAguaException;

}
>>>>>>> 8d90bf7ae359e854bffd0431365a1f1a76cca0aa
