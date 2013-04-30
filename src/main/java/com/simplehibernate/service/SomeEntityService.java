package com.simplehibernate.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.simplehibernate.model.SomeEntity;


@Repository
public class SomeEntityService {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Transactional
	public void persistSomeEntity(SomeEntity entity){
		entityManager.persist(entity);
	}
	
	
	@Transactional
	public Object getSomeEntity(@SuppressWarnings("rawtypes") Class clazz,Object pk){
		return entityManager.find(clazz, pk);
	}
}
