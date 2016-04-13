package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.ProdutoDAO;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.enums.TipoProdutoEnum;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.utils.HibernateUtil;

/**
 * @author PauloHenrique
 *
 */
@SuppressWarnings("serial")
public class ProdutoDAOImpl extends GenericDAO<Produto> implements ProdutoDAO{

	public ProdutoDAOImpl(Class<Produto> entityClass) {
		super(entityClass);
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.ProdutoDAO#listarPedidos()
	 */
	@Override
	public List<Produto> listarPedidos() throws AppGasAguaException {
		return findAll();
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.ProdutoDAO#salvar(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto)
	 */
	@Override
	public void salvar(Produto produto) throws AppGasAguaException {
		super.save(produto);
	}

	/* (non-Javadoc)
	 * @see com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.ProdutoDAO#removerProduto(com.appdeveloper.appgasagua.paulohenrique.appgasagua.model.Produto)
	 */
	@Override
	public void removerProduto(Produto protudoSelecionado)
			throws AppGasAguaException {
		try{
			super.delete(protudoSelecionado);
		}catch(ConstraintViolationException sqle){
			throw new AppGasAguaException("Não é possivel remover este produto. Esta sendo utilizado em outra tabela.");
		} catch(AppGasAguaException as){
			throw new AppGasAguaException("Ocorreu um erro inesperado ao excluir este produto.");
		}
		
		
	}

	@Override
	public List<Produto> listarProdutosPorTipo(TipoProdutoEnum tipoProdutoEnum) throws AppGasAguaException {
		String sql = "FROM Produto prod WHERE prod.tipoProdutoEnum =:tipoProduto";
		List<Produto> listaProdutos = new ArrayList<Produto>();
		if (!session.isOpen()) {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
		} else {
			session.beginTransaction();
		}
		listaProdutos = (List<Produto>)session.createQuery(sql).setParameter("tipoProduto", tipoProdutoEnum).list();
		closeTransaction();
		return listaProdutos;
	}

}
