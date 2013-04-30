package com.simplehibernate.model;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })

public class SomeEntityTest {
	@PersistenceContext
	private EntityManager entityManager;


	private int entityId;
	@Before
	public final void testSaveMap() {
		SomeEntity entity = new SomeEntity();
		entity.setOrgUnits(new HashSet<String>());
		entity.getOrgUnits().add("Test");
		entityManager.persist(entity);
		entityId = entity.getId();
	}
	
	@Transactional
	@Test
	public void testGetMap(){
		SomeEntity entity = entityManager.find(SomeEntity.class, entityId);
		Assert.assertNotNull(entity);
	}
	

}