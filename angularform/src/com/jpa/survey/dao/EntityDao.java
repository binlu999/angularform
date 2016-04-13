package com.jpa.survey.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jpa.survey.entity.GenericEntity;
import com.jpa.survey.entity.GenericFormEntity;
import com.jpa.survey.entity.SurveyForm;
import com.jpa.util.EntityManagerUtil;

public abstract class EntityDao<T extends GenericEntity> {
	EntityManager em = EntityManagerUtil.getEntityManager();
	private Class<T> clazz;

	protected EntityDao(Class<T> c) {
		this.clazz = c;
	}

	public T save(T entity) {
		em.getTransaction().begin();
		//em.persist(entity);
		
		boolean has = em.contains(entity);
		if(has){
			System.out.println("has=true");
		}else{
			System.out.println("has=false");
		}
		T e=em.merge(entity);
		em.getTransaction().commit();
		return e;
	}

	public T merge(T entity) {
		em.getTransaction().begin();
		T e=em.merge(entity);
		em.getTransaction().commit();
		return e;
	}
	

	public T find(long id) {
		T entity = em.find(clazz, id);
		return entity;
	}
	
	private TypedQuery<T> createTypedQuery(String namedQuery,Map<String, String> parameters){
		/*
		TypedQuery<T> query = this.em.createNamedQuery(namedQuery, clazz);
		if(parameters!=null){
			for(String key:parameters.keySet()){
				query.setParameter(key, parameters.get(key));
			}
		}
		*/
		return null;
	}
	
	protected List<T> runNamedTypedQueryForAll(String namedQuery) {
		em.getTransaction().begin();
		TypedQuery<T> query = createTypedQuery(namedQuery,null);
		List<T> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	protected List<T> runNamedTypedQueryForAll(String namedQuery,Map<String, String> parameters) {
		TypedQuery<T> query = createTypedQuery(namedQuery,parameters);
		List<T> list = query.getResultList();
		return list;
	}
	
	protected T runNamedTypedQueryForSingle(String namedQuery,Map<String, String> parameters) {
		TypedQuery<T> query = createTypedQuery(namedQuery,parameters);
		T e = query.getSingleResult();
		return e;
	}

	protected int runNamedQuery(String namedQuery) {
		em.getTransaction().begin();
		Query query = this.em.createNamedQuery(namedQuery);
		int count=query.executeUpdate();
		em.getTransaction().commit();
		return count;
	}

}
