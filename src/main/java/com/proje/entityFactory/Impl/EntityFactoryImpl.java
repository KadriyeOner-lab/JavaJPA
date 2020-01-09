package com.proje.entityFactory.Impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.entityFactory.EntityFactory;

public class EntityFactoryImpl implements EntityFactory {

	@Override
	public EntityManager getEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");

		return factory.createEntityManager();

	}

}
