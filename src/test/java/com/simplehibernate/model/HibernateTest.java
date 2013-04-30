package com.simplehibernate.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class HibernateTest {
	@PersistenceContext
	private EntityManager entityManager;


	@Test
	@Transactional
	@Rollback(value = false)
	public final void testSaveMap() {
		
		SpireAccessionNumberMap map = new SpireAccessionNumberMap();
		SpireCommonAccessionNumber number = new SpireCommonAccessionNumber();
		number.setSpireAccessionNumberMap(map);
		map.getCommonAccessionNumbers().add(number);
		entityManager.persist(map);
		Assert.assertNotNull(map.getId());
	}

}