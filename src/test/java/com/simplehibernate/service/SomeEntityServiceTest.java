package com.simplehibernate.service;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.simplehibernate.model.SomeEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
@TransactionConfiguration(defaultRollback=true)
public class SomeEntityServiceTest {

	
	@Autowired
	SomeEntityService service;
	
	
	@Test
	public void testServicePersist(){
		SomeEntity entity = new SomeEntity();
		entity.setOrgUnits(new HashSet<String>());
		entity.getOrgUnits().add("TESERT");
		service.persistSomeEntity(entity);
	}
}
