package com.appdeveloper.appgasagua.paulohenrique.appgasagua.service;

import java.util.List;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;
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

	/**
	 * @param tipoProdutoEnum
	 * @return
	 * @throws AppGasAguaException 
	 */
	List<Produto> listarProdutosPorTipo(TipoProdutoEnum tipoProdutoEnum) throws AppGasAguaException;

}
