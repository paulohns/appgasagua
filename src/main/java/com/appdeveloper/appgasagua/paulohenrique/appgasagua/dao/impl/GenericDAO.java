package com.appdeveloper.appgasagua.paulohenrique.appgasagua.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.appdeveloper.appgasagua.paulohenrique.appgasagua.exception.AppGasAguaException;
import com.appdeveloper.appgasagua.paulohenrique.appgasagua.utils.HibernateUtil;

abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager em;

	// Connection connection = HibernateUtil.getConnection();

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	private Class<T> entityClass;

	public void beginTransaction() {
		session.beginTransaction();
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public void rollback() {
		session.getTransaction().rollback();
	}

	public void closeTransaction() {
		session.getTransaction().commit();
	}

	public void commitAndCloseTransaction() {
		session.getTransaction().commit();
	}

	public void flush() {
		em.flush();
	}

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T entity) throws AppGasAguaException {
		try {
			if (!session.isOpen()) {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
			}

			session.merge(entity);
			commitAndCloseTransaction();

		} catch (Exception e) {
			throw new AppGasAguaException("Ocorreu um erro ao salvar.");
		} finally {
			session.close();
		}
	}

	public void delete(T entity) throws ConstraintViolationException, AppGasAguaException {
		try {
			if (!session.isOpen()) {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
			}
			session.delete(entity);
			commitAndCloseTransaction();
		} catch (Exception e) {
			throw new AppGasAguaException("Ocorreu um erro ao deletar o objeto.");
		} finally {
			session.close();
		}
	}

	public void update(T entity) throws AppGasAguaException {
		session.update(entity);
	}

	public T find(int entityID) throws AppGasAguaException {
		return (T) session.get(entityClass, entityID);
	}

	public T findReferenceOnly(int entityID) throws AppGasAguaException {
		return (T) session.get(entityClass, entityID);
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findByFilter(T entity, Map<String, String> mapBean) throws AppGasAguaException {
		Criteria criteria = session.createCriteria(entityClass);

		List<String> listaChave = new ArrayList<String>();
		List<String> listaValor = new ArrayList<String>();

		for (Entry<String, String> entry : mapBean.entrySet()) {
			listaValor.add(entry.getValue());
			listaChave.add(entry.getKey());
		}

		for (int i = 0; i < mapBean.size(); i++) {
			System.out.println(listaValor.get(i) + " - " + listaChave.get(i));
			criteria.add(Restrictions.like(listaChave.get(i), listaValor.get(i)));
		}

		List<T> result = criteria.list();

		return result;
	}

	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) throws AppGasAguaException {
		T result = null;

		try {
			Query query = em.createNamedQuery(namedQuery);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findAll() throws AppGasAguaException {
		List<T> retorno = null;
		if (!session.isOpen()) {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
		} else {
			session.beginTransaction();
		}
		retorno = session.createCriteria(entityClass).list();
		commitAndCloseTransaction();
		return retorno;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) throws AppGasAguaException {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private List<T> findByNome(String nome) throws AppGasAguaException {
		return session.createCriteria(entityClass).add(Restrictions.ilike("nomeAmbiente", nome)).list();

	}
}
