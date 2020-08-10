package com.este.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDaoImpl<E> implements GenericDao<E>{

	@PersistenceContext
	EntityManager em;
	
	private Class<E> type;
	
	public Class<E> getType() {
		return type;
	}

	public void setType(Class<E> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		return em.merge(entity);
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("select t from " + type.getSimpleName() + "t");
		return query.getResultList();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + "t order by " + sortField + " " + sort);
		return query.getResultList();
	}

	@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public E getById(Long id) {
		return em.find(type, id);
	}

	@Override
	public E findOne(String paramName, Object paramValue) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + "t where " + paramName + " = :x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;

	}

	@Override
	public E findOne(String[] paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
